package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.model.ENTSeriousViolationOfLaw;

public class ENTSeriousViolationOfLawParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(ENTSeriousViolationOfLawParser.class.getName()));

    public ENTSeriousViolationOfLawParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_SERIOUS_VIOLATION_OF_LAW;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTSeriousViolationOfLaw entSeriousViolationOfLaw = new ENTSeriousViolationOfLaw();

        boolean isblackListTypeExist = false;
        String blackListType = row.getCell(4).getStringCellValue().trim();
        if (blackListType.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(黑名单类型) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isblackListTypeExist = true;
            entSeriousViolationOfLaw.setBlackListType(blackListType);
        }

        boolean isRecordDocNumExist = false;
        String recordDocNum = row.getCell(5).getStringCellValue().trim();
        if (recordDocNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(列入文书编号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isRecordDocNumExist = true;
            entSeriousViolationOfLaw.setRecordDocNum(recordDocNum);
        }

        boolean isRecordReasonExist = false;
        String recordReason = row.getCell(6).getStringCellValue().trim();
        if (recordReason.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(列入原因) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isRecordReasonExist = true;
            entSeriousViolationOfLaw.setRecordReason(recordReason);
        }

        String recordBasis = row.getCell(7).getStringCellValue();
        entSeriousViolationOfLaw.setRecordBasis(recordBasis);

        boolean isRecordDateExist = false;
        String recordDate = row.getCell(8).getStringCellValue().trim();
        if (recordDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(列入日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isRecordDateExist = true;
            entSeriousViolationOfLaw.setRecordDate(recordDate);
        }

        boolean isRecordExpirationExist = false;
        String recordExpiration = row.getCell(9).getStringCellValue().trim();
        if (recordExpiration.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(截止日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isRecordExpirationExist = true;
            entSeriousViolationOfLaw.setRecordExpiration(recordExpiration);
        }

        boolean isRecordOfficeExist = false;
        String recordOffice = row.getCell(10).getStringCellValue().trim();
        if (recordOffice.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(列入机关) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isRecordOfficeExist = true;
            entSeriousViolationOfLaw.setRecordOffice(recordOffice);
        }

        String comments = row.getCell(11).getStringCellValue();
        entSeriousViolationOfLaw.setComments(comments);

        if (isblackListTypeExist && isRecordDateExist && isRecordDocNumExist && isRecordExpirationExist
                && isRecordOfficeExist && isRecordReasonExist) {
            return entSeriousViolationOfLaw;
        }

        return null;
    }

}
