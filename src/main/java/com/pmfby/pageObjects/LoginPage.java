package com.pmfby.pageObjects;

import org.openqa.selenium.By;

public class LoginPage {

    public static By SELECT_STATE_SSSYID = By.xpath("//*[contains(text(),'States')]/following-sibling::select");
    public static By SEARCH_SSSYID = By.cssSelector("[type='text']");
    public static By SELECT_SSSYID_RADIO_BUTTON = By.cssSelector("#radioSSSY02010219 [class^='radio']");
    public static By SUBMIT_BUTTON = By.xpath("//button[text()='Submit']");
    public static By HOME_TAB = By.xpath("(//a[text()='Home'])[1]");
    public static By CIRCULAR_TAB = By.xpath("(//a[text()='Circular'])");
    public static By APPLICATION_TAB = By.xpath("(//a[text()='Application'])");
    public static By REPORT_TAB = By.xpath("(//a[text()='Report'])");
    public static By USER_CONSOLE_TAB = By.xpath("(//a[text()='User Console'])");
    public static By INFO_TAB = By.xpath("(//a[text()='Info'])");
    public static By PRINT_PAGE_BUTTON = By.xpath("//*[text()='Print Page']");
    public static By PROFILE_BUTTON = By.cssSelector("[class*='profileImg']");
    public static By PROFILE_SETTINGS = By.xpath("//*[text()='Profile Settings']");
    public static By BUG_REPORT = By.xpath("//*[text()='Bug Report']");
    public static By SIGN_OUT = By.xpath("//*[text()='Sign out']");


    public static By OLD_PASSWORD = By.cssSelector("[placeholder='Old Password']");
    public static By NEW_PASSWORD = By.cssSelector("[placeholder='New Password']");
    public static By CONFIRM_NEW_PASSWORD = By.cssSelector("[placeholder='Confirm New Password']");
    public static By CHANGE_PASSWORD_SUBMIT_BUTTON = By.xpath("(//button[text()='Submit'])[2]");
    public static By CLOSE_CHANGE_PASSWORD = By.cssSelector("[class*='changePassword'] img");


    public static By UPLOAD_FILE_CIRCULAR = By.cssSelector("input[type=file]");
    public static By PRIORITY_TEXT = By.cssSelector("input[name=priority]");
    public static By DISPLAY_NAME_TEXT = By.cssSelector("[name=displayName]");
    public static By SUMMARY_TEXT = By.cssSelector("[name=summary]");
    public static By UPLOAD_BUTTON = By.xpath("//a[text()='Upload']");
    public static By CHANGE_SEASON_BUTTON = By.cssSelector("[class*=printPreviewNone]>div:nth-of-type(1) span");

    public static By SELECT_REPORT_TYPE = By.cssSelector("[class*=reportTypeDropdown] select");
    public static By SELECT_SEASON_DOWNLOAD = By.cssSelector("[placeholder='Select season']");
    public static By SELECT_YEAR_DOWNLOAD = By.cssSelector("[placeholder='Select Year']");
    public static By SELECT_SCHEME_DOWNLOAD = By.cssSelector("[placeholder='Select Scheme']");
    public static By SELECT_STATE_CROP_NOTIFICATION_DOWNLOAD = By.cssSelector("#cropNotification [placeholder='Select State']");
    public static By SELECT_DISTRICT_CROP_NOTIFICATION_DOWNLOAD = By.xpath("//*[@id='cropNotification']/following-sibling::div//select");
    public static By SELECT_STATE_CENSUS_DOWNLOAD = By.cssSelector("#census [placeholder='Select State']");
    public static By SELECT_DISTRICT_CENSUS_DOWNLOAD = By.xpath("//*[@id='census']/following-sibling::div//select");
    public static By SELECT_STATE_BANK_DOWNLOAD = By.cssSelector("#bank [placeholder='Select State']");
    public static By SELECT_DISTRICT_BANK_DOWNLOAD = By.xpath("//*[@id='bank']/following-sibling::div//select");
    public static By CROP_NOTIFICATION_MASTER_DOWNLOAD_BUTTON = By.xpath("//*[@id='cropNotification']/following-sibling::div//*[contains(@class,'btnDownload')]");
    public static By CENSUS_MASTER_DOWNLOAD_BUTTON = By.xpath("//*[@id='census']/following-sibling::div//*[contains(@class,'btnDownload')]");
    public static By BANK_BRANCH_MASTER_DOWNLOAD_BUTTON = By.xpath("//*[@id='bank']/following-sibling::div//*[contains(@class,'btnDownload')]");
    public static By CROP_MASTER_DOWNLOAD_BUTTON = By.xpath("(//*[text()='Download'])[4]");
    public static By INSURANCE_COMPANIES_MASTER_DOWLOAD = By.xpath("(//*[text()='Download'])[5]");

}
