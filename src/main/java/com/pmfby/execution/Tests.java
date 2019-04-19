package com.pmfby.execution;

import com.pmfby.page.Application;
import com.pmfby.page.PMFBYHome;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests extends TestExecution {


    PMFBYHome home = new PMFBYHome();
    Application application = new Application();

    @Test(description = "LOGIN")
    public void logIn() throws IOException {
        home.signIn("9000000176", "ins_agri_007");
    }

    @Test(description="Select the SSSYID", dependsOnMethods = {"logIn"})
    public void selectSSSYID() throws IOException {
        home.selectStateSSSYID("HIMACHAL PRADESH");
    }

    @Test(description = "GO TO THE APPLICATION PAGE", dependsOnMethods = {"selectSSSYID"})
    public void goToApplicationPage() throws IOException{
        home.goToApplicationPage();
    }


    @Test(description = "FILL UP THE FARMER DETAILS", dependsOnMethods = {"goToApplicationPage"})
    public void  fillUpBankAndLoaneeFarmerDetails(){
        application.fillLoaneeDetails("1000000117");
    }
}
