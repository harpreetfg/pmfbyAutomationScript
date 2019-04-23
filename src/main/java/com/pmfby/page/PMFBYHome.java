package com.pmfby.page;

import com.aventstack.extentreports.Status;
import com.pmfby.pageObjects.ApplicationPage;
import com.pmfby.pageObjects.HomePage;
import com.pmfby.pageObjects.LoginPage;
import com.pmfby.pageObjects.SignInPage;
import com.pmfby.resources.*;
import com.pmfby.utility.Loggers;
import com.pmfby.utility.Reports;
import org.testng.Assert;

import java.io.IOException;

public class PMFBYHome {

    private Waits wait = new Waits();
    private Click click = new Click();
    private TextBox text = new TextBox();
    private ScreenShot capture = new ScreenShot();
    private SelectDropDown select = new SelectDropDown();


    public void signIn(String userName, String password) throws IOException {
        try{
            click.buttonClick(HomePage.SIGN_IN_BUTTON);
            Loggers.logger.info("Clicked on the Sign In link");
//            screenShot.takeScreenShot(Status.INFO, "After clicking on the Sign In link");
            wait.waitForElementToBeDisplayed(SignInPage.FARMER_LOGIN_BUTTON);
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                    "After Clicking on the Sign In Link"));
            text.sendText(SignInPage.MOBILE_NUMBER, userName);
            text.sendText(SignInPage.PASSWORD, password);
            Thread.sleep(10000);
            click.buttonClick(SignInPage.LOGIN_BUTTON);
            Loggers.logger.info("Clicked on the Login Button");
            wait.waitForElementToBeDisplayed(LoginPage.SUBMIT_BUTTON);
            if (!VerifyElements.isElementVisible(LoginPage.CHANGE_PASSWORD_SUBMIT_BUTTON)) {
                Loggers.logger.info("Successfully landed on the dashboard after logging in");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS, "Successfully logged in"));
            } else {
                Loggers.logger.info("Successfully landed on the dashboard after logging in");
                closeChangePasswordPopUp();
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS, "Successfully logged in"));
            }
        }
        catch (Exception e){
            Assert.fail();
            e.printStackTrace();
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL, "Failed to log in to the user account"));
            Loggers.logger.error("User cannot be logged in");
        }
    }


    private void closeChangePasswordPopUp(){
        try{
            click.buttonClick(LoginPage.CLOSE_CHANGE_PASSWORD);
            Loggers.logger.info("Closing the change password modal");
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Change Password modal does not exist");
        }
    }


    public void selectStateSSSYID(String state) throws IOException {
        try{
            click.buttonClick(LoginPage.SELECT_STATE_SSSYID);
            select.selectElementByText(LoginPage.SELECT_STATE_SSSYID, state);
            Loggers.logger.info("Selected the State for scheme: "+state);
            if(select.defaultSelectedValue(LoginPage.SELECT_STATE_SSSYID).equals(state)){
                if(!VerifyElements.isElementSelected(LoginPage.SELECT_SSSYID_RADIO_BUTTON)){
                    click.buttonClick(LoginPage.SELECT_SSSYID_RADIO_BUTTON);
                    Loggers.logger.info("Selected the SSSYID");
                    click.buttonClick(LoginPage.SUBMIT_BUTTON);
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS, "After the SSSYID is successfully selected"));
                }
                else
                    Loggers.logger.info("SSSYID is already selected");
            }
            else{
                Assert.fail();
                Loggers.logger.error("SSSYID:" + LoginPage.SELECT_SSSYID_RADIO_BUTTON +", not found");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL, "SSSYID not selected"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("SSSYID not selected");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL, "SSSYID not selected"));
        }
    }


    public void goToApplicationPage() throws IOException {
        try{
            click.buttonClick(LoginPage.APPLICATION_TAB);
            Loggers.logger.info("Directed to the Application page");
            if(VerifyElements.isElementPresent(ApplicationPage.PAID_APPLICATIONS)){
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS, "Successfully landed on the Application page"));
            }
            else{
                Assert.fail();
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL, "Cannot navigate to the Application page"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL, "Cannot navigate to the Application page"));
        }
    }

}
