package com.pmfby.utility;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

public class Result {

    Reports reports = new Reports();

    public void verify(String expectedValue, String actualValue){
        try{
            Assert.assertEquals(expectedValue, actualValue);
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }


    public static boolean errorFlag = false;
    public static AssertionError firstAssertionError = null;
    public static StringBuilder errorLog = new StringBuilder();


    public void verifySafely(Object expectedValue, Object actualValue, String description){
        try{
            Assert.assertEquals(actualValue, expectedValue);
            reports.logTest(LogStatus.PASS, "Description: "+description, "Expected Result: "+expectedValue,
                    "Actual Result: "+actualValue);
        }
        catch (AssertionError ae){
            errorFlag = true;
            firstAssertionError = ae;
            reports.logTest(LogStatus.FAIL, "Description: "+description, "Expected Result: "+expectedValue,
                    "Actual Result: "+actualValue);
        }
    }


    public void verifyTrueSafely(boolean condition, String description){
        verifySafely(true, condition, description);
    }

    public void verifyFalseSafely(boolean condition, String description){
        verifySafely(false, condition, description);
    }


    public static void throwAssertionErrorOnFailure(){
        AssertionError ae = null;

        if(errorFlag){
            System.out.println("Should Throw");
            if(firstAssertionError != null){
                ae = new AssertionError(firstAssertionError.getMessage());
                ae.setStackTrace(firstAssertionError.getStackTrace());
                errorFlag = false;
                throw ae;
            }
            else{
                throw new AssertionError(errorLog);
            }
        }
    }
}
