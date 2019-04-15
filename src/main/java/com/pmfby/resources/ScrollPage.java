package com.pmfby.resources;

import com.pmfby.utility.WebDriverWrapper;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollPage extends WebDriverWrapper {

    private static JavascriptExecutor js = (JavascriptExecutor)driver;

    public static void scrollUp(){
        js.executeScript("window.scrollBy(250, 0)", "");
    }


    public static void scrollDown(){
        js.executeScript("window.scrollBy(0, 250)", "");
    }


    public static void scrollBottom(){
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }
}
