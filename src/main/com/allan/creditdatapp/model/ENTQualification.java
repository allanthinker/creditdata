package com.allan.creditdatapp.model;

/**
 * 企业资质信息模型
 * <P>
 * E.5 资质名称 qualificationName 必选<BR>
 * F.6 资质证书号 qualificationCertNum 必选<BR>
 * G.7 资质等级 qualificationLevel 必选<BR>
 * H.8 资质内容 qualificationDetail 必选<BR>
 * I.9 核发日期 qualificationAffirmDate 必选<BR>
 * J.10 有效期 qualificationPeriodOfValidity 必选<BR>
 * K.11 核发机关 qualificationAffirmOffice 必选<BR>
 * L.12 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTQualification extends ENTBaseInfo {

    /**
     * E.5 资质名称，必选
     */
    private String qualificationName;

    /**
     * F.6 资质证书号，必选
     */
    private String qualificationCertNum;

    /**
     * G.7 资质等级，必选
     */
    private String qualificationLevel;

    /**
     * H.8 资质内容，必选
     */
    private String qualificationDetail;

    /**
     * I.9 核发日期，必选
     */
    private String qualificationAffirmDate;

    /**
     * J.10 有效期，必选
     */
    private String qualificationPeriodOfValidity;

    /**
     * K.11 核发机关，必选
     */
    private String qualificationAffirmOffice;

    /**
     * L.12 备注
     */
    private String comments;

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getQualificationCertNum() {
        return qualificationCertNum;
    }

    public void setQualificationCertNum(String qualificationCertNum) {
        this.qualificationCertNum = qualificationCertNum;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public String getQualificationDetail() {
        return qualificationDetail;
    }

    public void setQualificationDetail(String qualificationDetail) {
        this.qualificationDetail = qualificationDetail;
    }

    public String getQualificationAffirmDate() {
        return qualificationAffirmDate;
    }

    public void setQualificationAffirmDate(String qualificationAffirmDate) {
        this.qualificationAffirmDate = qualificationAffirmDate;
    }

    public String getQualificationPeriodOfValidity() {
        return qualificationPeriodOfValidity;
    }

    public void setQualificationPeriodOfValidity(String qualificationPeriodOfValidity) {
        this.qualificationPeriodOfValidity = qualificationPeriodOfValidity;
    }

    public String getQualificationAffirmOffice() {
        return qualificationAffirmOffice;
    }

    public void setQualificationAffirmOffice(String qualificationAffirmOffice) {
        this.qualificationAffirmOffice = qualificationAffirmOffice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
