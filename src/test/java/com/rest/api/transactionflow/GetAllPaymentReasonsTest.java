package com.rest.api.transactionflow;

import com.rest.CommonHTTP;
import com.rest.core.Route;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertNotNull;

public class GetAllPaymentReasonsTest extends TransactionFlow {
    public Response api_resp;

    @BeforeClass
    public void getApiResponse(){
        api_resp = CommonHTTP.getAPI(API_Path+ Route.PAYMENT_REASONS, cookie);
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
        assertThat(jsonPath.getString("content[1].reason"), is(equalTo("Emergency relief disbursements")));
    }
}


