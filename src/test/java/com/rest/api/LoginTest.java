package com.rest.api;

import com.rest.core.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends TestBase {

    @Test(description = "Verify Login Status code")
    public void validateLoginStatusCode(){
        assertThat(loginResp.statusCode(), is(equalTo(200)));
    }

    @Test(description = "Verify Login response body")
    public void validateLoginResponseBody(){
        assertThat(loginResp.path("expires_in").toString(),equalTo("300"));
    }

}
