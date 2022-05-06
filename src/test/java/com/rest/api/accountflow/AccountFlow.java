package com.rest.api.accountflow;

import com.rest.core.Route;
import com.rest.core.TestBase;
import org.testng.annotations.BeforeClass;


public abstract class AccountFlow extends TestBase {

    public static String API_Path;

    @BeforeClass
    public void set_path_Account_Flow(){

        API_Path= Route.getAccountFlowWithBusinessAccountsEmployee();
    }

}
