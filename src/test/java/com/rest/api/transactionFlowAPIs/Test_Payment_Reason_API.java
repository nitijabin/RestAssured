package com.rest.api.transactionFlowAPIs;

import com.rest.CommonHTTP;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertNotNull;

public class Test_Payment_Reason_API extends TransactionFlow {
    public Response api_resp;

    @BeforeClass
    public void get_api_response(){
        api_resp = CommonHTTP.getAPI(API_Path+"/payment-reasons", cookie);
        jsonPath = api_resp.jsonPath();
    }


    @Test(description = "Verify the response body is not null.")
    public void validateResponseBodyNotNull() {
        String responseBody = api_resp.prettyPrint();
        assertNotNull(responseBody);
    }
    @Test
    public void validatePaymentReason(){

        assertThat(api_resp.statusCode(), is(equalTo(200)));
    }

    @Test
    public void validatePayementReasonBody(){
        System.out.println("Print payment reason: "+jsonPath.getString("content[1].reason"));
        assertThat(jsonPath.getString("content[1].reason"), is(equalTo("Settlement Payout")));
    }
}


