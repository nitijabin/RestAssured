package com.rest.core;

public interface Route {

       String BASE_PATH = "/v1";
       String API = "/api";
       String TOKEN = "/token";
       String UAA = "/uaa";
       String LOGIN = "/uaa/api/auth/rocketbnk/login";
       String Dev_Login ="uaa/api/auth/company-test/login";
       String TRANSACTION = "/transactionflow/api/portal/v1";
       String BusinessID_dev ="cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5";
       String BusinessID_qa= "bbb30ec0-6947-4719-b564-fd91115bf50f";
       String ACCOUNT = "/accountflow/api/portal/business-accounts/"+BusinessID_qa+"/employees";
       String FINANCIAL  ="/financialaccountflow/api/portal/business-accounts";
       String FINANCIAL_WITH_BUSINESS_ID  ="/financialaccountflow/api/portal/business-accounts/cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5";

}

