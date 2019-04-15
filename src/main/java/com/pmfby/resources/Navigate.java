package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import com.pmfby.utility.WebDriverWrapper;

public class Navigate extends WebDriverWrapper {


    public void navigateTo(String url){
        try{
            driver.navigate().to(url);
        }
        catch (Exception e){
            e.printStackTrace();
            Loggers.logger.error("Cannot navigate to the url: "+url);
        }
    }


    public void navigateBack(){
        try{
            driver.navigate().back();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Cannot navigate back to the last page.");
        }
    }


    public void navigateForward(){
        try{
            driver.navigate().forward();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Cannot navigate forward to the last page.");
        }
    }


    public void refreshPage(){
        try{
            driver.navigate().refresh();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Cannot refresh the page");
        }
    }
}
