package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Click extends Elements {

    static VerifyElements verifyElements = new VerifyElements();
    protected static WebElement element;


    public void buttonClick(By locator){
        try{
            element = findElement(locator);
            if(element != null){
                element.click();
                Thread.sleep(1000L);
            }
            else
                Loggers.logger.error("Button web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void buttonClick(By locator, int index){
        try{
            int count = 0;
            if(findElements(locator) != null){
                List<WebElement> list = findElements(locator);
                for(WebElement element:list){
                    if(verifyElements.isElementVisible(element)){
                        if(count == index){
                            list.get(index).click();
                            Thread.sleep(1000L);
                        }
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Button web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Button web element not located: "+locator);
        }
    }


    public static void buttonClickByKey(By locator){
        try{
            element = findElement(locator);
            if(element != null){
                element.sendKeys(Keys.ENTER);
                Thread.sleep(1000L);
            }
            else
                Loggers.logger.error("Button web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Button web element not located: "+locator);
        }
    }


    public static void buttonClickByKey(By locator, int index){
        try{
            int count = 0;
            if(findElements(locator) != null){
                List<WebElement> list = findElements(locator);
                for(WebElement element : list){
                    if(verifyElements.isElementVisible(element)){
                        if(count == index){
                            list.get(index).click();
                            Thread.sleep(1000L);
                        }
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Button web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Button web element not located: "+locator);
        }
    }
}
