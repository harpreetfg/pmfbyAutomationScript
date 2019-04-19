package com.pmfby.page;

import com.aventstack.extentreports.Status;
import com.pmfby.pageObjects.ApplicationPage;
import com.pmfby.resources.*;
import com.pmfby.utility.Loggers;
import com.pmfby.utility.Reports;
import org.testng.Assert;

import java.util.Objects;

public class Application {

    private Waits wait = new Waits();
    private Click click = new Click();
    private SelectDropDown select = new SelectDropDown();
    private ScreenShot capture = new ScreenShot();
    private TextBox text = new TextBox();
    private Checkbox checkbox = new Checkbox();
    private Window window = new Window();

    private void selectUserBranch(){
        try{
            click.buttonClick(ApplicationPage.SELECT_BRANCH);
            select.selectElementByText(ApplicationPage.SELECT_BRANCH, "BILASPUR");
            System.out.println("=======================================");
            Loggers.logger.info("Selected the Branch Head/User branch");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO, "Selected the branch"));
//                click.buttonClick(ApplicationPage.SELECT_PACS);
//                select.selectElementByText(ApplicationPage.SELECT_PACS, "PACS");
            click.buttonClick(ApplicationPage.SUBMIT_BUTTON_CHOOSE_BRANCH);
            Loggers.logger.info("Clicked on the Submit button");
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Failed to navigate to the Application Loanee Form");
        }
    }


    public void fillLoaneeDetails(String accountNumber){
        try{
            click.buttonClick(ApplicationPage.APPLICATION_FORM_LOANEE);
            Thread.sleep(2000);
            if(VerifyElements.isElementPresent(ApplicationPage.SELECT_BRANCH)){
                selectUserBranch();
                wait.waitForPageLoad();
                if(VerifyElements.isElementPresent(ApplicationPage.BANK_ACCOUNT_NUMBER)){
                    Loggers.logger.info("Dropped on the Loanee Application Form page");
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                            "Dropped on the Loanee Application Form page"));
                }
                else{
                    Assert.fail();
                    Loggers.logger.error("Failed to navigate to the Application Loanee From page");
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                            "Failed to navigate to the Application Loanee From page"));
                }
            }
            else{
                Loggers.logger.info("Dropped on the Loanee Application Form page");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                        "Dropped on the Loanee Application Form page"));
            }
            text.sendText(ApplicationPage.BANK_ACCOUNT_NUMBER, accountNumber);
            text.sendText(ApplicationPage.CONFIRM_BANK_ACCOUNT_NUMBER, accountNumber);
            select.selectElementByText(ApplicationPage.ACCOUNT_TYPE, "Single");
            click.buttonClick(ApplicationPage.CHECK_BANK_DETAILS_BUTTON);
            Loggers.logger.info("Click on the Check Bank Details & Continue button");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                    "Validating the provided bank details"));
            if(VerifyElements.isElementPresent(ApplicationPage.SAVE_AND_CONTINUE_BUTTON)){
                if(!Objects.requireNonNull(Elements.findElements(ApplicationPage.FARMER_NAME)).isEmpty()){
                    if(VerifyElements.isElementSelected(ApplicationPage.PRIMARY_FARMER)){
                        click.buttonClick(ApplicationPage.SAVE_AND_CONTINUE_BUTTON);
                        Loggers.logger.info("Clicked on the Save and Continue button");
                        wait.waitForElementToBeDisplayed(ApplicationPage.SELECT_CROP);
                        Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                                "Farmer Details filled and navigated to the crop details page"));
                    }
                    else{
                        checkbox.check(ApplicationPage.PRIMARY_FARMER);
                        click.buttonClick(ApplicationPage.SAVE_AND_CONTINUE_BUTTON);
                        Loggers.logger.info("Clicked on the Save and Continue button");
                        wait.waitForElementToBeDisplayed(ApplicationPage.SELECT_CROP);
                        Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                                "Farmer Details filled and navigated to the crop details page"));
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
