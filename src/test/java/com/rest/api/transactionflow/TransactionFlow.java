package com.rest.api.transactionflow;

import com.rest.core.TestBase;
import io.restassured.path.json.JsonPath;
import com.rest.core.Route;
import org.testng.annotations.BeforeClass;


public abstract class TransactionFlow extends TestBase
{

    public static String API_Path;
    public static JsonPath jsonPath ;

    @BeforeClass
    public void set_path_Transaction_Flow(){
        API_Path= Route.TRANSACTION;
    }
}
