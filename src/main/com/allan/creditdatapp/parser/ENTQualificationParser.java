package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.model.ENTQualification;

public class ENTQualificationParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(ENTQualificationParser.class.getName()));

    public ENTQualificationParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_QUALIFICATION;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTQualification entQualification = new ENTQualification();

        boolean isQualificationNameExist = false;
        String qualificationName = row.getCell(4).getStringCellValue().trim();
        if (qualificationName.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(资质名称) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isQualificationNameExist = true;
            entQualification.setQualificationName(qualificationName);
        }

        boolean isQualificationCertNumExist = false;
        String qualificationCertNum = row.getCell(5).getStringCellValue().trim();
        if (qualificationCertNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(资质证书号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isQualificationCertNumExist = true;
            entQualification.setQualificationCertNum(qualificationCertNum);
        }

        boolean isQualificationLevelExist = false;
        String qualificationLevel = row.getCell(6).getStringCellValue().trim();
        if (qualificationLevel.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(资质等级) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isQualificationLevelExist = true;
            entQualification.setQualificationLevel(qualificationLevel);
        }

        boolean isQualificationDetailExist = false;
        String qualificationDetail = row.getCell(7).getStringCellValue().trim();
        if (qualificationDetail.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(资质内容) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isQualificationDetailExist = true;
            entQualification.setQualificationDetail(qualificationDetail);
        }

        boolean isQualificationAffirmDateExist = false;
        String qualificationAffirmDate = row.getCell(8).getStringCellValue().trim();
        if (qualificationAffirmDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(核发日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isQualificationAffirmDateExist = true;
            entQualification.setQualificationAffirmDate(qualificationAffirmDate);
        }

        boolean isQualificationPeriodOfValidityExist = false;
        String qualificationPeriodOfValidity = row.getCell(9).getStringCellValue().trim();
        if (qualificationPeriodOfValidity.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(有效期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isQualificationPeriodOfValidityExist = true;
            entQualification.setQualificationPeriodOfValidity(qualificationPeriodOfValidity);
        }

        boolean isQualificationAffirmOfficeExist = true;
        String qualificationAffirmOffice = row.getCell(10).getStringCellValue().trim();
        if (qualificationAffirmOffice.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(核发机关) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isQualificationAffirmOfficeExist = true;
            entQualification.setQualificationAffirmOffice(qualificationAffirmOffice);
        }

        String comments = row.getCell(11).getStringCellValue();
        entQualification.setComments(comments);

        if (isQualificationAffirmDateExist && isQualificationAffirmOfficeExist && isQualificationCertNumExist
                && isQualificationDetailExist && isQualificationLevelExist && isQualificationNameExist
                && isQualificationPeriodOfValidityExist) {
            return entQualification;
        }

        return null;
    }

}
