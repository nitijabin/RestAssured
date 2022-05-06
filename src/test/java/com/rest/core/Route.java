package com.rest.core;



public class Route {

       String BASE_PATH = "/v1";
       String API = "/api";
       String TOKEN = "/token";
       public static final String UAA = "/uaa";
       public static final String LOGIN = "/uaa/api/auth/rocketbnk/login";
       public static final String Dev_Login ="uaa/api/auth/company-test/login";
       public static final String TRANSACTION = "/transactionflow/api/portal/v1";
       public static final String FINANCIAL_ACCOUNT_FLOW= "/financialaccountflow/api/portal/business-accounts/";
       public static final String ACCOUNT_FLOW_WITH_BUSINESS_ACCOUNTS = "/accountflow/api/portal/business-accounts/";
       public static String ACCOUNT_FLOW_WITH_BUSINESS_ACCOUNTS_EMPLOYEE;
       public static String FINANCIAL_ACCOUNT_FLOW_WITH_BUSINESS_ID;

       public static final String ACCOUNT_FLOW_WITH_EMPLOYEE = "/accountflow/api/portal/employees/linked-business-accounts";

       public static final String RECIPIENT ="/recipients";
       public static final String CONFIG = "/configs";
       public static final String PAYMENT_REASONS = "/payment-reasons";
       public static String getAccountFlowWithBusinessAccountsEmployee(){
              return ACCOUNT_FLOW_WITH_BUSINESS_ACCOUNTS_EMPLOYEE = ACCOUNT_FLOW_WITH_BUSINESS_ACCOUNTS+TestBase.getBusinessID()+"/employees";
       }

       public static String getFinancialAccountFlowWithBusinessId(){
              return FINANCIAL_ACCOUNT_FLOW_WITH_BUSINESS_ID = FINANCIAL_ACCOUNT_FLOW+TestBase.getBusinessID();
       }
}

