package com.rest.core;

import com.rest.utils.PropertyLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;

public class TestBase {
    public static String baseUrl;
    public static String username;
    public static String password;
    public static RequestSpecification baseSetup_requestSpec;
    public static ResponseSpecification responseSpecification;
    public static PrintStream log;

    public TestBase(){
        try{
            PropertyLoader.loadProperties();
            baseUrl = System.getProperty("url");
            username = System.getProperty("username");
            password = System.getProperty("password");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

        @BeforeClass
        public static void setup() throws IOException{
            log =new PrintStream(new FileOutputStream("logging.txt"));
            baseSetup_requestSpec= new RequestSpecBuilder().setBaseUri(baseUrl)
                    .addHeader("Content-Type", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            responseSpecification = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();
            RestAssured.requestSpecification = baseSetup_requestSpec;
            RestAssured.responseSpecification = responseSpecification;
        }

    public Response getLoginResponseAndAccessToken(){
        JSONObject json = new JSONObject();
        json.put("userName",username);
        json.put("password",password);


        Response resp = given().spec(RestAssured.requestSpecification).
                body(json).
                post(Route.LOGIN).
                then().extract().response();
        return resp;
    }


    public void beforeMethod(Method m){
            System.out.println("STARTING TEST: " + m.getName());
            System.out.println("THREAD ID: " + Thread.currentThread().getId());
        }

}
