package com.rest.api.transactionflow;

import com.rest.CommonHTTP;
import com.rest.core.Route;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GetTransactionConfigsTest extends TransactionFlow{

    public Response api_resp;

    @BeforeClass
    public void call_config_api(){
        api_resp = CommonHTTP.getAPI(API_Path+ Route.CONFIG, cookie);
        jsonPath = api_resp.jsonPath();
    }

    @Step
    @Description("The response body should not be null.")
    @Test(description = "Validating the account config api response body is not null.")
    public void validateResponseBodyNotNull() {
        String responseBody = api_resp.prettyPrint();
        assertThat(responseBody, is(notNullValue()));
    }

    @Step
    @Description("The status code should be 200")
    @Test(description = "Validating the account config api response status is 200.")
    public void validateConfigStatus(){

        assertThat(api_resp.statusCode(), is(equalTo(200)));
    }

    @Step
    @Description("The transaction window provider should have value ACH.")
    @Test(description = "Validating the response body should return value ACH.")
    public void validateConfigResponseBody(){
        assertThat(jsonPath.getString("transactionWindows.provider[0]"), is(equalTo("ACH")));
    }
}
