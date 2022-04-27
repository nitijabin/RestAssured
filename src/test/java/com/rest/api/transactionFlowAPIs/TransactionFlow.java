package com.rest.api.transactionFlowAPIs;

import com.rest.CommonHTTP;
import com.rest.core.TestBase;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.rest.core.Route;
import org.testng.annotations.BeforeClass;

import static org.apache.http.client.methods.RequestBuilder.get;
//https://api.dev.rocketkor-nonprod.net/transactionflow/api/portal/v1/business-accounts/cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5/transactions?size=20
//https://api.dev.rocketkor-nonprod.net/transactionflow/api/portal/v1/business-accounts/cd8d387f-5a4c-4aab-8c7e-b4b6db7ef4e5/transactions?size=25
//https://api.dev.rocketkor-nonprod.net/transactionflow/api/portal/v1/configs
//https://api.dev.rocketkor-nonprod.net/transactionflow/api/portal/v1/payment-reasons

public abstract class TransactionFlow extends TestBase
{

    public  static Response resp;
    public Cookie cookie;
    public static String API_Path;
    public static JsonPath jsonPath ;
    @BeforeClass
    public void beforeClassLogin(){
        resp = getLoginResponseAndAccessToken();
        cookie = resp.getDetailedCookie("access_token");
        API_Path= Route.TRANSACTION;
    }
}
