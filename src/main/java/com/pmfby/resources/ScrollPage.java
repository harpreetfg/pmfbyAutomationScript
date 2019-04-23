package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import com.pmfby.utility.WebDriverWrapper;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollPage extends WebDriverWrapper {

    private static JavascriptExecutor js = (JavascriptExecutor)driver;

    public void scrollUp(){
        js.executeScript("window.scrollBy(250, 0)", "");
    }


    public void scrollDown(){
        try {
            Thread.sleep(2000);
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 450);");
        } catch (Throwable e) {
            Loggers.logger.error("Scroll Down is not working");
        }
    }


    public void scrollBottom(){
        try{
            Thread.sleep(1000);
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Scroll is not working");
        }
    }
}
