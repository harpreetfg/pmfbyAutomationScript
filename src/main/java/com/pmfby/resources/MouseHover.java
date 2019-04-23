package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHover extends Elements {


    static private VerifyElements verifyElements = new VerifyElements();
    static Actions actions;


    public void mouseHover(By locator){
        try{
            actions = new Actions(driver);
            element = findElement(locator);
            if(element != null)
                actions.moveToElement(element).build().perform();
            else
                Loggers.logger.error("Mouse hover web element not located: "+locator);
        }
        catch (Exception e){
            e.printStackTrace();
            Loggers.logger.error("Mouse hover web element not located: "+locator);
        }
    }


    public void mouseHoverForDropDownMenu(By locator){
        try{
            actions = new Actions(driver);
            element = findElement(locator);
            if(element != null)
                actions.moveToElement(element).sendKeys(Keys.ARROW_DOWN).build().perform();
            else
                Loggers.logger.error("Mouse hover web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Mouse hover web element not located: "+locator);
        }
    }


    public void elementMouseHover(By locator, int index){
        try{
            actions = new Actions(driver);
            int count = 0;
            if(findElements(locator) != null){
                List<WebElement> list = findElements(locator);
                for(WebElement element : list){
                    if(VerifyElements.isElementVisible(locator)){
                        if(count == index)
                            actions.moveToElement(list.get(index)).build().perform();
                    }
                    count++;
                }
            }
            else
                Loggers.logger.error("Mouse hover web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Mouse hoover web element not located: "+locator);
        }
    }


    public void rightClick(By locator){
        try{
            element = findElement(locator);
            if(element != null)
                actions.contextClick(element).build().perform();
            else
                Loggers.logger.error("Mouse hover web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Mouse hover web element not located: "+locator);
        }
    }


    public void newTab(By locator){
        try{
            actions = new Actions(driver);
            element = findElement(locator);
            if(element != null)
                actions.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.CONTROL, Keys.RETURN).build().perform();
            else
                Loggers.logger.error("Mouse hover web element not located");
        }
        catch (Exception e){
            e.printStackTrace();
            Loggers.logger.error("Mouse hover web element not located");
        }
    }
}
