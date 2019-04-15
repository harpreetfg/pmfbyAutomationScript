package com.pmfby.resources;

import com.aventstack.extentreports.Status;
import com.pmfby.execution.TestExecution;
import com.pmfby.utility.Reports;
import com.pmfby.utility.WebDriverWrapper;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;

public class ScreenShot extends WebDriverWrapper {




    public String takeScreenShot(Status status, String stepName){
        try{
            File directory;
            File subFolder;
            String directoryPath;

            String cwd = System.getProperty("user.dir");
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

            directory = new File(cwd + File.separator + "Reports" + File.separator + "ScreenShot");
            if(!directory.exists()){
                directory.mkdirs();
                subFolder = new File(TestExecution.browserName);
                if(subFolder.exists()){
                    subFolder.delete();
                    subFolder.mkdir();
                }
                else
                    subFolder.mkdirs();
            }
            else{
                subFolder = new File(directory, TestExecution.browserName);
                if(subFolder.exists()){
                    subFolder.delete();
                    subFolder.mkdir();
                }
                else
                    subFolder.mkdir();
            }

            directoryPath = subFolder.getParent();
            System.out.println(directoryPath);
            String screenShotPath = directoryPath + File.separator + stepName + ".png";
            FileUtils.copyFile(source, new File(screenShotPath));
//            Reports.extentTest.addScreenCaptureFromPath(screenShotPath);
            System.out.println(screenShotPath);
            getScreenShot(status, stepName, screenShotPath);
            return "ScreenShot" +File.separator + stepName + ".png";
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public void getScreenShot(Status status, String stepName, String fileName){
        if(status.toString().equals("info")){
            Reporter.log("<a href=\"" +fileName+ "\">Screenshot</a>");
            Reports.extentTest.log(status, stepName);
        }
        else{
            Reports.extentTest.log(status, stepName);
            Reporter.log("<a href =\"" + fileName+ "\">ScreenShot</a>");
        }
    }

}
