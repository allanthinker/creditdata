package com.allan.creditdatapp.model;

/**
 * 企业行政许可信息模型
 * <P>
 * E.5 许可文件名称 permitDocName 必选<BR>
 * F.6 许可编号 permitDocNum 必选<BR>
 * G.7 许可类型 permitType<BR>
 * H.8 许可内容 permitDetail 必选<BR>
 * I.9 许可日期 permitDate 必选<BR>
 * J.10 有效期 permitPeriodOfValidity 必选<BR>
 * K.11 许可机关 permitOffice 必选<BR>
 * L.12 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTAdministrativePermit extends ENTBaseInfo {

    /**
     * E.5 许可文件名称，必选
     */
    private String permitDocName;

    /**
     * F.6 许可编号，必选
     */
    private String permitDocNum;

    /**
     * G.7 许可类型
     */
    private String permitType;

    /**
     * H.8 许可内容，必选
     */
    private String permitDetail;

    /**
     * I.9 许可日期，必选
     */
    private String permitDate;

    /**
     * J.10 有效期，必选
     */
    private String permitPeriodOfValidity;

    /**
     * K.11 许可机关，必选
     */
    private String permitOffice;

    /**
     * L.12 备注
     */
    private String comments;

    public String getPermitDocName() {
        return permitDocName;
    }

    public void setPermitDocName(String permitDocName) {
        this.permitDocName = permitDocName;
    }

    public String getPermitDocNum() {
        return permitDocNum;
    }

    public void setPermitDocNum(String permitDocNum) {
        this.permitDocNum = permitDocNum;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public String getPermitDetail() {
        return permitDetail;
    }

    public void setPermitDetail(String permitDetail) {
        this.permitDetail = permitDetail;
    }

    public String getPermitDate() {
        return permitDate;
    }

    public void setPermitDate(String permitDate) {
        this.permitDate = permitDate;
    }

    public String getPermitPeriodOfValidity() {
        return permitPeriodOfValidity;
    }

    public void setPermitPeriodOfValidity(String permitPeriodOfValidity) {
        this.permitPeriodOfValidity = permitPeriodOfValidity;
    }

    public String getPermitOffice() {
        return permitOffice;
    }

    public void setPermitOffice(String permitOffice) {
        this.permitOffice = permitOffice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
