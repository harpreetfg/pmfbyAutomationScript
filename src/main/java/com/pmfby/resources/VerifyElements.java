package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyElements extends Elements {

    protected static WebElement element;

    public static boolean isElementVisible(By locator){
        boolean isElement = false;
        try{
            element = findElement(locator);
            if(element.isDisplayed())
                isElement = true;
        }
        catch (Exception e){
            e.printStackTrace();
            Loggers.logger.error("Web element not located: " +locator );
            return false;
        }
        return isElement;
    }


    public static boolean isElementPresent(By locator){
        boolean isElement = false;
        try{
            element = findElement(locator);
            if(element != null)
                isElement = true;
            else
                Loggers.logger.error("Web element not located: " +locator);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return isElement;
    }


    public static boolean isElementSelected(By locator){
        boolean isSelected = false;
        try{
            element = findElement(locator);
            if(element.isSelected())
                isSelected = true;
            else
                Loggers.logger.error("Web element either not located or is not selected: "+locator);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return isSelected;
    }


    public static boolean isEnabled(By locator){
        boolean isEnabled = false;
        try{
            element = findElement(locator);
            if(element.isEnabled())
                isEnabled = true;
            else
                Loggers.logger.error("Web element not located or enabled: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return isEnabled;
    }
}
