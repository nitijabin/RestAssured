package com.rest.core;

public interface Route {

       String BASE_PATH = "/v1";
       String API = "/api";
       String TOKEN = "/token";
       String UAA = "/uaa";
       String LOGIN = "/uaa/api/auth/rocketbnk/login";
       String Dev_Login ="uaa/api/auth/company-test/login";
       String TRANSACTION = "/transactionflow/api/portal/v1";
       String ACCOUNT = "/accountflow/api/portal/business-accounts/"+TestData.BusinessID_qa;
       String FINANCIAL  ="/financialaccountflow/api/portal/business-accounts";
       String BUSINESS_ACCOUNT_WITH_ID="/business-accounts/"+TestData.BusinessID_qa;
       String FINANCIAL_WITH_BUSINESS_ID  ="/financialaccountflow/api/portal"+BUSINESS_ACCOUNT_WITH_ID;

}

