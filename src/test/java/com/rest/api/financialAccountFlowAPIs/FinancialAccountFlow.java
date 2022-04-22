package com.rest.api.financialAccountFlowAPIs;

import com.rest.CommonHTTP;
import com.rest.core.Route;
import com.rest.core.TestBase;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

//https://api.dev.rocketkor-nonprod.net/financialaccountflow/api/portal/business-accounts/cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5/recipients?size=3&sort=createdAt%2Cdesc
//https://api.dev.rocketkor-nonprod.net/financialaccountflow/api/portal/business-accounts/cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5/financial-accounts?page=0&size=10&type=bankAccount&state=ACTIVE
//https://api.dev.rocketkor-nonprod.net/financialaccountflow/api/portal/business-accounts/cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5/recipients/payment-details?page=0&size=10&type=card&state=ACTIVE

public class FinancialAccountFlow extends TestBase {
    public  static Response resp;
    public static Cookie cookie;
    CommonHTTP common;
    public static String API_Path;

    @BeforeClass
    public void beforeClassLogin(){
        resp = getLoginResponseAndAccessToken();
        cookie = resp.getDetailedCookie("access_token");
        API_Path= Route.FINANCIAL_WITH_BUSINESS_ID;
    }

}
