package com.rest.api.financialaccountflow;

import com.rest.CommonHTTP;
import com.rest.core.Route;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetRecipientsTest extends FinancialAccountFlow{

    public Response api_resp;

    @BeforeClass
    public void getRecipient() {
        HashMap<String, String> params = new HashMap<>();
        params.put("sort","firstName,asc");
        params.put("size","25");
        api_resp = CommonHTTP.getAPI(API_Path+Route.RECIPIENT, cookie,params );
        jsonPath = api_resp.jsonPath();
    }

    @Test
    public void verifyStatusCode(){
        assertThat(api_resp.statusCode(), is(equalTo(200)));
    }

    @Test
    public void verifyTotalRecipient(){
        assertThat(jsonPath.getString("totalElements"), is(equalTo("90")));
    }
}
