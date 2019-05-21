package com.pmfby.execution;

import com.pmfby.page.Application;
import com.pmfby.page.PMFBYHome;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests extends TestExecution {


    PMFBYHome home = new PMFBYHome();
    Application application = new Application();

    @Test(description = "LOGIN", groups = {"BANK_APPLICATION_SUBMISSION"})
    public void logIn() throws IOException {
        home.signIn("6000000003", "ins_agri_007");
    }

    @Test(description="Select the SSSYID", dependsOnMethods = {"logIn"}, groups = {"BANK_APPLICATION_SUBMISSION"})
    public void selectSSSYID() throws IOException {
        home.selectStateSSSYID("Himachal Pradesh");
    }

    @Test(description = "GO TO THE APPLICATION PAGE", dependsOnMethods = {"selectSSSYID"}, groups = {"BANK_APPLICATION_SUBMISSION"})
    public void goToApplicationPage() throws IOException{
        home.goToApplicationPage();
    }


    @Test(description = "SUBMIT APPLICATION", dependsOnMethods = {"goToApplicationPage"}, groups = {"BANK_APPLICATION_SUBMISSION"})
    public void  fillUpBankAndLoaneeFarmerDetails() throws IOException {
        application.fillLoaneeDetails("1000000115");
        application.goToTheCropDetailsPage();
        application.submitApplication();
    }


    @Test(description = "GO TO THE UNPAID APPLICATION PAGE", dependsOnMethods = {"fillUpBankAndLoaneeFarmerDetails"})
    public void goToUnpaidApplications(){
        application.goToUnPaidApplicationPage();
        application.viewUnpaidApplicationList();
    }


    @Test(description= "GO TO THE PAID APPLICATIONS PAGE", dependsOnMethods={"selectSSSYID"}, enabled = false)
    public void goToThePaidApplicationPage(){
        application.goToPaidApplication();
    }
}
