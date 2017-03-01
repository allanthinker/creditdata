package com.allan.creditdatapp.model;

/**
 * 企业司法判决信息模型
 * <P>
 * E.5 案号 judgmentCaseNum 必选<BR>
 * F.6 执行法院 executionCourt 必选<BR>
 * G.7 执行案由 judgmentReason 必选<BR>
 * H.8 执行依据文书编号 judgmentDocNum 必选<BR>
 * I.9 立案日期 filedDate 必选<BR>
 * J.10 申请标的（元） applyPrice<BR>
 * K.11 执行状态 caseStatus 必选<BR>
 * L.12 到位标的 finalPrice<BR>
 * M.13 结案日期 closeCaseDate 必选<BR>
 * N.14 结案方式 closeCaseType 必选<BR>
 * O.15 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTJudicialDecision extends ENTBaseInfo {

    /**
     * E.5 案号，必选
     */
    private String judgmentCaseNum;

    /**
     * F.6 执行法院，必选
     */
    private String executionCourt;

    /**
     * G.7 执行案由，必选
     */
    private String judgmentReason;

    /**
     * H.8 执行依据文书编号，必选
     */
    private String judgmentDocNum;

    /**
     * I.9 立案日期，必选
     */
    private String filedDate;

    /**
     * J.10 申请标的（元）
     */
    private String applyPrice;

    /**
     * K.11 执行状态，必选
     */
    private String caseStatus;

    /**
     * L.12 到位标的
     */
    private String finalPrice;

    /**
     * M.13 结案日期，必选
     */
    private String closeCaseDate;

    /**
     * N.14 结案方式，必选
     */
    private String closeCaseType;

    /**
     * O.15 备注
     */
    private String comments;

    public String getJudgmentCaseNum() {
        return judgmentCaseNum;
    }

    public void setJudgmentCaseNum(String judgmentCaseNum) {
        this.judgmentCaseNum = judgmentCaseNum;
    }

    public String getExecutionCourt() {
        return executionCourt;
    }

    public void setExecutionCourt(String executionCourt) {
        this.executionCourt = executionCourt;
    }

    public String getJudgmentReason() {
        return judgmentReason;
    }

    public void setJudgmentReason(String judgmentReason) {
        this.judgmentReason = judgmentReason;
    }

    public String getJudgmentDocNum() {
        return judgmentDocNum;
    }

    public void setJudgmentDocNum(String judgmentDocNum) {
        this.judgmentDocNum = judgmentDocNum;
    }

    public String getFiledDate() {
        return filedDate;
    }

    public void setFiledDate(String filedDate) {
        this.filedDate = filedDate;
    }

    public String getApplyPrice() {
        return applyPrice;
    }

    public void setApplyPrice(String applyPrice) {
        this.applyPrice = applyPrice;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getCloseCaseDate() {
        return closeCaseDate;
    }

    public void setCloseCaseDate(String closeCaseDate) {
        this.closeCaseDate = closeCaseDate;
    }

    public String getCloseCaseType() {
        return closeCaseType;
    }

    public void setCloseCaseType(String closeCaseType) {
        this.closeCaseType = closeCaseType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
