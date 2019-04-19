package com.pmfby.resources;

import com.pmfby.utility.Loggers;
import com.pmfby.utility.WebDriverWrapper;

import java.util.ArrayList;
import java.util.List;

public class Window extends WebDriverWrapper {


    private List<String> child;


    public int getWindowHandles(){
        return driver.getWindowHandles().size();
    }


    public void switchWindow(int index){
        try{
            child = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(child.get(index));
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Windows not handled properly");
        }
    }


    public void switchToMainWindow(int index){
        try{
            driver.close();
            driver.switchTo().window(child.get(index));
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Window not handled properly");
        }
    }
}
