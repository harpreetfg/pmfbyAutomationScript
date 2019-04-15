package com.pmfby.execution;

import com.pmfby.page.PMFBYHome;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests extends TestExecution {

    @Test(description = "LOGIN")
    public void logIn() throws IOException {
        PMFBYHome home = new PMFBYHome();
        home.signIn();
    }
}
