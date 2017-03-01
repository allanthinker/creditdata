package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTAdministrativePermit;
import com.allan.creditdatapp.model.ENTBaseInfo;

public class ENTAdministrativePermitParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(ENTAdministrativePermitParser.class.getName()));

    public ENTAdministrativePermitParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_ADMINISTRATIVE_PERMIT;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTAdministrativePermit entAdministrativePermit = new ENTAdministrativePermit();

        boolean isPermitDocNameExist = false;
        String permitDocName = row.getCell(4).getStringCellValue().trim();
        if (permitDocName.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(许可文件名称) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPermitDocNameExist = true;
            entAdministrativePermit.setPermitDocName(permitDocName);
        }

        boolean isPermitDocNumExist = false;
        String permitDocNum = row.getCell(5).getStringCellValue().trim();
        if (permitDocNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(许可编号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPermitDocNumExist = true;
            entAdministrativePermit.setPermitDocNum(permitDocNum);
        }

        String permitType = row.getCell(6).getStringCellValue();
        entAdministrativePermit.setPermitType(permitType);

        boolean isPermitDetailExist = false;
        String permitDetail = row.getCell(7).getStringCellValue().trim();
        if (permitDetail.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(许可内容) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPermitDetailExist = true;
            entAdministrativePermit.setPermitDetail(permitDetail);
        }

        boolean isPermitDateExist = false;
        String permitDate = row.getCell(8).getStringCellValue().trim();
        if (permitDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(许可日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPermitDateExist = true;
            entAdministrativePermit.setPermitDate(permitDate);
        }

        boolean isPermitPeriodOfValidityExist = false;
        String permitPeriodOfValidity = row.getCell(9).getStringCellValue().trim();
        if (permitPeriodOfValidity.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(有效期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPermitPeriodOfValidityExist = true;
            entAdministrativePermit.setPermitPeriodOfValidity(permitPeriodOfValidity);
        }

        boolean isPermitOfficeExist = false;
        String permitOffice = row.getCell(10).getStringCellValue().trim();
        if (permitOffice.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(许可机关) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPermitOfficeExist = true;
            entAdministrativePermit.setPermitOffice(permitOffice);
        }

        String comments = row.getCell(11).getStringCellValue();
        entAdministrativePermit.setComments(comments);

        if (isPermitDocNameExist && isPermitDocNumExist && isPermitDetailExist && isPermitDateExist
                && isPermitPeriodOfValidityExist && isPermitOfficeExist) {
            return entAdministrativePermit;
        }

        return null;
    }

}
