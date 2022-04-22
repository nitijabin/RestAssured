package com.rest.api.accountFlowAPIs;

import com.rest.CommonHTTP;
import com.rest.core.Route;
import com.rest.core.TestBase;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

//https://api.dev.rocketkor-nonprod.net/accountflow/api/portal/employees/linked-business-accounts?page=0&size=7
//https://api.dev.rocketkor-nonprod.net/accountflow/api/portal/business-accounts/cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5
//https://api.dev.rocketkor-nonprod.net/accountflow/api/portal/employees/quick-info
//https://api.dev.rocketkor-nonprod.net/accountflow/api/portal/business-accounts/legal-entity-types

public class AccountFlow extends TestBase {

    public  static Response resp;
    public  Cookie cookie;
    //CommonHTTP common;
    public static String API_Path;

    @BeforeClass
    public void beforeClassLogin(){
        resp = getLoginResponseAndAccessToken();
        cookie = resp.getDetailedCookie("access_token");
        API_Path= Route.ACCOUNT;
    }

}
