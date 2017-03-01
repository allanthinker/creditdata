package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.model.ENTClassificationRegulation;

public class ENTClassificationRegulationParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(ENTClassificationRegulationParser.class.getName()));

    public ENTClassificationRegulationParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_CLASSIFICATION_REGULATION;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTClassificationRegulation entClassificationRegulation = new ENTClassificationRegulation();

        boolean isEvaluateNameExist = false;
        String evaluateName = row.getCell(4).getStringCellValue().trim();
        if (evaluateName.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(评价名称) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isEvaluateNameExist = true;
            entClassificationRegulation.setEvaluateName(evaluateName);
        }

        String evaluateResult = row.getCell(5).getStringCellValue();
        entClassificationRegulation.setEvaluateResult(evaluateResult);

        boolean isEvaluateDateExist = false;
        String evaluateDate = row.getCell(6).getStringCellValue().trim();
        if (evaluateDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(评价日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isEvaluateDateExist = true;
            entClassificationRegulation.setEvaluateDate(evaluateDate);
        }

        String evaluateBasis = row.getCell(7).getStringCellValue();
        entClassificationRegulation.setEvaluateBasis(evaluateBasis);

        boolean isEvaluateReferenceNumExist = false;
        String evaluateReferenceNum = row.getCell(8).getStringCellValue();
        if (evaluateReferenceNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(评价文号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isEvaluateReferenceNumExist = true;
            entClassificationRegulation.setEvaluateReferenceNum(evaluateReferenceNum);
        }

        boolean isEvaluateAgencyExist = false;
        String evaluateAgency = row.getCell(9).getStringCellValue();
        if (evaluateAgency.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(评价机构) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isEvaluateAgencyExist = true;
            entClassificationRegulation.setEvaluateAgency(evaluateAgency);
        }

        String comments = row.getCell(10).getStringCellValue();
        entClassificationRegulation.setComments(comments);

        if (isEvaluateNameExist && isEvaluateDateExist && isEvaluateReferenceNumExist && isEvaluateAgencyExist) {
            return entClassificationRegulation;
        }
        return null;
    }

}
