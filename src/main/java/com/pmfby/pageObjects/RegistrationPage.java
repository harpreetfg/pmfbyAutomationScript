package com.pmfby.pageObjects;

import org.openqa.selenium.By;

public class RegistrationPage {

    public static By SELECT_STAKEHOLDER = By.xpath("//*[text()='Stakeholder']/following-sibling::select");
    public static By SELECT_BANK_TYPE = By.xpath("//*[contains(text(),'Bank Type')]/following-sibling::select");
    public static By SELECT_INSURANCE_COMPANY = By.xpath("//*[contains(text(),'Insurance Company')]/following-sibling::select");
    public static By SELECT_STATE_GOVERNMENT     = By.xpath("//*[contains(text(),'Choose State')]/following-sibling::select");
    public static By SELECT_USER_CATEGORY = By.xpath("//*[contains(text(),'User Category')]/following-sibling::select");
    public static By SELECT_STATE = By.xpath("//*[contains(text(),'State')]/following-sibling::select");
    public static By SELECT_DISTRICT = By.xpath("//*[contains(text(),'District')]/following-sibling::select");
    public static By SELECT_BANK_NAME = By.xpath("//*[contains(text(),'Bank Name')]/following-sibling::select");
    public static By SELECT_BANK_STATE_HEAD = By.xpath("//*[text()='Bank']/following-sibling::select");
    public static By SELECT_PACS = By.xpath("//*[text()='PACS']/following-sibling::select");
    public static By SELECT_BRANCH_NAME = By.xpath("//*[contains(text(),'Branch Name')]/following-sibling::select");
    public static By SELECT_IFSC_YES = By.cssSelector("[class*='customRadioInline']>div:nth-of-type(1) [type]");
    public static By SELECT_TITLE = By.xpath("//*[contains(text(),'Title')]/following-sibling::select");
    public static By USERNAME = By.cssSelector("[name=name]");
    public static By AADHAR = By.cssSelector("[name=aadhar]");
    public static By MOBILE = By.cssSelector("#formMobileText");
    public static By AADHAR_VERIFY_BUTTON = By.cssSelector("(//*[text()='Verify'])[1]");
    public static By MOBILE_VERIFY_BUTTON = By.cssSelector("(//*[text()='Verify'])[2]");
    public static By PASSWORD = By.cssSelector("[name=password]");
    public static By CONFIRM_PASSWORD = By.cssSelector("[name=confirmPassword]");
    public static By EMAIL = By.cssSelector("[name=email]");
    public static By DISCARD_BUTTON = By.cssSelector("[class*='btnDiscard']");
    public static By CREATE_BUTTON = By.cssSelector("[class*='customPrimaryButton']");
    public static By CAPTCHA = By.cssSelector("[name=captcha]");
    public static By CAPTCHA_VERIFY_BUTTON = By.xpath("//button[text()='Verify']");
    public static By OTP_SUBMIT_BUTTON = By.cssSelector("[class*=modalSubmitCenter]");
}
