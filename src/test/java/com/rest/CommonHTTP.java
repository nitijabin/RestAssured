package com.rest;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class CommonHTTP {

    public static Response getAPI(String api_Path, Cookie set_cookie){
        Response resp = given().spec(RestAssured.requestSpecification).when().cookie(set_cookie).
                get(api_Path).
                then().log().all().extract().response();
        return resp;
    }

    public static Response postAPI(String api_Path, Cookie set_cookie,  JSONObject json){
        Response resp = given().spec(RestAssured.requestSpecification).when().cookie(set_cookie).
                body(json).
                post(api_Path).
                then().log().all().extract().response();
        return resp;
    }
    public static Response postAPI(String api_Path, Cookie set_cookie,  String json) {
        Response resp = given(RestAssured.requestSpecification).when().cookie(set_cookie).
                body(json).
                post(api_Path).
                then().log().all().extract().response();
        return resp;
    }
}
