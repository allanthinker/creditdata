package com.allan.creditdatapp.model;

/**
 * 企业检验检测信息模型
 * <P>
 * E.5 检验检测类型 inspectType 必选<BR>
 * F.6 检验检测年度 inspectYear<BR>
 * G.7 检验检测内容 inspectDetail 必选<BR>
 * H.8 检验检测结果 inspectResult 必选<BR>
 * I.9 检验检测日期 inspectDate 必选<BR>
 * J.10 检验检测机构 inspectAgency 必选<BR>
 * K.11 送检单位 inspectOffice 必选<BR>
 * L.12 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTInspectionTest extends ENTBaseInfo {

    /**
     * E.5 检验检测类型，必选
     */
    private String inspectType;

    /**
     * F.6 检验检测年度
     */
    private String inspectYear;

    /**
     * G.7 检验检测内容，必选
     */
    private String inspectDetail;

    /**
     * H.8 检验检测结果，必选
     */
    private String inspectResult;

    /**
     * I.9 检验检测日期，必选
     */
    private String inspectDate;

    /**
     * J.10 检验检测机构，必选
     */
    private String inspectAgency;

    /**
     * K.11 送检单位，必选
     */
    private String inspectOffice;

    /**
     * L.12 备注
     */
    private String comments;

    public String getInspectType() {
        return inspectType;
    }

    public void setInspectType(String inspectType) {
        this.inspectType = inspectType;
    }

    public String getInspectYear() {
        return inspectYear;
    }

    public void setInspectYear(String inspectYear) {
        this.inspectYear = inspectYear;
    }

    public String getInspectDetail() {
        return inspectDetail;
    }

    public void setInspectDetail(String inspectDetail) {
        this.inspectDetail = inspectDetail;
    }

    public String getInspectResult() {
        return inspectResult;
    }

    public void setInspectResult(String inspectResult) {
        this.inspectResult = inspectResult;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        this.inspectDate = inspectDate;
    }

    public String getInspectAgency() {
        return inspectAgency;
    }

    public void setInspectAgency(String inspectAgency) {
        this.inspectAgency = inspectAgency;
    }

    public String getInspectOffice() {
        return inspectOffice;
    }

    public void setInspectOffice(String inspectOffice) {
        this.inspectOffice = inspectOffice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
