package com.pmfby.resources;

import com.google.common.base.Function;
import com.pmfby.utility.Loggers;
import com.pmfby.utility.WebDriverWrapper;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Elements extends WebDriverWrapper {

    static WebElement element = null;
    static List<WebElement> elements = null;

    public static WebElement findElement(final By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        try{
            return wait.until(new Function<WebDriver, WebElement>() {
                @NullableDecl
                @Override
                public WebElement apply(@NullableDecl WebDriver driver) {
                    element = driver.findElement(locator);
                    return element.isDisplayed() ? element : null;
                }
            });
        }
        catch (Exception e){
            Loggers.logger.error("Element not found: "+locator);
            return null;
        }
    }


    public static WebElement findElement(By locator, int time){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        try{
            return wait.until(new Function<WebDriver, WebElement>() {
                @NullableDecl
                @Override
                public WebElement apply(@NullableDecl WebDriver driver) {
                    element = driver.findElement(locator);
                    return element.isDisplayed() ? element : null;
                }
            });
        }
        catch (Exception e){
            Loggers.logger.error("No elements found: "+locator);
            e.getStackTrace();
            return null;
        }
    }


    public List<WebElement> findElements(By locator){
        try{
            elements = driver.findElements(locator);
            return elements.size() > 0 ? elements : null;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
