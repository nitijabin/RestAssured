package com.rest.api.transactionFlowAPIs;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertNotNull;

public class Business_Account_Config_API extends TransactionFlow{

    public Response api_resp;

    @BeforeClass
    public void get_api_response(){
        api_resp = common.getAPI(API_Path+"/configs", cookie);

        jsonPath = api_resp.jsonPath();
    }


    @Test
    public void validateResponseBodyNotNull() {
        String responseBody = api_resp.prettyPrint();
        assertThat(responseBody, is(notNullValue()));
    }
    @Test
    public void validateConfigStatus(){

        assertThat(api_resp.statusCode(), is(equalTo(200)));
    }

    @Test
    public void validateConfigResponseBody(){
        assertThat(jsonPath.getString("transactionWindows.provider[0]"), is(equalTo("ACH")));
    }
}
