package com.rest.api.financialaccountflow;

import com.rest.core.Route;
import com.rest.core.TestBase;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;

public abstract class FinancialAccountFlow extends TestBase {
    public static JsonPath jsonPath ;
    public static String API_Path;

    @BeforeClass
    public void setpathFinancialAccountFlow(){
        API_Path= Route.getFinancialAccountFlowWithBusinessId();
    }
}
