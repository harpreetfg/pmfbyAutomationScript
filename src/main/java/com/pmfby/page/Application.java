package com.pmfby.page;

import com.aventstack.extentreports.Status;
import com.pmfby.pageObjects.ApplicationPage;
import com.pmfby.pageObjects.HomePage;
import com.pmfby.pageObjects.LoginPage;
import com.pmfby.resources.*;
import com.pmfby.utility.Loggers;
import com.pmfby.utility.Reports;
import org.testng.Assert;

import java.io.IOException;
import java.util.Objects;

public class Application {

    private Waits wait = new Waits();
    private Click click = new Click();
    private SelectDropDown select = new SelectDropDown();
    private ScreenShot capture = new ScreenShot();
    private TextBox text = new TextBox();
    private GetText getText = new GetText();
    private ScrollPage scroll = new ScrollPage();
    private SelectCalendar calendar = new SelectCalendar();
    private Elements elements = new Elements();
    private MouseHover hover = new MouseHover();

    private void selectUserBranch(){
        try{
            click.buttonClick(ApplicationPage.SELECT_BRANCH);
            select.selectElementByIndex(ApplicationPage.SELECT_BRANCH, 1);
//            select.selectElementByText(ApplicationPage.SELECT_BRANCH, "BILASPUR");
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


    public void fillLoaneeDetails(String accountNumber) throws IOException {
        try{
            click.buttonClick(ApplicationPage.APPLICATION_FORM_LOANEE);
            Thread.sleep(1000);
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
            Thread.sleep(1000);
            scroll.scrollDown();
            Loggers.logger.info("Clicked on the Check Bank Details & Continue button");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                    "Validating the provided bank details"));
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Failed to retrieve the Loanee Details");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                    "Failed to retrieve the Loanee Details"));
        }
    }


    public void fillUpNonLoaneeDetails(String bankState, String bankDistrict, String bankName, String bankBranch,
                                       String accountNumber) throws IOException {
        try{
            click.buttonClick(ApplicationPage.APPLICATION_FORM_NON_LOANEE);
            Thread.sleep(1000);
            if(VerifyElements.isElementPresent(ApplicationPage.SELECT_BRANCH)){
                selectUserBranch();
                wait.waitForPageLoad();
                if(VerifyElements.isElementPresent(ApplicationPage.BANK_ACCOUNT_NUMBER)){
                    Loggers.logger.info("User is dropped on Non Loanee Application Form page");
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                            "Successfully directed to the Non Loanee Application page"));
                }
                else{
                    Assert.fail();
                    Loggers.logger.error("Failed to navigate to the Application Non Loanee From page");
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                            "Failed to navigate to the Application Non Loanee From page"));
                }
            }
            else{
                Loggers.logger.info("Dropped on the Non Loanee Application Form page");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                        "Dropped on the Non Loanee Application Form page"));
            }
            click.buttonClick(ApplicationPage.BANK_STATE);
            select.selectElementByText(ApplicationPage.BANK_STATE, bankState);
            click.buttonClick(ApplicationPage.BANK_DISTRICT);
            select.selectElementByText(ApplicationPage.BANK_DISTRICT, bankDistrict);
            click.buttonClick(ApplicationPage.BANK_NAME);
            select.selectElementByText(ApplicationPage.BANK_NAME, bankName);
            click.buttonClick(ApplicationPage.BANK_BRANCH_NAME);
            select.selectElementByText(ApplicationPage.BANK_BRANCH_NAME, bankBranch);
            click.buttonClick(ApplicationPage.BANK_ACCOOUNT_TYPE);
            select.selectElementByText(ApplicationPage.BANK_ACCOOUNT_TYPE, "Saving");
            text.sendText(ApplicationPage.BANK_ACCOUNT_NUMBER, accountNumber);
            text.sendText(ApplicationPage.CONFIRM_BANK_ACCOUNT_NUMBER, accountNumber);
            click.buttonClick(ApplicationPage.CHECK_BANK_DETAILS_BUTTON);
            Thread.sleep(1000);
            wait.waitForElementToBeDisplayed(ApplicationPage.SAVE_AND_CONTINUE_BUTTON);
            scroll.scrollDown();
            Loggers.logger.info("Clicked on the Check Bank Details & Continue button");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                    "Validating the provided bank details"));
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Failed to retrieve the Non Loanee Details");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                    "Failed to retrieve the Non Loanee Details"));
        }
    }


    public void goToTheCropDetailsPage() throws IOException {
        try{
            if(VerifyElements.isElementPresent(ApplicationPage.SAVE_AND_CONTINUE_BUTTON)){
                if(!Objects.requireNonNull(elements.findElements(ApplicationPage.FARMER_NAME)).isEmpty()){
                    click.buttonClick(ApplicationPage.SAVE_AND_CONTINUE_BUTTON);
                    Loggers.logger.info("Clicked on the Save and Continue button");
                    wait.waitForElementToBeDisplayed(ApplicationPage.SELECT_CROP);
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                            "Farmer Details filled and navigated to the crop details page"));
                }
                else{
                    text.sendText(ApplicationPage.FARMER_NAME, "Test Farmer");
                    click.buttonClick(ApplicationPage.SELECT_VERIFICATION, 1);
                    if(!getText.getTextValue(ApplicationPage.SELECTED_SCHEME).contains("ASSAM")
                            ||!getText.getTextValue(ApplicationPage.SELECTED_SCHEME).contains("JAMMU")||
                            !getText.getTextValue(ApplicationPage.SELECTED_SCHEME).contains("MEGHALAYA")){
                        text.sendText(ApplicationPage.ID_PROOF, "999999999999");
                        click.buttonClick(ApplicationPage.RELATION_TYPE);
                        select.selectElementByIndex(ApplicationPage.RELATION_TYPE, 1);
                        text.sendText(ApplicationPage.MOBILE_NUMBER, "7770007770");
                        text.sendText(ApplicationPage.AGE, "33");
                        click.buttonClick(ApplicationPage.GENDER);
                        select.selectElementByIndex(ApplicationPage.GENDER, 1);
                        click.buttonClick(ApplicationPage.CASTE_CATEGORY);
                        select.selectElementByIndex(ApplicationPage.CASTE_CATEGORY, 1);
                        click.buttonClick(ApplicationPage.FARMER_CATEGORY);
                        select.selectElementByIndex(ApplicationPage.FARMER_CATEGORY, 1);
                        click.buttonClick(ApplicationPage.FARMER_TYPE);
                        select.selectElementByIndex(ApplicationPage.FARMER_TYPE, 1);

                        click.buttonClick(ApplicationPage.FARMER_STATE);
                        select.selectElementByText(ApplicationPage.FARMER_STATE, "HIMACHAL PRADESH");
                        click.buttonClick(ApplicationPage.FARMER_DISTRICT);
                        select.selectElementByText(ApplicationPage.FARMER_DISTRICT, "Bilaspur");
                        click.buttonClick(ApplicationPage.FARMER_SUB_DISTRICT);
                        select.selectElementByIndex(ApplicationPage.FARMER_SUB_DISTRICT, 1);
                        click.buttonClick(ApplicationPage.FARMER_VILLAGE);
                        select.selectElementByIndex(ApplicationPage.FARMER_VILLAGE, 1);
                        text.sendText(ApplicationPage.FARMER_PINCODE, "101010");
                        Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                                "After filling up the farmer details"));
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
            Loggers.logger.error("Failed to fill up the farmer details");
            Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                    "Failed to go to the Crop Details page"));
        }
    }


    public void submitApplication(){
        try{
            Thread.sleep(1000);
            click.buttonClick(ApplicationPage.CROP_DETAILS_DISTRICT);
            select.selectElementByIndex(ApplicationPage.CROP_DETAILS_DISTRICT, 2);
            Loggers.logger.info("Selected the notified District");
            click.buttonClick(ApplicationPage.CROP_DETAILS_BLOCK);
            select.selectElementByIndex(ApplicationPage.CROP_DETAILS_BLOCK, 2);
            Loggers.logger.info("Selected the notified Tehsil");
            click.buttonClick(ApplicationPage.CROP_DETAILS_GRAM_PANCHAYAT);
            select.selectElementByIndex(ApplicationPage.CROP_DETAILS_GRAM_PANCHAYAT, 2);
            Loggers.logger.info("Selected the notified Gram Panchayat");
            Thread.sleep(1000);
            click.buttonClick(ApplicationPage.CROP_DETAILS_VILLAGE);
            select.selectElementByIndex(ApplicationPage.CROP_DETAILS_VILLAGE, 1);
            Loggers.logger.info("Selected the notified Village");
            click.buttonClick(ApplicationPage.SELECT_CROP);
            Thread.sleep(1000);
            if(!elements.findElements(ApplicationPage.SELECT_CROP).isEmpty()){
                select.selectElementByIndex(ApplicationPage.SELECT_CROP, 1);
                Loggers.logger.info("Selected the crop");
                click.buttonClick(ApplicationPage.SELECT_PREMIUM_DEBIT_DATE);
                calendar.selectDate("22");
                click.buttonClick(ApplicationPage.SOWING_DATE);
                calendar.selectDate("2");
                text.sendText(ApplicationPage.SURVEY_NUMBER, "10a");
                text.sendText(ApplicationPage.PLOT_NUMBER, "11/b");
                text.sendText(ApplicationPage.INSURED_AREA, "2");
                click.buttonClick(ApplicationPage.ADD_CROP_FOR_INSURANCE);
                Loggers.logger.info("Clicked on the Add Crop For Insurance button");
                click.buttonClick(ApplicationPage.PREVIEW_BUTTON);
                Thread.sleep(1000);
                scroll.scrollBottom();
                if(VerifyElements.isElementVisible(ApplicationPage.SUBMIT_BUTTON)){
                    Loggers.logger.info("Previewing the application");
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.INFO,
                            "After clicking on the Preview button"));
                    click.buttonClick(ApplicationPage.SUBMIT_BUTTON);
                    wait.waitForElementToBeDisplayed(ApplicationPage.CLOSE_BUTTON);
                    if(VerifyElements.isElementPresent(ApplicationPage.POLICY_ID)){
                        Loggers.logger.info("Application has been successfully submitted");
                        Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                                "Application has been successfully submitted"));
                        Loggers.logger.info(getText.getTextValue(ApplicationPage.POLICY_ID));
                    }
                    else{
                        Loggers.logger.error("Application has not been submitted and hence failed.");
                        Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                                "Application has failed to be submitted"));
                        Assert.fail();
                    }
                }
                else{
                    Loggers.logger.error("Application cannot be previewed");
                    Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                            "Application cannot be previewed and hence gets failed to be submitted"));
                    Assert.fail();
                }
            }
            else{
                Loggers.logger.error("Notified Crops Not Available");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                        "Notified Crops Not Available and Hence Failed to Submit The Application"));
                Assert.fail();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void goToUnPaidApplicationPage(){
        try{
            hover.mouseHover(LoginPage.APPLICATION_TAB);
            click.buttonClick(ApplicationPage.APPLICATION_TAB_UNPAID_APPLICATION);
            wait.waitForPageLoad();
            if(VerifyElements.isElementPresent(ApplicationPage.FIND_APPLICATION_BUTTON)){
                Loggers.logger.info("Successfully landed on the Unpaid Application page");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                        "After Successfully Landing On The Unpaid Application Page"));
            }
            else{
                Loggers.logger.error("Failed to direct to the Unpaid Application Page");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                        "Failed to direct to the Unpaid Application Page"));
                Assert.fail();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void viewUnpaidApplicationList(){
        try{
            select.selectElementByIndex(ApplicationPage.INSURANCE_COMPANY_UNPAID, 1);
            select.selectElementByText(ApplicationPage.CROP_NAME_UNPAID, "All Crops");
            select.selectElementByText(ApplicationPage.ROLE_UNPAID, "Commercial Bank Branch Head");
            select.selectElementByText(ApplicationPage.BRANCH_NAME_UNPAID, "BILASPUR");
            click.buttonClick(ApplicationPage.FIND_APPLICATION_BUTTON);
            System.out.println("============================");
            wait.waitForElementToBeDisplayed(ApplicationPage.CHECKBOX_UNPAID_APPLICATION);
            if(VerifyElements.isElementPresent(ApplicationPage.APPLICATION_NUMBER_UNPAID)){
                Loggers.logger.info("Retrieving the Unpaid Applications list");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                        "Successfully retrieved the Unpaid Applications list"));
            }
            else{
                Loggers.logger.error("Unpaid Application list not available");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                        "Unpaid Application list not available"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void goToPaidApplication(){
        try{
            hover.mouseHover(LoginPage.APPLICATION_TAB);
            click.buttonClick(ApplicationPage.APPLICATION_TAB_PAID_APPLICATION);
            Loggers.logger.info("Clicked on the Paid Applications Tab");
            Thread.sleep(1000);
            if(VerifyElements.isElementPresent(ApplicationPage.PRINT_RECEIPT_BUTTON)){
                Loggers.logger.info("Dropped on the PAID APPLICATIONS page");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.PASS,
                        "After dropping on the PAID APPLICATION page"));
            }
            else{
                Loggers.logger.error("Failed to move to the PAID APPLICATIONS page");
                Reports.extentTest.addScreenCaptureFromPath(capture.takeScreenShot(Status.FAIL,
                        "Failed to move to the PAID APPLICATIONS page"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
