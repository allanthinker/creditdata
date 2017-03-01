package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTAward;
import com.allan.creditdatapp.model.ENTBaseInfo;

public class ENTAwardParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager.getLogger(LogManager.getLogger(ENTAwardParser.class.getName()));

    public ENTAwardParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_AWARD;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTAward entAward = new ENTAward();

        boolean isAwardNameExist = false;
        String awardName = row.getCell(4).getStringCellValue().trim();
        if (awardName.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(荣誉称谓) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isAwardNameExist = true;
            entAward.setAwardName(awardName);
        }

        boolean isAwardDocNumExist = false;
        String awardDocNum = row.getCell(5).getStringCellValue().trim();
        if (awardDocNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(文书编号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isAwardDocNumExist = true;
            entAward.setAwardDocNum(awardDocNum);
        }

        String awardDetail = row.getCell(6).getStringCellValue();
        entAward.setAwardDetail(awardDetail);

        boolean isAwardAffirmDateExist = false;
        String awardAffirmDate = row.getCell(7).getStringCellValue().trim();
        if (awardAffirmDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(认定日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isAwardAffirmDateExist = true;
            entAward.setAwardAffirmDate(awardAffirmDate);
        }

        boolean isAwardOfficeExist = false;
        String awardOffice = row.getCell(8).getStringCellValue().trim();
        if (awardOffice.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(颁发机构) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isAwardOfficeExist = true;
            entAward.setAwardOffice(awardOffice);
        }

        String comments = row.getCell(9).getStringCellValue();
        entAward.setComments(comments);

        if (isAwardNameExist && isAwardDocNumExist && isAwardAffirmDateExist && isAwardOfficeExist) {
            return entAward;
        }

        return null;
    }

}
