package com.pmfby.pageObjects;

import org.openqa.selenium.By;

public class ApplicationPage {

    public static By APPLICATION_FORM_LOANEE = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Application Form Loanee']");
    public static By APPLICATION_FORM_NON_LOANEE  = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Application Form Non Loanee']");
    public static By UNPAID_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Unpaid Applications']");
    public static By PAID_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Paid Applications']");
    public static By APPROVED_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Approved Applications']");
    public static By REJECTED_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Rejected Paid Applications']");
    public static By UTR_LIST = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='UTR List']");

    public static By CHOOSE_BRANCH_HEADER = By.xpath("(//*[text()='Choose Branch'])[1]");
    public static By SELECT_BRANCH = By.xpath("(//*[text()='Branch']/following-sibling::select)[1]");
    public static By SELECT_PACS = By.xpath("(//*[text()='PACS']/following-sibling::select)[1]");
    public static By SUBMIT_BUTTON_CHOOSE_BRANCH = By.xpath("(//*[text()='Submit'])[1]");
    public static By CHANGE_SSSY_ID_BUTTON = By.xpath("//button[text()='Change SSSY ID']");
    public static By BANK_ACCOUNT_NUMBER = By.cssSelector("input[name='bank loan account Number']");
    public static By CONFIRM_BANK_ACCOUNT_NUMBER = By.cssSelector("input[name='confirm bank loan account Number']");
    public static By ACCOUNT_TYPE = By.cssSelector("select[name='account type']");
    public static By ACCOUNT_HOLDER_COUNT = By.cssSelector("select[name='No. of Account Holder']");
    public static By CHECK_BANK_DETAILS_BUTTON = By.cssSelector("[class*='customPrimaryButton']");

    public static By FARMER_NAME  = By.cssSelector("input[name='Farmer Name']");
    public static By SELECT_VERIFICATION = By.xpath("select[class*='groupSelect']");
    public static By ID_PROOF = By.cssSelector("[name='Id proof']");
    public static By RELATION_TYPE = By.cssSelector("select[name='relation type']");
    public static By RELATIVE_NAME = By.cssSelector("input[name='Father Name']");
    public static By MOBILE_NUMBER = By.cssSelector("input[name='Mobile Number']");
    public static By AGE = By.cssSelector("input[name='Age']");
    public static By GENDER = By.cssSelector("select[name='Gender']");
    public static By CASTE_CATEGORY = By.cssSelector("select[name='Category']");
    public static By FARMER_CATEGORY = By.cssSelector("select[name='Farmer Category']");
    public static By FARMER_TYPE = By.cssSelector("select[name='Farmer Type']");
    public static By PRIMARY_FARMER = By.cssSelector("input[name='primaryFarmer']");
    public static By FARMER_STATE = By.cssSelector("[name='Farmer State']");
    public static By FARMER_DISTRICT = By.cssSelector("[name='Farmer District']");
    public static By FARMER_SUB_DISTRICT = By.cssSelector("[name='Farmer Sub District']");
    public static By FARMER_VILLAGE = By.cssSelector("[name='Farmer Village']");
    public static By FARMER_PINCODE = By.cssSelector("[name='Pincode']");
    public static By FARMER_ADDRESS = By.cssSelector("[name='address']");
    public static By ADD_ANOTHER_FARMER = By.xpath("//button[contains(text(),'Another Farmer')]");

    public static By NOMINEE_CHECKBOX = By.cssSelector("[name='Nominee']");
    public static By NOMINEE_NAME = By.xpath("//input[contains(@placeholder,'name of the nominee')]");
    public static By NOMINEE_AGE = By.xpath("//input[contains(@placeholder,'age of the nominee')]");
    public static By NOMINEE_RELATIONSHIP = By.xpath("[name='relation']");
    public static By NOMINEE_ADDRESS = By.xpath("//input[contains(@placeholder,'Address')]");
    public static By SAVE_AND_CONTINUE_BUTTON = By.xpath("//button[contains(text(),'Save & Continue')]");

    public static By CROP_DETAILS_DISTRICT = By.cssSelector("[name='INSURANCE District']");
    public static By CROP_DETAILS_TEHSIL_SUB_TEHSIL = By.cssSelector("[name='INSURANCE TehsilSubTehsil']");
    public static By CROP_DETAILS_GRAM_PANCHAYAT = By.cssSelector("[name='INSURANCE GramPanchayat']");
    public static By CROP_DETAILS_VILLAGE = By.cssSelector("[name='INSURANCE Village']");
    public static By MIX_CROP_CHECKBOX = By.cssSelector("[name='mixcrop']");
    public static By SELECT_CROP = By.cssSelector("select[data-cropdetailsindex]");
    public static By SELECT_PREMIUM_DEBIT_DATE = By.cssSelector("#premiumDebitDate0");
    public static By CALENDER_PREVIOUS_BUTTON = By.cssSelector("button[class*='leftButton']");
    public static By CALENDER_NEXT_BUTTON = By.cssSelector("button[class*='rightButton']");
    public static By SOWING_DATE = By.cssSelector("#sowingDatet0");
    public static By SURVEY_NUMBER = By.cssSelector("[name='Khata No']");
    public static By PLOT_NUMBER = By.cssSelector("[name='Khasra No']");
    public static By BACK_TO_FARMER_DETAILS_BUTTON = By.xpath("//button[contains(text(),'Back To Farmer Details')]");
    public static By PREVIEW_BUTTON = By.xpath("//button[contains(text(),'Preview')]");
    public static By SUBMIT_BUTTON = By.xpath("//button[contains(text(),'SUBMIT')]");

}
