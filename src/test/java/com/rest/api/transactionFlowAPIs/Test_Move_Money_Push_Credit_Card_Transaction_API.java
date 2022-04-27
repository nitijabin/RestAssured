package com.rest.api.transactionFlowAPIs;

import com.rest.CommonHTTP;
import com.rest.core.Route;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Test_Move_Money_Push_Credit_Card_Transaction_API extends TransactionFlow {

    public Response api_resp;

    @BeforeClass
    public void move_Money_For_Transactions(){
        File file = new File("src/main/resources/MoveMoneyPushCreditCardData.json");

        api_resp = CommonHTTP.postAPI(API_Path+Route.BUSINESS_ACCOUNT_WITH_ID+"/transactions", cookie,file,setHeader());
        jsonPath = api_resp.jsonPath();

    }

    @Test(description = "Checking the status code for the Move Money Transaction.")
    public void validateMoveMoneyTransaction(){
        assertThat(api_resp.statusCode(), is(equalTo(201)));
    }

    @Test(description = "Validating the schema of move money transactions API with the response body.")
    public void validateJsonSchema(){
        File schema = new File("src/main/resources/schema/MoveMoneySchema.json");
        api_resp.then().body(matchesJsonSchema(schema));
    }
}


