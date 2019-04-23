package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkbox extends Elements {

    static VerifyElements verifyElements = new VerifyElements();
    protected static WebElement element;


    public void check(By locator){
        try{
            element = findElement(locator);
            if(!element.isSelected()){
                element.click();
            }
            else
                Loggers.logger.error("Checkbox web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Checkbox web element not located: "+locator);
        }
    }


    public void check(By locator, int index){
        try{
            int count = 0;
            if(findElements(locator) != null){
                List<WebElement> list = findElements(locator);
                for(WebElement element : list){
                    if(!VerifyElements.isElementVisible(locator)){
                        if(count == index)
                            element.click();
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Checkbox web element not located: " +locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Checkbox web element not located: " +locator);
        }
    }


    public void unCheck(By locator){
        try{
            element = findElement(locator);
            if(element.isSelected())
                element.click();
            else
                Loggers.logger.error("Checkbox web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Checkbox web element not located: "+locator);
        }
    }


    public void unCheck(By locator, int index){
        try{
            int count = 0;
            if(findElements(locator) != null){
                List<WebElement> list = findElements(locator);
                for(WebElement element : list){
                    if(VerifyElements.isElementVisible(locator)){
                        if(count == index)
                            element.click();
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Checkbox web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Checkbox web element not located: "+locator);
        }
    }
}
