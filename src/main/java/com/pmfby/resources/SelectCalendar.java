package com.pmfby.resources;

import com.pmfby.pageObjects.ApplicationPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectCalendar {

    Click click = new Click();
    GetText getText = new GetText();
    Elements elements = new Elements();

    public void selectDate(String date){
        try{
            List<WebElement> dates = elements.findElements(ApplicationPage.CALENDAR_MONTH_ALL_DATES);
            assert dates != null;
            for(WebElement element : dates){
                if(element.getText().equals(date)){
                    element.click();
                    break;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
