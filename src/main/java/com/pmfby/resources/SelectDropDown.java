package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import com.pmfby.utility.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDown extends Elements {

    protected WebElement element;
    Result result = new Result();


    public void selectElementByIndex(By locator, int index){
        String text = null;
        try{
            element = findElement(locator);
            if(element != null){
                Select select = new Select(element);
                select.selectByIndex(index);
                text = select.getFirstSelectedOption().getText();
            }
            else
                Loggers.logger.error("Select web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Select web element not located: "+locator);
        }
    }


    public String defaultSelectedValue(By locator){
        String text = null;
        try{
            element = findElement(locator);
            if(element != null){
                Select select = new Select(element);
                text = select.getFirstSelectedOption().getText();
            }
            else
                Loggers.logger.error("Select web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Select web element not located: "+locator);
        }
        return text;
    }


    public void selectElementByText(By locator, String text){
        try{
            element = findElement(locator);
            if(element != null){
                Select select = new Select(element);
                select.selectByVisibleText(text);
            }
            else
                Loggers.logger.error("Select web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Select web element not located: "+locator);
        }
    }


    public void selectGetOptions(By locator){
        try{
            String arr[] = new String[0];
            element = findElement(locator);
            if(element != null){
                Select select = new Select(element);
                List<WebElement> list = select.getOptions();
                for(int i = 0; i<list.size(); i++)
                    result.verifySafely(arr[i], list.get(i).getText(), "Dropdown Content:- " +arr[i]+ " matches");
            }
            else
                Loggers.logger.error("Select web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Select web element not located: "+locator);
        }
    }


    public String getElementByText(By locator, String text){
        try{
            element = findElement(locator);
            if(element != null){
                Select select = new Select(element);
                select.selectByVisibleText(text);
                text = select.getFirstSelectedOption().getText();
            }
            else
                Loggers.logger.error("Select web element not located: "+locator);
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Select web element not located: "+locator);
        }
        return text;
    }
}
