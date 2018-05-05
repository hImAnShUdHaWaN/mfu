package com.mfu.domain.funds;

/**
 * Created by himanshu dhawan on 01-05-2018.
 */
public enum AMC {

    ADITYA_BIRLA_SUN_LIFE_AMC_LIMITED("Aditya Birla Sun Life AMC Limited"),
    BARODA_PIONEER_ASSET_MANAGEMENT_COMPANY_LIMITED("Baroda Pioneer Asset Management Company Limited"),
    DSP_BLACKROCK_INVESTMENT_MANAGERS_PRIVATE_LIMITED("DSP BlackRock Investment Managers Private Limited"),
    HDFC_ASSET_MANAGEMENT_COMPANY_LIMITED("HDFC Asset Management Company Limited (Corporate Identification Number - U65991MH1999PLC123027)"),
    PRINCIPAL_PNB_ASSET_MANAGEMENT_CO_PVT_LTD("Principal Pnb Asset Management Co. Pvt. Ltd."),
    ESCORTS_ASSET_MANAGEMENT_LIMITED("Escorts Asset Management Limited"),
    JM_FINANCIAL_ASSET_MANAGEMENT_LIMITED("JM Financial Asset Management Limited"),
    KOTAK_MAHINDRA_ASSET_MANAGEMENT_COMPANY_LIMITED("Kotak Mahindra Asset Management Company Limited(KMAMCL)"),
    LIC_MUTUAL_FUND_ASSET_MANAGEMENT_LIMITED("LIC Mutual Fund Asset Management Limited"),
    ICICI_PRUDENTIAL_ASSET_MGMTCOMPANY_LIMITED("ICICI Prudential Asset Mgmt.Company Limited"),
    RELIANCE_NIPPON_LIFE_ASSET_MANAGEMENT_LIMITED("Reliance Nippon Life Asset Management Limited"),
    TAURUS_ASSET_MANAGEMENT_COMPANY_LIMITED("Taurus Asset Management Company Limited"),
    FRANKLIN_TEMPLETON_ASSET_MANAGEMENT_INDIA_PRIVATE_LIMITED("Franklin Templeton Asset Management (India) Private Limited"),
    CANARA_ROBECO_ASSET_MANAGEMENT_COMPANY_LIMITED("Canara Robeco Asset Management Company Limited"),
    SUNDARAM_ASSET_MANAGEMENT_COMPANY_LIMITED("Sundaram Asset Management Company Limited"),
    SBI_FUNDS_MANAGEMENT_PRIVATE_LIMITED("SBI Funds Management Private Limited"),
    UTI_ASSET_MANAGEMENT_COMPANY_LTD("UTI Asset Management Company Ltd"),
    SAHARA_ASSET_MANAGEMENT_COMPANY_PRIVATE_LIMITED("Sahara Asset Management Company Private Limited"),
    TATA_ASSET_MANAGEMENT_LIMITED("Tata Asset Management Limited"),
    HSBC_ASSET_MANAGEMENT_INDIA_PRIVATE_LTD("HSBC Asset Management (India) Private Ltd."),
    QUANTUM_ASSET_MANAGEMENT_COMPANY_PRIVATE_LIMITED("Quantum Asset Management Company Private Limited"),
    INVESCO_ASSET_MANAGEMENT_INDIA_PRIVATE_LIMITED("Invesco Asset Management (India) Private Limited"),
    MIRAE_ASSET_GLOBAL_INVESTMENTS_INDIA_PVT_LTD("Mirae Asset Global Investments (India) Pvt. Ltd."),
    IDFC_ASSET_MANAGEMENT_COMPANY_LIMITED("IDFC Asset Management Company Limited"),
    BOI_AXA_INVESTMENT_MANAGERS_PRIVATE_LIMITED("BOI AXA Investment Managers Private Limited"),
    EDELWEISS_ASSET_MANAGEMENT_LIMITED("Edelweiss Asset Management Limited"),
    AXIS_ASSET_MANAGEMENT_COMPANY_LTD("Axis Asset Management Company Ltd."),
    ESSEL_FINANCE_AMC_LIMITED("Essel Finance AMC Limited"),
    L_AND_T_INVESTMENT_MANAGEMENT_LIMITED("L&T Investment Management Limited"),
    IDBI_ASSET_MANAGEMENT_LTD("IDBI Asset Management Ltd."),
    MOTILAL_OSWAL_ASSET_MANAGEMENT_COMPANY_LIMITED("Motilal Oswal Asset Management Company Limited"),
    BNP_PARIBAS_ASSET_MANAGEMENT_INDIA_PRIVATE_LIMITED("BNP Paribas Asset Management India Private Limited"),
    DHFL_PRAMERICA_ASSET_MANAGERS_PRIVATE_LIMITED("DHFL Pramerica Asset Managers Private Limited"),
    UNION_ASSET_MANAGEMENT_COMPANY_PRIVATE_LIMITED("Union Asset Management Company Private Limited (formerly Union KBC Asset Management Co. Pvt. Ltd)"),
    INDIABULLS_ASSET_MANAGEMENT_COMPANY_LTD("Indiabulls Asset Management Company Ltd."),
    PPFAS_ASSET_MANAGEMENT_PVT_LTD("PPFAS Asset Management Pvt. Ltd."),
    IIFL_ASSET_MANAGEMENT_LTD("IIFL Asset Management Ltd. (Formerly known as India Infoline Asset Management Co. Ltd.)"),
    SHRIRAM_ASSET_MANAGEMENT_CO_LTD("Shriram Asset Management Co. Ltd."),
    IIFCL_ASSET_MANAGEMENT_CO_LTD("IIFCL Asset Management Co. Ltd."),
    IL_AND_FS_INFRA_ASSET_MANAGEMENT_LIMITED("IL&FS Infra Asset Management Limited (CIN U65191MH2013PLC239438)"),
    MAHINDRA_ASSET_MANAGEMENT_COMPANY_PVT_LTD("Mahindra Asset Management Company Pvt. Ltd.");

    private String name;

    AMC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AMC contains(String test) {
        for (AMC c : AMC.values()) {
            if (c.getName().equals(test)) {
                return c;
            }
        }
        return null;
    }
}
