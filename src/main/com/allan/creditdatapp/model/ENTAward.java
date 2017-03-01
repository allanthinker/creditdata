package com.allan.creditdatapp.model;

/**
 * 企业荣誉信息模型
 * <P>
 * E.5 荣誉称谓 awardName 必选<BR>
 * F.6 文书编号 awardDocNum 必选<BR>
 * G.7 荣誉内容 awardDetail<BR>
 * H.8 认定日期 awardAffirmDate 必选<BR>
 * I.9 颁发机构 awardOffice 必选<BR>
 * J.10 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTAward extends ENTBaseInfo {

    /**
     * E.5 荣誉称谓，必选
     */
    private String awardName;

    /**
     * F.6 文书编号，必选
     */
    private String awardDocNum;

    /**
     * G.7 荣誉内容
     */
    private String awardDetail;

    /**
     * H.8 认定日期，必选
     */
    private String awardAffirmDate;

    /**
     * I.9 颁发机构，必选
     */
    private String awardOffice;

    /**
     * J.10 备注
     */
    private String comments;

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardDocNum() {
        return awardDocNum;
    }

    public void setAwardDocNum(String awardDocNum) {
        this.awardDocNum = awardDocNum;
    }

    public String getAwardDetail() {
        return awardDetail;
    }

    public void setAwardDetail(String awardDetail) {
        this.awardDetail = awardDetail;
    }

    public String getAwardAffirmDate() {
        return awardAffirmDate;
    }

    public void setAwardAffirmDate(String awardAffirmDate) {
        this.awardAffirmDate = awardAffirmDate;
    }

    public String getAwardOffice() {
        return awardOffice;
    }

    public void setAwardOffice(String awardOffice) {
        this.awardOffice = awardOffice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
