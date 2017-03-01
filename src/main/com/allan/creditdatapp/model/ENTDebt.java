package com.allan.creditdatapp.model;

/**
 * 企业欠薪欠费欠税欠贷信息模型
 * <P>
 * E.5 欠薪/欠费/欠税/欠贷种类 debtType 必选<BR>
 * F.6 欠薪/欠费/欠税/欠贷时段 debtPeriod 必选<BR>
 * G.7 欠薪/欠费/欠税/欠贷总额 debtAmount<BR>
 * H.8 记录单位 debtRecordOffice 必选<BR>
 * I.9 备注 comments<BR>
 * 
 * @author Allan
 *
 */
public class ENTDebt extends ENTBaseInfo {

    /**
     * E.5 欠薪/欠费/欠税/欠贷种类，必选
     */
    private String debtType;

    /**
     * F.6 欠薪/欠费/欠税/欠贷时段，必选
     */
    private String debtPeriod;

    /**
     * G.7 欠薪/欠费/欠税/欠贷总额
     */
    private String debtAmount;

    /**
     * H.8 记录单位，必选
     */
    private String debtRecordOffice;

    /**
     * I.9 备注
     */
    private String comments;

    public String getDebtType() {
        return debtType;
    }

    public void setDebtType(String debtType) {
        this.debtType = debtType;
    }

    public String getDebtPeriod() {
        return debtPeriod;
    }

    public void setDebtPeriod(String debtPeriod) {
        this.debtPeriod = debtPeriod;
    }

    public String getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(String debtAmount) {
        this.debtAmount = debtAmount;
    }

    public String getDebtRecordOffice() {
        return debtRecordOffice;
    }

    public void setDebtRecordOffice(String debtRecordOffice) {
        this.debtRecordOffice = debtRecordOffice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
