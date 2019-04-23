package com.pmfby.utility;

import com.pmfby.config.PMFBYConfig;
import com.pmfby.resources.Waits;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser extends WebDriverWrapper {


    DesiredCapabilities capabilities = null;
    String driverPath = "src\\main\\java\\com\\pmfby\\driver";
    Waits wait = new Waits();


    public void setDriver(String browserType, String remote){
        try{
            String cwd = System.getProperty("user.dir");
            if(browserType.equalsIgnoreCase("Firefox")){
                Loggers.logger.info("Firefox has been selected as the browser");
                System.setProperty("webdriver.gecko.driver", cwd + File.separator + driverPath + File.separator + "geckodriver.exe");
                if(remote.equalsIgnoreCase("true")){
                    capabilities = DesiredCapabilities.firefox();
                    capabilities.setBrowserName("FIREFOX");
                    capabilities.setPlatform(Platform.ANY);
                    try{
                        driver = new RemoteWebDriver(new URL(PMFBYConfig.PMFBY_URL), capabilities);
                    }
                    catch(MalformedURLException e){
                        e.printStackTrace();
                        Loggers.logger.error("Remote URL is invalid: "+PMFBYConfig.PMFBY_URL);
                    }
                }
                else{
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxProfile.setAcceptUntrustedCertificates(true);
                    firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
                    firefoxProfile.setPreference("javascript.enabled", true);
                    firefoxProfile.setPreference("dom.max_script_run_time", 0);
                    firefoxProfile.setPreference("dom.max_chrome_script_run_time", 0);
                    firefoxProfile.setPreference("browser.download.flderList", 1);
                    firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                    firefoxOptions.setProfile(firefoxProfile);
                    driver = new FirefoxDriver(firefoxOptions);
                }
            }
            else if(browserType.equalsIgnoreCase("explorer")){
                Loggers.logger.info("Internet Explorer has been selected as the browser");
                System.setProperty("webdriver.ie.driver", cwd + File.separator + driverPath + File.separator + "IEDriverServer.exe");
                if(remote.equalsIgnoreCase("true")){
                    capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setBrowserName("Internet Explorer");
                    capabilities.setPlatform(Platform.WINDOWS);
                    try{
                        driver = new RemoteWebDriver(new URL(PMFBYConfig.PMFBY_URL), capabilities);
                    }
                    catch(MalformedURLException e){
                        e.printStackTrace();
                        Loggers.logger.error("Remote URL is invalid: "+PMFBYConfig.PMFBY_URL);
                    }
                }
                else{
                    InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                    internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    internetExplorerOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
                    internetExplorerOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
                    internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
                    internetExplorerOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                    internetExplorerOptions.ignoreZoomSettings();
                    internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                    driver = new InternetExplorerDriver(internetExplorerOptions);
                }
            }
            else if(browserType.equalsIgnoreCase("chrome")){
                Loggers.logger.info("Google chrome is selected as the browser");
                System.setProperty("webdriver.chrome.driver", cwd + File.separator + driverPath + File.separator + "chromedriver.exe");
                if(remote.equalsIgnoreCase("true")){
                    capabilities = DesiredCapabilities.chrome();
                    capabilities.setBrowserName("Google Chrome");
                    capabilities.setPlatform(Platform.ANY);
                    try{
                        driver = new RemoteWebDriver(new URL(PMFBYConfig.PROD_CI_URL), capabilities);
                    }
                    catch(MalformedURLException e){
                        e.printStackTrace();
                        Loggers.logger.error("Remote URL is invalid: "+PMFBYConfig.PROD_CI_URL);
                    }
                }
                else{
                    ChromeOptions options = new ChromeOptions();
                    String downloadFilePath = "C:\\Users\\Farmguide\\Downloads";
                    HashMap<String, Object> chromePrefs = new HashMap<>();
                    chromePrefs.put("profile.defualt_content_settings.popups", 0);
                    chromePrefs.put("download.defualt_directory", downloadFilePath);
                    options.addArguments(Arrays.asList("--start-maximized", "--test-type", "--ignore-certificate-errors",
                            "--disable-popup-blocking", "--allow-running-insecure-content", "--disable-translate", "--always-authorize-plugins"));
                    options.setExperimentalOption("prefs",chromePrefs);
                    driver = new ChromeDriver(options);
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(PMFBYConfig.DEV1_URL);
            wait.waitForPageLoad();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Browser not initialized");
        }
    }


    public void quitBrowser(){
        try{
            Loggers.logger.error("Close all instance of current browser");
            driver.quit();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Browser didn't get close");
        }
    }


    public void closeCurrentWindow(){
        try{
            Loggers.logger.info("Closing the current window");
            driver.close();
        }
        catch(Exception e){
            e.printStackTrace();
            Loggers.logger.error("Current window not closed");
        }
    }
}
