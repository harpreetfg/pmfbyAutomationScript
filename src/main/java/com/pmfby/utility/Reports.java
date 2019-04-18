package com.pmfby.utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;

import java.util.Date;

public class Reports {

    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Extent.html");
    public static ExtentReports extentReports = new ExtentReports();
    public static ExtentTest extentTest;
    public static com.relevantcodes.extentreports.ExtentTest test;

    public Reports(){}


    public Reports(String filePath, boolean flag){
        extentReports = new ExtentReports();
    }


    public void start(String testName){
        extentReports.attachReporter(htmlReporter);
        extentTest = extentReports.createTest(testName);
    }


    public ExtentTest setStartTime(Date date){
        extentTest.getModel().setStartTime(date);
        return extentTest;
    }


    public ExtentTest setEndTime(Date date){
        extentTest.getModel().setEndTime(date);
        return extentTest;
    }


    public void close(){
        extentReports.flush();
    }


    public void testResult(ITestResult result){
        Status status = null;
        try{
//            String screenShot = capture.takeScreenShot(status, "test");
//            result = Reporter.getCurrentTestResult();
            if(result.getStatus() == ITestResult.SUCCESS){
                extentTest.log(Status.PASS, result.getName());
//                extentTest.pass("Screenshot: " + extentTest.addScreenCaptureFromPath(screenShot));
                System.out.println("==================== PASS ====================");
            }
            else if(result.getStatus() == ITestResult.FAILURE){
                extentTest.log(Status.FAIL, result.getName());
//                extentTest.fail("Screenshot: " + extentTest.addScreenCaptureFromPath(screenShot));
                System.out.println("==================== FAIL ====================");
            }
            else if(result.getStatus() == ITestResult.SKIP)
//                extentTest.skip("Screenshot: " + extentTest.addScreenCaptureFromPath(screenShot));
                System.out.println("==================== SKIPPED ====================");
        }
        catch (Exception e){
            Loggers.logger.error("Result not found");
            e.getStackTrace();
        }
    }


    public void logTest(Status status, String stepName){
        extentTest.log(status, "<b><font face = \"Courier New\" color = \"#25549e\">" +stepName+ "</font></b>");
    }


    public void logTest(LogStatus status, String description, String expectedValue, String actualValue){
        if(status.toString().equals("pass"))
            test.log(status, "<b><font face = \"Courier New\" color = \"#0f9305\">" +description+ "</b></font>",
                    "<b><font face = \"Courier New\" color =\"#0f9305\">" +expectedValue+
                    "<b><font color = \"#0f9305\">" +actualValue+ "</b></font>" + "</b></font>");
        else if(status.toString().equals("fail"))
            test.log(status, "<b><font face = \"Courier New\" color = \"#d60606\">" +description+ "</b></font>",
                    "<b><font face = \"Courier New\" color =\"#d60606\">" +expectedValue+
                            "<b><font color = \"#d60606\">" +actualValue+ "</b></font>" + "</b></font>");
        else if(status.toString().equals("info"))
            test.log(status, "<b><font face = \"Courier New\" color = \"#1072a3\">" +description+ "</b></font>",
                    "<b><font face = \"Courier New\" color =\"#1072a3\">" +expectedValue+
                            "<b><font color = \"#1072a3\">" +actualValue+ "</b></font>" + "</b></font>");
    }

}
