package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.model.ENTInspectionTest;

public class ENTInspectionTestParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(ENTInspectionTestParser.class.getName()));

    public ENTInspectionTestParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_INSPECTION_TEST;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTInspectionTest entInspectionTest = new ENTInspectionTest();

        boolean isInspectTypeExist = false;
        String inspectType = row.getCell(4).getStringCellValue().trim();
        if (inspectType.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(检验检测类型) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isInspectTypeExist = true;
            entInspectionTest.setInspectType(inspectType);
        }

        String inspectYear = row.getCell(5).getStringCellValue();
        entInspectionTest.setInspectYear(inspectYear);

        boolean isInspectDetailExist = false;
        String inspectDetail = row.getCell(6).getStringCellValue().trim();
        if (inspectDetail.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(检验检测内容) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isInspectDetailExist = true;
            entInspectionTest.setInspectDetail(inspectDetail);
        }

        boolean isInspectResultExist = false;
        String inspectResult = row.getCell(7).getStringCellValue().trim();
        if (inspectResult.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(检验检测结果) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isInspectResultExist = true;
            entInspectionTest.setInspectResult(inspectResult);
        }

        boolean isInspectDateExist = false;
        String inspectDate = row.getCell(8).getStringCellValue().trim();
        if (inspectDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(检验检测日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isInspectDateExist = true;
            entInspectionTest.setInspectDate(inspectDate);
        }

        boolean isInspectAgencyExist = false;
        String inspectAgency = row.getCell(9).getStringCellValue().trim();
        if (inspectAgency.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(检验检测机构) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isInspectAgencyExist = true;
            entInspectionTest.setInspectAgency(inspectAgency);
        }

        boolean isInspectOfficeExist = false;
        String inspectOffice = row.getCell(10).getStringCellValue().trim();
        if (inspectOffice.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(送检单位) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isInspectOfficeExist = true;
            entInspectionTest.setInspectOffice(inspectOffice);
        }

        String comments = row.getCell(11).getStringCellValue();
        entInspectionTest.setComments(comments);

        if (isInspectAgencyExist && isInspectDateExist && isInspectDetailExist && isInspectOfficeExist
                && isInspectResultExist && isInspectTypeExist) {
            return entInspectionTest;
        }

        return null;
    }

}
