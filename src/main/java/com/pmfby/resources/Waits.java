package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import com.pmfby.utility.WebDriverWrapper;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static com.pmfby.resources.Elements.findElement;


public class Waits extends WebDriverWrapper {

    public static int TIMEOUT = 30;

    public void setDefaultTimeout(int timeout){
        TIMEOUT = timeout;
    }


    public static void setTimeout(int timeout){
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
    }


    public static void setTimeoutMls(int timeout){
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
        getDriver().manage().timeouts().setScriptTimeout(timeout, TimeUnit.MILLISECONDS);
    }


    public static void waitAllWindowsLoaded(final int numberOfWindows){
        try{
            Loggers.logger.info("Wait for all windows to be loaded");
            new WebDriverWait(getDriver(), TIMEOUT){}
            .until(new ExpectedCondition<Boolean>() {
                @NullableDecl
                @Override
                public Boolean apply(@NullableDecl WebDriver webDriver) {
                    return (webDriver.getWindowHandles().size()==numberOfWindows);
                }
            });

            new WebDriverWait(getDriver(), TIMEOUT){}
            .until(new ExpectedCondition<Boolean>() {
                @NullableDecl
                @Override
                public Boolean apply(@NullableDecl WebDriver webDriver) {
                    boolean fullyLoaded = true;
                    for(String window:webDriver.getWindowHandles()){
                        if(window.isEmpty()){
                            fullyLoaded = false;
                            break;
                        }
                    }
                    return fullyLoaded;
                }
            });
            Thread.sleep(1000L);
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }


    public void waitForPageLoad(){
        try{
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            String js3 = "function getPageState(){" + "return document.readyState;" +"}; return getPageState()";
            String pageState = "";
            while(!pageState.equals("complete"))
                pageState = (String) executor.executeScript(js3);
        }
        catch (Exception e){
            Loggers.logger.error("Waiting for the page to load");
            e.getStackTrace();
        }
    }


    public void waitForElementToBeDisplayed(By locator){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 30);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (Exception e){
            Loggers.logger.error("Element Not available on the page");
            e.getStackTrace();
        }
    }


    public WebElement waitForTheElementToBePresent(By locator, int time) throws Exception {
        WebElement element = null;
        for(int i=0; i<time; i++){
                element = findElement(locator);
                if(element!=null)
                    break;
                else {
                    waitForElementToBeDisplayed(locator);
                    Loggers.logger.info("Waiting for the element to appear on the screen");
                }
        }
        if(element!=null)
            return element;
        else {
            Loggers.logger.error("Element not present in the page");
            return null;
         }
    }


    public void waitForElementToBeClickable(By locator){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch (Exception e){
            Loggers.logger.error("Clickable element not available");
            e.getStackTrace();
        }
    }


    public void waitForTheAlertToBePresent(){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 30);
            webDriverWait.until(ExpectedConditions.alertIsPresent());
        }
        catch (Exception e){
            Loggers.logger.error("Alert not present");
            e.getStackTrace();
        }
    }


    public void waitForTheTextToBePresent(By locator, String text){
        try{
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 30);
            webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        }
        catch (Exception e){
            Loggers.logger.error("Text not present");
            e.getStackTrace();
        }
    }
}
