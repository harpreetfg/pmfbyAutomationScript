package com.pmfby.execution;

import com.pmfby.page.PMFBYHome;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests extends TestExecution {


    PMFBYHome home = new PMFBYHome();

    @Test(description = "LOGIN")
    public void logIn() throws IOException {
        home.signIn();
    }

    @Test(description="Select the SSSYID", dependsOnMethods = {"logIn"})
    public void selectSSSYID() throws IOException {
        home.selectStateSSSYID("HIMACHAL PRADESH");
    }
}
