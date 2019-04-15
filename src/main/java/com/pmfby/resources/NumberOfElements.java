package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NumberOfElements extends Elements {


    public int totalElements(By locator){
        try{
            List<WebElement> elements = null;
            if(findElements(locator) != null)
                elements = findElements(locator);
            else
                Loggers.logger.error("Elements not located: " +locator);
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return elements.size();
    }
}
