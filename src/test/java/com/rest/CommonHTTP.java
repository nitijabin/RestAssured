package com.rest;

import com.rest.api.SpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CommonHTTP {

    public static Response getAPI(String api_Path, Cookie set_cookie){
        Response resp = given(SpecBuilder.getRequestSpec()).when().cookie(set_cookie).
                get(api_Path).
                then().spec(SpecBuilder.getResponseSpec()).extract().response();
        return resp;
    }

    public static Response postAPI(String api_Path, Cookie set_cookie,  JSONObject json){
        Response resp = given(SpecBuilder.getRequestSpec()).when().cookie(set_cookie).
                body(json).
                post(api_Path).
                then().spec(SpecBuilder.getResponseSpec()).extract().response();
        return resp;
    }
    public static Response postAPI(String api_Path, Cookie set_cookie,  String json, HashMap<String, String> headerMap) {
        Response resp = given(SpecBuilder.getRequestSpec()).headers(headerMap).when().cookie(set_cookie).
                body(json).
                post(api_Path).
                then().spec(SpecBuilder.getResponseSpec()).extract().response();
        return resp;
    }
    public static Response postAPI(String api_Path, Cookie set_cookie,  File file, HashMap<String, String> headerMap) {
        Response resp = given(SpecBuilder.getRequestSpec()).headers(headerMap).when().cookie(set_cookie).
                body(file).
                post(api_Path).
                then().spec(SpecBuilder.getResponseSpec()).extract().response();
        return resp;
    }
    public static Response postAPI(String api_Path, Cookie set_cookie,  File file) {
        Response resp = given(SpecBuilder.getRequestSpec()).when().cookie(set_cookie).
                body(file).
                post(api_Path).
                then().spec(SpecBuilder.getResponseSpec()).extract().response();
        return resp;
    }
}
