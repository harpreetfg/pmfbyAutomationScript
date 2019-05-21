package com.pmfby.execution;

import com.pmfby.config.PMFBYConfig;
import com.pmfby.utility.LaunchBrowser;
import com.pmfby.utility.Loggers;
import com.pmfby.utility.Reports;
import com.pmfby.utility.Result;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestExecution extends Result {

    private Reports reports = new Reports();
    private LaunchBrowser browser = new LaunchBrowser();
    public static String browserName = null;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    ITestResult result;
    String className = this.getClass().getSimpleName();
    String cwd = "user.dir";


    @BeforeTest(alwaysRun = true)
    @Parameters({"BROWSERTYPE", "REMOTE"})
    public void createTestResult(String browserType, String remote){
        browserName = browserType;
        reports = new Reports(PMFBYConfig.REPORT_PATH + "PMFBY_REPORT" + browserType + "_"
        + dateFormat.format(new Date()) + ".html", true);
        if(!browserType.isEmpty()){
            try{
                browser.setDriver(browserType, remote);
                Loggers.logger.info("Completed Initialization");
            }
            catch(Exception e){
                e.printStackTrace();
                Loggers.logger.error("Initialization Failed");
            }
        }
    }


    @BeforeMethod(alwaysRun = true)
    public void start(Method call){
        reports.start(call.getName());
        reports.setStartTime(new Date());
        System.out.println(call.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void end(){
        reports.setEndTime(new Date());
    }

    @AfterSuite(alwaysRun = true)
    public void terminateTest(){
        if(reports != null)
            reports.close();
    }
}