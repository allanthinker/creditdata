package com.allan.creditdatapp.model;

/**
 * 企业分类监管信息模型
 * <P>
 * E.5 评价名称 evaluateName 必选<BR>
 * F.6 评价结果 evaluateResult <BR>
 * G.7 评价日期 evaluateDate 必选<BR>
 * H.8 评价依据 evaluateBasis <BR>
 * I.9 评价文号 evaluateReferenceNum 必选<BR>
 * J.10 评价机构 evaluateAgency 必选<BR>
 * K.11 备注 comments <BR>
 * 
 * @author Allan
 *
 */
public class ENTClassificationRegulation extends ENTBaseInfo {

    /**
     * E.5 评价名称，必选
     */
    private String evaluateName;

    /**
     * F.6 评价结果
     */
    private String evaluateResult;

    /**
     * G.7 评价日期，必选
     */
    private String evaluateDate;

    /**
     * H.8 评价依据
     */
    private String evaluateBasis;

    /**
     * I.9 评价文号，必选
     */
    private String evaluateReferenceNum;

    /**
     * J.10 评价机构，必选
     */
    private String evaluateAgency;

    /**
     * K.11 备注
     */
    private String comments;

    public String getEvaluateName() {
        return evaluateName;
    }

    public void setEvaluateName(String evaluateName) {
        this.evaluateName = evaluateName;
    }

    public String getEvaluateResult() {
        return evaluateResult;
    }

    public void setEvaluateResult(String evaluateResult) {
        this.evaluateResult = evaluateResult;
    }

    public String getEvaluateDate() {
        return evaluateDate;
    }

    public void setEvaluateDate(String evaluateDate) {
        this.evaluateDate = evaluateDate;
    }

    public String getEvaluateBasis() {
        return evaluateBasis;
    }

    public void setEvaluateBasis(String evaluateBasis) {
        this.evaluateBasis = evaluateBasis;
    }

    public String getEvaluateReferenceNum() {
        return evaluateReferenceNum;
    }

    public void setEvaluateReferenceNum(String evaluateReferenceNum) {
        this.evaluateReferenceNum = evaluateReferenceNum;
    }

    public String getEvaluateAgency() {
        return evaluateAgency;
    }

    public void setEvaluateAgency(String evaluateAgency) {
        this.evaluateAgency = evaluateAgency;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
