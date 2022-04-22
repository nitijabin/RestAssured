package com.rest.api.accountFlowAPIs;

import com.rest.CommonHTTP;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreateEmployee extends AccountFlow {

    public Response api_resp;

    @BeforeClass
    public void createEmployee(){
        String jsonBody ="{\n" +
                "    \"firstName\": \"nana\",\n" +
                "    \"lastName\": \"skssdks\",\n" +
                "    \"middleName\": \"Ez\",\n" +
                "    \"email\": \"addaddsfsed@test.com\",\n" +
                "    \"mobileNumber\": \"2035928955\",\n" +
                "    \"permissionRoles\": [\"ADMIN\"]\n" +
                "}";

        api_resp = CommonHTTP.postAPI(API_Path, cookie,jsonBody);
    }

    @Test
    public void validateCreateEmployee(){
          assertThat(api_resp.statusCode(), is(equalTo(200)));
    }

}
