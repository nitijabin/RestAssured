package com.rest.api.transactionFlowAPIs;

import com.rest.CommonHTTP;
import com.rest.core.TestBase;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertNotNull;

public class Payment_Reason_API extends TransactionFlow {
    public Response api_resp;

    @BeforeClass
    public void get_api_response(){
        api_resp = common.getAPI(API_Path+"/payment-reasons", cookie);
        jsonPath = api_resp.jsonPath();
    }


    @Test
    public void validateResponseBodyNotNull() {
        String responseBody = api_resp.prettyPrint();
        assertNotNull(responseBody);
    }
    @Test
    public void validatePaymentReason(){

        assertThat(api_resp.statusCode(), is(equalTo(200)));
    }

    public void validatePayementReasonBody(){
        System.out.println("Print ACH: "+jsonPath.getString("transactionWindows.provider[0]"));
        assertThat(jsonPath.getString("transactionWindows.provider[0]"), is(equalTo("ACH")));
    }
}


