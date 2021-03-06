package com.pmfby.pageObjects;

import org.openqa.selenium.By;

public class ApplicationPage {

    public static By APPLICATION_FORM_LOANEE = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Application Form Loanee']");
    public static By APPLICATION_FORM_NON_LOANEE  = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Application Form Non Loanee']");
    public static By UNPAID_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Unpaid Applications']");
    public static By APPLICATION_TAB_UNPAID_APPLICATION = By.xpath("//a[text()='Unpaid Applications']");
    public static By APPLICATION_TAB_PAID_APPLICATION = By.xpath("//a[text()='Paid Applications']");
    public static By PAID_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Paid Applications']");
    public static By APPROVED_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Approved Applications']");
    public static By REJECTED_APPLICATIONS = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='Rejected Paid Applications']");
    public static By UTR_LIST = By.xpath("//*[contains(@class,'btnPolicy')]/a[text()='UTR List']");
    public static By SELECTED_SCHEME = By.cssSelector("[class*=bankIFSCDetails]");

    public static By CHOOSE_BRANCH_HEADER = By.xpath("(//*[text()='Choose Branch'])[1]");
    public static By SELECT_BRANCH = By.xpath("(//*[text()='Branch']/following-sibling::select)");
    public static By SELECT_PACS = By.xpath("(//*[text()='PACS']/following-sibling::select)[1]");
    public static By SUBMIT_BUTTON_CHOOSE_BRANCH = By.xpath("(//*[text()='Submit'])[1]");
    public static By CHANGE_SSSY_ID_BUTTON = By.xpath("//button[text()='Change SSSY ID']");
    public static By BANK_ACCOUNT_NUMBER = By.cssSelector("input[name='bank loan account Number']");
    public static By CONFIRM_BANK_ACCOUNT_NUMBER = By.cssSelector("input[name='confirm bank loan account Number']");
    public static By ACCOUNT_TYPE = By.cssSelector("select[name='account type']");
    public static By ACCOUNT_HOLDER_COUNT = By.cssSelector("select[name='No. of Account Holder']");
    public static By CHECK_BANK_DETAILS_BUTTON = By.cssSelector("[class*='customPrimaryButton']");
    public static By BANK_STATE = By.cssSelector("[name='bank state']");
    public static By BANK_DISTRICT = By.cssSelector("[name='bank district']");
    public static By BANK_NAME = By.cssSelector("[name='Bank name']");
    public static By BANK_BRANCH_NAME = By.cssSelector("[name='Branch name']");
    public static By BANK_ACCOOUNT_TYPE = By.cssSelector("[name='bank type']");

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
    public static By PRIMARY_FARMER = By.xpath("(//input[@name='primaryFarmer'])[1]");
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
    public static By CROP_DETAILS_BLOCK = By.cssSelector("[name='INSURANCE Block']");
    public static By CROP_DETAILS_GRAM_PANCHAYAT = By.cssSelector("[name='INSURANCE GramPanchayat']");
    public static By CROP_DETAILS_VILLAGE = By.cssSelector("[name='INSURANCE Village']");
    public static By MIX_CROP_CHECKBOX = By.cssSelector("[name='mixcrop']");
    public static By SELECT_CROP = By.cssSelector("select[data-cropdetailsindex]");
    public static By SELECT_PREMIUM_DEBIT_DATE = By.cssSelector("#premiumDebitDate0");
//    public static By DATE_NOT_AVAILABLE = By.cssSelector()
    public static By CALENDER_PREVIOUS_BUTTON = By.cssSelector("button[class*='leftButton']");
    public static By CALENDER_NEXT_BUTTON = By.cssSelector("button[class*='rightButton']");
    public static By SOWING_DATE = By.cssSelector("#sowingDatet0");
    public static By SURVEY_NUMBER = By.cssSelector("[name='Khata No']");
    public static By PLOT_NUMBER = By.cssSelector("[name='Khasra No']");
    public static By INSURED_AREA = By.cssSelector("[name='insured area']");
    public static By ADD_CROP_FOR_INSURANCE = By.xpath("//button[contains(text(),'Add Crop for Insurance')]");
    public static By REMOVE_ADDED_CROP = By.xpath("//*[text()=' X']");
    public static By BACK_TO_FARMER_DETAILS_BUTTON = By.xpath("//button[contains(text(),'Back To Farmer Details')]");
    public static By PREVIEW_BUTTON = By.xpath("//button[contains(text(),'Preview')]");
    public static By SUBMIT_BUTTON = By.xpath("//button[contains(text(),'SUBMIT')]");
    public static By POLICY_ID = By.xpath("//*[text()='Policy ID']/following-sibling::i");
    public static By CLOSE_BUTTON = By.xpath("//*[text()='Close']");

    public static By CALENDAR_MONTH_ALL_DATES = By.xpath("(//*[contains(@class,'CalendarMonth_table')])[2]//td[@role='button']");
    public static By CURRENT_YEAR_MONTH = By.cssSelector("[data-visible='true'] strong");



    public static By INSURANCE_COMPANY_UNPAID = By.cssSelector("[name='Insurance Company']");
    public static By CROP_NAME_UNPAID = By.cssSelector("[name='Crop Name']");
    public static By ROLE_UNPAID = By.cssSelector("[name='Role']");
    public static By BRANCH_NAME_UNPAID = By.cssSelector("[name='Policy Branch']");
    public static By FIND_APPLICATION_BUTTON = By.xpath("//*[contains(text(),'Find Application')]");
    public static By ATTACH_UTR_BUTTON = By.xpath("//*[contains(text(),'Attach UTR')]");
    public static By CHECKBOX_UNPAID_APPLICATION = By.cssSelector("[name='policyNumberUtr0']");
    public static By UTR_LIST_UNPAID = By.cssSelector("[name='UTR LIST']");
    public static By SUBMIT_ATTACH_UTR = By.xpath("//a[contains(text(),'Submit')]");
    public static By APPLICATION_NUMBER_UNPAID = By.xpath("//tbody//td[3]");
    public static By PAGINATION_COUNT = By.cssSelector("select#formHorizontalEmail");
    public static By PRINT_RECEIPT_BUTTON = By.xpath("//button[contains(text(),'//button[contains(text(),'Print Receipt')]')]");

}
