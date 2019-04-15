package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import com.pmfby.utility.WebDriverWrapper;

public class Alert extends WebDriverWrapper {


    public void clickOnOk(){
        try{
            driver.switchTo().alert().accept();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Alert box not located");
        }
    }


    public void clickOnCancel(){
        try{
            driver.switchTo().alert().dismiss();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Alert box not located");
        }
    }


    public String getText(){
        String text = null;
        try{
            text = driver.switchTo().alert().getText();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Alert box not located");
        }
        return text;
    }


    public void sendText(String text){
        try{
            driver.switchTo().alert().sendKeys(text);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Alert box not located");
        }
    }
}
