package com.pmfby.pageObjects;

import org.openqa.selenium.By;

public class HomePage {

    public static By SIGN_IN_BUTTON = By.xpath("//*[text()='Sign in']");
    public static By REGISTER_BUTTON = By.xpath("//*[text()='Register']");
    public static By FARMER_CORNER = By.xpath("//a[text()='Farmer Corner']");
    public static By INSURANCE_CALCULATOR_LINK = By.xpath("//a[text()='Calculate']");
    public static By APPLICATION_STATUS_LINK = By.xpath("//a[text()='Application Status']");
    public static By CSC_BUTTON = By.cssSelector("a#CSC");
    public static By CSC_LOGIN_LINK = By.xpath("//a[@id='CSC']/following-sibling::ul//a[text()='CSC Login']");
    public static By CSC_LOCATOR_LINK = By.xpath("//a[@id='CSC']/following-sibling::ul//a[text()='CSC Locator']");



}
