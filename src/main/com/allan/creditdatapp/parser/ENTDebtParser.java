package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.model.ENTDebt;

public class ENTDebtParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager.getLogger(LogManager.getLogger(ENTDebtParser.class.getName()));

    public ENTDebtParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_DEBT;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTDebt entDebt = new ENTDebt();

        boolean isDebtTypeExist = false;
        String debtType = row.getCell(4).getStringCellValue().trim();
        if (debtType.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(欠费种类) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isDebtTypeExist = true;
            entDebt.setDebtType(debtType);
        }

        boolean isDebtPeriodExist = false;
        String debtPeriod = row.getCell(5).getStringCellValue().trim();
        if (debtPeriod.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(欠费时段) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isDebtPeriodExist = true;
            entDebt.setDebtPeriod(debtPeriod);
        }

        String debtAmount = row.getCell(6).getStringCellValue();
        entDebt.setDebtAmount(debtAmount);

        boolean isDebtRecordOfficeExist = false;
        String debtRecordOffice = row.getCell(7).getStringCellValue().trim();
        if (debtRecordOffice.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(记录单位) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isDebtRecordOfficeExist = true;
            entDebt.setDebtRecordOffice(debtRecordOffice);
        }

        String comments = row.getCell(8).getStringCellValue();
        entDebt.setComments(comments);

        if (isDebtTypeExist && isDebtPeriodExist && isDebtRecordOfficeExist) {
            return entDebt;
        }

        return null;
    }

}
