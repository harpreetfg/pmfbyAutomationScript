package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetText extends Elements {

    protected WebElement element;


    public String getTextValue(By locator){
        String text = null;
        try{
            element = findElement(locator);
            if(element != null)
                text = element.getText();
            else
                Loggers.logger.error("Web Element not located: "+locator);
        }
        catch(Exception e){
            Loggers.logger.error("Web Element not located: "+locator);
            e.printStackTrace();
        }
        return text;
    }


    public String getTextValue(By locator, int index){
        String text = null;
        int count = 0;
        try{
            if(findElements(locator) != null){
                List<WebElement> list = findElements(locator);
                for(WebElement element:list){
                    if(VerifyElements.isElementVisible(element)){
                        if(count == index)
                            text = element.getText();
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Web element not located: "+locator);
            return text;
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Web element not located: "+locator);
            return null;
        }
    }


    public String getAttributeValue(By locator, String attributeName){
        String attributeValue = null;
        try{
            element = findElement(locator);
            if(element != null)
                attributeValue = element.getAttribute(attributeName);
            else
                Loggers.logger.error("Web element not located: "+locator);
            return attributeValue;
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Web element not located: "+locator);
            return null;
        }
    }
}
