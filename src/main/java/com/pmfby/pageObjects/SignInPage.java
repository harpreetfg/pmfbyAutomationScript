package com.pmfby.pageObjects;

import org.openqa.selenium.By;

public class SignInPage {

    public static By MOBILE_NUMBER = By.cssSelector("[name='username']");
    public static By PASSWORD = By.cssSelector("[name='password']");
    public static By CAPTCHA = By.cssSelector("[name='captcha']");
    public static By FARMER_LOGIN_BUTTON = By.cssSelector("a[class*=loginButton]");
    public static By LOGIN_BUTTON = By.xpath("//button[text()='Login']");
    public static By FORGOT_PASSWORD_LINK = By.xpath("//*[text()='Forgot Password']");
    public static By OLD_USER_LOGIN_BUTTON = By.cssSelector("[class*=oldUserLoginBtn]");
    public static By SELECT_STAKEHOLDER = By.cssSelector("[placeholder*=StakeHolder]");
    public static By SELECT_CATEGORY = By.cssSelector("[placeholder*=Category]");
    public static By SELECT_STATE = By.cssSelector("[placeholder*=State]");
    public static By SELECT_DISTRICT = By.cssSelector("[placeholder*=District]");
    public static By SELECT_BANK_TYPE = By.cssSelector("[placeholder*='Bank Type']");
    public static By SELECT_BANK = By.cssSelector("[placeholder*='Bank List']");
    public static By SELECT_BRANCH = By.cssSelector("[placeholder*='Branch']");
    public static By SELECT_TITLE = By.cssSelector("[name=Title]");
    public static By USERNAME = By.cssSelector("[name=name]");
    public static By AADHAR = By.cssSelector("[name=aadhar]");
    public static By MOBILE = By.cssSelector("[type=number]");
    public static By AADHAR_VERIFY_BUTTON = By.cssSelector(".row>div:nth-of-type(1) [class*=verifyText]");
    public static By MOBILE_VERIFY_BUTTON = By.cssSelector(".row>div:nth-of-type(2) [class*=verifyText]");
    public static By CONFIRM_PASSWORD = By.cssSelector("[name=confirmPassword]");
    public static By EMAIL = By.cssSelector("[name=email]");
    public static By CREATE_BUTTON = By.cssSelector("[class*=customPrimaryButton]");
    public static By CLOSE_ICON = By.xpath("//*[contains(@src,'close')]");
    public static By MOBILE_NUMBER_FORGOT_PASSWORD = By.cssSelector("[name='mobileNo']");
    public static By REQUEST_OTP_BUTTON = By.xpath("//*[text()='Request OTP']");
    public static By OTP_TEXT_FIELD = By.cssSelector("[name='otp']");
    public static By RESEND_OTP_BUTTON = By.cssSelector("[class*='resendTextFP']");
    public static By VERIFY_OTP_BUTTON = By.xpath("//*[text()='Verify']");
}
