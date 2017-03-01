package com.allan.creditdatapp.model;

/**
 * 企业行政处罚信息模型
 * <P>
 * E.4 处罚文书编号 penaltyReferenceNum 必选<BR>
 * F.5 违法行为类型 penaltyType 必选<BR>
 * G.6 处罚事由 penaltyReason<BR>
 * H.7 处罚内容 penaltyDetail 必选<BR>
 * I.8 处罚日期 penaltyDate 必选<BR>
 * J.9 处罚机关 penaltyOffice 必选<BR>
 * K.10 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTAdministrativePenalty extends ENTBaseInfo {

    /**
     * E.4 处罚文书编号，必选
     */
    private String penaltyReferenceNum;

    /**
     * F.5 违法行为类型，必选
     */
    private String penaltyType;

    /**
     * G.6 处罚事由
     */
    private String penaltyReason;

    /**
     * H.7 处罚内容，必选
     */
    private String penaltyDetail;

    /**
     * I.8 处罚日期，必选
     */
    private String penaltyDate;

    /**
     * J.9 处罚机关，必选
     */
    private String penaltyOffice;

    /**
     * K.10 备注
     */
    private String comments;

    public String getPenaltyReferenceNum() {
        return penaltyReferenceNum;
    }

    public void setPenaltyReferenceNum(String penaltyReferenceNum) {
        this.penaltyReferenceNum = penaltyReferenceNum;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public String getPenaltyReason() {
        return penaltyReason;
    }

    public void setPenaltyReason(String penaltyReason) {
        this.penaltyReason = penaltyReason;
    }

    public String getPenaltyDetail() {
        return penaltyDetail;
    }

    public void setPenaltyDetail(String penaltyDetail) {
        this.penaltyDetail = penaltyDetail;
    }

    public String getPenaltyDate() {
        return penaltyDate;
    }

    public void setPenaltyDate(String penaltyDate) {
        this.penaltyDate = penaltyDate;
    }

    public String getPenaltyOffice() {
        return penaltyOffice;
    }

    public void setPenaltyOffice(String penaltyOffice) {
        this.penaltyOffice = penaltyOffice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
