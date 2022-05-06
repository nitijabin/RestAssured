package com.rest.core;

import com.rest.CommonHTTP;
import com.rest.api.SpecBuilder;
import com.rest.utils.PropertyLoader;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public abstract class TestBase {
    public static String baseUrl;
    public  String username;
    public  String password;
    public static Response loginResp;
    public static Cookie cookie;

    public  TestBase(){
        try{
            PropertyLoader.loadProperties();
            baseUrl = System.getProperty("url");
            username = System.getProperty("username");
            password = System.getProperty("password");
            setup_cookie();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void setup_cookie()
    {
        loginResp = getLoginResponseAndAccessToken();
        cookie = loginResp.getDetailedCookie("access_token");
    }
    public Response getLoginResponseAndAccessToken(){
        JSONObject json = new JSONObject();
        json.put("userName",username);
        json.put("password",password);

        Response resp = given(SpecBuilder.getRequestSpec()).
                body(json).
                post(Route.LOGIN).
                then().extract().response();
        return resp;
    }

    //*** Adding headers for the create employee API
    public HashMap setHeader(){
        HashMap<String,String> headerMap= new HashMap<>();
        headerMap.put("Referer",baseUrl);
        headerMap.put("Accept", "application/json, text/plain, */*");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Accept-Language", "en-US,en;q=0.9,fr;q=0.8");
        headerMap.put("Access-Control-Allow-Credentials" ,"true");
        return headerMap;
    }

    public static JsonPath setBusinessID(){
        HashMap<String, String> params = new HashMap<>();
        params.put("page","0");
        params.put("size","7");

        return  CommonHTTP.getAPI(Route.ACCOUNT_FLOW_WITH_EMPLOYEE,cookie,params).jsonPath();

    }

    public static String getBusinessID(){
        return setBusinessID().getString("content.id[0]");
    }
    public void beforeMethod(Method m){
            System.out.println("STARTING TEST: " + m.getName());
            System.out.println("THREAD ID: " + Thread.currentThread().getId());
        }

}
