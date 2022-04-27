package com.rest.api;

import com.rest.core.TestBase;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.hamcrest.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test_Login_API extends TestBase {
    Response resp;
    public static  Cookie cookie;

    @BeforeClass
    public void beforeClassLogin(){

        resp= getLoginResponseAndAccessToken();
        cookie = resp.getDetailedCookie("access_token");
    }

    @Test(description = "Verify Login Status code")
    public void validate_login_status_code(){
        assertThat(resp.statusCode(), is(equalTo(200)));
    }

    @Test(description = "Verify Login response body")
    public void validate_login_response_body(){
        assertThat(resp.path("expires_in").toString(),equalTo("300"));
    }

    /***public void queryTest(){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(common.buildRequestSpecification());
    }***/
}
