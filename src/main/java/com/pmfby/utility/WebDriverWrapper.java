package com.pmfby.utility;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WebDriverWrapper {

    public static WebDriver driver;

    public static  WebDriver getDriver(){
        return driver;
    }


    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


    public static String getCurrentWindowHandle(){
        return driver.getWindowHandle();
    }


    public static Set<String> getAllWindowHandles(){
        return driver.getWindowHandles();
    }


    public static String getTitle(){
        return driver.getTitle();
    }


    public static void maximize(){
        driver.manage().window().maximize();
    }


    public static void fullScreen(){
        driver.manage().window().fullscreen();
    }


    public static void closeCurrentTab(){
        driver.close();
    }


    public static void quit(){
        driver.quit();
    }
}
