package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTAdministrativePenalty;
import com.allan.creditdatapp.model.ENTBaseInfo;

public class ENTAdministrativePenaltyParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(ENTAdministrativePenaltyParser.class.getName()));

    public ENTAdministrativePenaltyParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_ADMINISTRATIVE_PENALTY;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTAdministrativePenalty entAdministrativePenalty = new ENTAdministrativePenalty();

        boolean isPenaltyReferenceNumExist = false;
        String penaltyReferenceNum = row.getCell(4).getStringCellValue().trim();
        if (penaltyReferenceNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(处罚文书编号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPenaltyReferenceNumExist = true;
            entAdministrativePenalty.setPenaltyReferenceNum(penaltyReferenceNum);
        }

        boolean isPenaltyTypeExist = false;
        String penaltyType = row.getCell(5).getStringCellValue().trim();
        if (penaltyType.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(违法行为类型) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPenaltyTypeExist = true;
            entAdministrativePenalty.setPenaltyType(penaltyType);
        }

        String penaltyReason = row.getCell(6).getStringCellValue();
        entAdministrativePenalty.setPenaltyReason(penaltyReason);

        boolean isPenaltyDetailExist = false;
        String penaltyDetail = row.getCell(7).getStringCellValue().trim();
        if (penaltyDetail.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(处罚内容) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPenaltyDetailExist = true;
            entAdministrativePenalty.setPenaltyDetail(penaltyDetail);
        }

        boolean isPenaltyDateExist = false;
        String penaltyDate = row.getCell(8).getStringCellValue().trim();
        if (penaltyDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(处罚日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPenaltyDateExist = true;
            entAdministrativePenalty.setPenaltyDate(penaltyDate);
        }

        boolean isPenaltyOfficeExist = false;
        String penaltyOffice = row.getCell(9).getStringCellValue().trim();
        if (penaltyOffice.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(处罚机关) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isPenaltyOfficeExist = true;
            entAdministrativePenalty.setPenaltyOffice(penaltyOffice);
        }

        String comments = row.getCell(10).getStringCellValue();
        entAdministrativePenalty.setComments(comments);

        if (isPenaltyReferenceNumExist && isPenaltyTypeExist && isPenaltyDateExist && isPenaltyDetailExist
                && isPenaltyOfficeExist) {
            return entAdministrativePenalty;
        }
        return null;
    }

}
