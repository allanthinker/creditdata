package com.allan.creditdatapp.parser;

import java.io.File;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.allan.creditdatapp.AppConstant;
import com.allan.creditdatapp.AppUtil;
import com.allan.creditdatapp.model.ENTBaseInfo;
import com.allan.creditdatapp.model.ENTJudicialDecision;

public class ENTJudicialDecisionParser extends CreditExcelFileParser {

    private static final Logger LOGGER = LogManager
            .getLogger(LogManager.getLogger(ENTJudicialDecisionParser.class.getName()));

    public ENTJudicialDecisionParser(File file) {
        super(file);
    }

    @Override
    public String getFileType() {
        return AppConstant.ENT_JUDICIAL_DECISION;
    }

    @Override
    public ENTBaseInfo parse(Row row, UUID uuid) {
        ENTJudicialDecision entJudicialDecision = new ENTJudicialDecision();

        boolean isJudgmentCaseNumExist = false;
        String judgmentCaseNum = row.getCell(4).getStringCellValue().trim();
        if (judgmentCaseNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(案号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isJudgmentCaseNumExist = true;
            entJudicialDecision.setJudgmentCaseNum(judgmentCaseNum);
        }

        boolean isExecutionCourtExist = false;
        String executionCourt = row.getCell(5).getStringCellValue().trim();
        if (executionCourt.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(执行法院) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isExecutionCourtExist = true;
            entJudicialDecision.setExecutionCourt(executionCourt);
        }

        boolean isJudgmentReasonExist = false;
        String judgmentReason = row.getCell(6).getStringCellValue().trim();
        if (judgmentReason.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(执行案由) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isJudgmentReasonExist = true;
            entJudicialDecision.setJudgmentReason(judgmentReason);
        }

        boolean isJudgmentDocNumExist = false;
        String judgmentDocNum = row.getCell(7).getStringCellValue().trim();
        if (judgmentDocNum.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(执行依据文书编号) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isJudgmentDocNumExist = true;
            entJudicialDecision.setJudgmentDocNum(judgmentDocNum);
        }

        boolean isFiledDateExist = false;
        String filedDate = row.getCell(8).getStringCellValue().trim();
        if (filedDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(立案日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isFiledDateExist = true;
            entJudicialDecision.setFiledDate(filedDate);
        }

        String applyPrice = row.getCell(9).getStringCellValue();
        entJudicialDecision.setApplyPrice(applyPrice);

        boolean isCaseStatusExist = false;
        String caseStatus = row.getCell(10).getStringCellValue().trim();
        if (caseStatus.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(执行状态) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isCaseStatusExist = true;
            entJudicialDecision.setCaseStatus(caseStatus);
        }

        String finalPrice = row.getCell(11).getStringCellValue();
        entJudicialDecision.setFinalPrice(finalPrice);

        boolean isCloseCaseDateExist = false;
        String closeCaseDate = row.getCell(12).getStringCellValue().trim();
        if (closeCaseDate.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(结案日期) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isCloseCaseDateExist = true;
            entJudicialDecision.setCloseCaseDate(closeCaseDate);
        }

        boolean isCloseCaseTypeExist = false;
        String closeCaseType = row.getCell(13).getStringCellValue().trim();
        if (closeCaseType.length() == 0) {
            LOGGER.warn(AppUtil.getFTID(uuid) + "DETECTED A CELL(结案方式) WITH NULL VALUE.[" + this.targetFile.getName() + " -> ROW:"
                    + row.getRowNum() + "]");
        } else {
            isCloseCaseTypeExist = true;
            entJudicialDecision.setCloseCaseType(closeCaseType);
        }

        String comments = row.getCell(14).getStringCellValue();
        entJudicialDecision.setComments(comments);

        if (isCaseStatusExist && isCloseCaseDateExist && isCloseCaseTypeExist && isExecutionCourtExist
                && isFiledDateExist && isJudgmentCaseNumExist && isJudgmentDocNumExist && isJudgmentReasonExist) {
            return entJudicialDecision;
        }

        return null;
    }

}
