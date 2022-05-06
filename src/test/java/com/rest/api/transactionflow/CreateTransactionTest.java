package com.rest.api.transactionflow;

import com.rest.CommonHTTP;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Story("Move Money Transaction")
public class CreateTransactionTest extends TransactionFlow {

    public Response api_resp;

    @BeforeClass
    public void call_move_money_transactions_api(){
        File file = new File("src/main/resources/MoveMoneyPushCreditCardData.json");

        api_resp = CommonHTTP.postAPI(API_Path+"/business-accounts/"+getBusinessID()+"/transactions", cookie,file,setHeader());
        jsonPath = api_resp.jsonPath();
    }

    @Step
    @Description("The status code should be 201")
    @Test(description = "Checking the status code for the Move Money Transaction.")
    public void validateMoveMoneyTransaction(){
        assertThat(api_resp.statusCode(), is(equalTo(201)));
    }

    @Step
    @Description("Validating the schema with response body.")
    @Test(description = "Validating the schema of move money transactions API with the response body.")
    public void validateJsonSchema(){
        File schema = new File("src/main/resources/schema/MoveMoneySchema.json");
        api_resp.then().body(matchesJsonSchema(schema));
    }

    @Test(description = "Verifying the payment reason from the move money transaction response body.")
    public void verifyPaymentReason(){
        assertThat(jsonPath.getString("paymentReason"), is(equalTo("Sponsored pay advance disbursements")));
    }

}


