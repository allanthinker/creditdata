package com.allan.creditdatapp.model;

/**
 * 严重违法企业名单信息模型
 * <P>
 * E.5 黑名单类型 blackListType 必选 <BR>
 * F.6 列入文书编号 recordDocNum 必选<BR>
 * G.7 列入原因 recordReason 必选<BR>
 * H.8 列入依据 recordBasis<BR>
 * I.9 列入日期 recordDate 必选<BR>
 * J.10 截至日期 recordExpiration 必选<BR>
 * K.11 列入机关 recordOffice 必选<BR>
 * L.12 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTSeriousViolationOfLaw extends ENTBaseInfo {

    /**
     * E.5 黑名单类型，必选
     */
    private String blackListType;

    /**
     * F.6 列入文书编号，必选
     */
    private String recordDocNum;

    /**
     * G.7 列入原因，必选
     */
    private String recordReason;

    /**
     * H.8 列入依据
     */
    private String recordBasis;

    /**
     * I.9 列入日期，必选
     */
    private String recordDate;

    /**
     * J.10 截至日期，必选
     */
    private String recordExpiration;

    /**
     * K.11 列入机关，必选
     */
    private String recordOffice;

    /**
     * L.12 备注
     */
    private String comments;

    public String getBlackListType() {
        return blackListType;
    }

    public void setBlackListType(String blackListType) {
        this.blackListType = blackListType;
    }

    public String getRecordDocNum() {
        return recordDocNum;
    }

    public void setRecordDocNum(String recordDocNum) {
        this.recordDocNum = recordDocNum;
    }

    public String getRecordReason() {
        return recordReason;
    }

    public void setRecordReason(String recordReason) {
        this.recordReason = recordReason;
    }

    public String getRecordBasis() {
        return recordBasis;
    }

    public void setRecordBasis(String recordBasis) {
        this.recordBasis = recordBasis;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordExpiration() {
        return recordExpiration;
    }

    public void setRecordExpiration(String recordExpiration) {
        this.recordExpiration = recordExpiration;
    }

    public String getRecordOffice() {
        return recordOffice;
    }

    public void setRecordOffice(String recordOffice) {
        this.recordOffice = recordOffice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
