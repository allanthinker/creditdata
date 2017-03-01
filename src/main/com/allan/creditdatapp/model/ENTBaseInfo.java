package com.allan.creditdatapp.model;

public class ENTBaseInfo {
    /**
     *  A.1 企业名称，必选
     */
    private String entName;
    
    /**
     *  B.2 社会信用代码
     */
    private String entSocialCode;
    
    /**
     *  C.3 组织机构代码
     */
    private String entInstitutionCode;
    
    /**
     *  D.4 工商注册号，必选
     */
    private String entRegistrationCode;

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getEntSocialCode() {
        return entSocialCode;
    }

    public void setEntSocialCode(String entSocialCode) {
        this.entSocialCode = entSocialCode;
    }

    public String getEntInstitutionCode() {
        return entInstitutionCode;
    }

    public void setEntInstitutionCode(String entInstitutionCode) {
        this.entInstitutionCode = entInstitutionCode;
    }

    public String getEntRegistrationCode() {
        return entRegistrationCode;
    }

    public void setEntRegistrationCode(String entRegistrationCode) {
        this.entRegistrationCode = entRegistrationCode;
    }

}
