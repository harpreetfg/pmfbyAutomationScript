package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBox extends Elements {

    protected static WebElement element;


    public void sendText(By locator, String data){
        try{
            element = findElement(locator);
            if(element!=null){
                element.clear();
                element.sendKeys(data);
            }
            else
                Loggers.logger.error("Input text box not located: "+locator);
        }
        catch (Exception e){
            e.printStackTrace();
            Loggers.logger.error("Input text box not located: "+locator);
        }
    }


    public void sendText(By locator, String data, int index){
        try{
            int count = 0;
            if(findElements(locator)!=null){
                List<WebElement> list = findElements(locator);
                for(WebElement element : list){
                    if(VerifyElements.isElementPresent(locator)){
                        if(count == index){
                            element.clear();
                            element.sendKeys(data);
                        }
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Input text box web element not located: "+locator);
        }
        catch (Exception e){
            e.printStackTrace();
            Loggers.logger.error("Input text box web element not located: "+locator);
        }
    }


    public static void textAndEnter(By locator, String data){
        try{
            element = findElement(locator);
            if(element != null){
                element.clear();
                element.sendKeys(data);
                element.sendKeys(Keys.ENTER);
            }
            else
                Loggers.logger.error("Input text box web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Input text box web element not located: "+locator);
        }
    }


    public void textAndEnter(By locator, String data, int index){
        try{
            int count = 0;
            if(findElements(locator)!=null){
                List<WebElement> list = findElements(locator);
                for(WebElement element:list){
                    if(VerifyElements.isElementVisible(locator)){
                        if(count == index){
                            element.clear();
                            element.sendKeys(data);
                            element.sendKeys(Keys.ENTER);
                        }
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Input text box web element not located: "+locator);
        }
        catch (Exception e){
            e.printStackTrace();
            Loggers.logger.error("Input text box web element not located: "+locator);
        }
    }
}
