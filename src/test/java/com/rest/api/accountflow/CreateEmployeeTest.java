package com.rest.api.accountflow;

import com.rest.CommonHTTP;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreateEmployeeTest extends AccountFlow {

    public Response api_resp;

    @BeforeClass
    public void createEmployee(){
       File file = new File("src/main/resources/NewEmployeeData.json");
    String jsonSt="{\n" +
        "    \"firstName\": \"John\",\n" +
        "    \"lastName\": \"Doe\",\n" +
        "    \"middleName\": \"Ez\",\n" +
        "    \"email\": \"sfdfhfghf@test.com\",\n" +
        "    \"mobileNumber\": \"2035515555\",\n" +
        "    \"permissionRoles\": [\"ADMIN\"]\n" +
        "}";

        api_resp = CommonHTTP.postAPI(API_Path, cookie, file,setHeader());
    }

    @Test
    public void validateCreateEmployee(){
          assertThat(api_resp.statusCode(), is(equalTo(201)));
    }

}
