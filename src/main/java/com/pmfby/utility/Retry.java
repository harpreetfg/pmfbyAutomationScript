package com.pmfby.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 1;


    public String getResultStatusName(int status){
        String resultName = null;
        if(status == 1)
            resultName = "SUCCESS";
        if(status == 2)
            resultName = "FAILURE";
        if(status == 3)
            resultName = "SKIP";
        return resultName;
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount<maxRetryCount){
            System.out.println("Retrying test "+iTestResult.getName()+" with status "+getResultStatusName(iTestResult.getStatus())+
                    " for the "+(retryCount+1)+ " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }
}
