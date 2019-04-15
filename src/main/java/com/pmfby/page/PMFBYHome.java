package com.pmfby.page;

import com.aventstack.extentreports.Status;
import com.pmfby.pageObjects.HomePage;
import com.pmfby.pageObjects.LoginPage;
import com.pmfby.pageObjects.SignInPage;
import com.pmfby.resources.*;
import com.pmfby.utility.Loggers;
import com.pmfby.utility.Reports;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;

public class PMFBYHome {

    Reports report = new Reports();
    ScreenShot screenShot = new ScreenShot();
    Waits wait = new Waits();
    Click click = new Click();
    TextBox text = new TextBox();
    ScreenShot capture = new ScreenShot();


    public void signIn() throws IOException {
        try{
            click.buttonClick(HomePage.SIGN_IN_BUTTON);
            Loggers.logger.info("Clicked on the Sign In link");
//            screenShot.takeScreenShot(Status.INFO, "After clicking on the Sign In link");
            wait.waitForElementToBeDisplayed(SignInPage.FARMER_LOGIN_BUTTON);
            report.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO, "After Clicking on the Sign In Link"));
            text.sendText(SignInPage.MOBILE_NUMBER, "6000000003");
            text.sendText(SignInPage.PASSWORD, "ins_agri_007");
            Thread.sleep(10000);
            click.buttonClick(SignInPage.LOGIN_BUTTON);
            Loggers.logger.info("Clicked on the Login Button");
            wait.waitForElementToBeDisplayed(LoginPage.SUBMIT_BUTTON);
            if(VerifyElements.isElementPresent(LoginPage.CHANGE_PASSWORD_SUBMIT_BUTTON)){
                Loggers.logger.info("Successfully landed on the dashboard after logging in");
                click.buttonClick(LoginPage.CLOSE_CHANGE_PASSWORD);
                report.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS, "Successfully logged in"));
            }
            else{
                Loggers.logger.info("Successfully landed on the dashboard after logging in");
                report.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS, "Successfully logged in"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
            report.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL, "Failed to log in to the user account"));
            Loggers.logger.error("User cannot be logged in");
        }
    }


    public void closeChangePasswordPopUp(){
        try{
            click.buttonClick(LoginPage.CLOSE_CHANGE_PASSWORD);
            Loggers.logger.info("Closing the change password modal");
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Change Password modal does not exist");
        }
    }

}
