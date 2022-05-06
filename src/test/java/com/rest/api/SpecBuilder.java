package com.rest.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static com.rest.core.TestBase.baseUrl;

public class SpecBuilder {
    public static PrintStream log;
    public static RequestSpecification getRequestSpec() {
        try {
            log =new PrintStream(new FileOutputStream("logging.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().build();
    }
}
