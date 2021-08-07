package com.plivo.framework.commons;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverHelper {
    private static final Logger log = LoggerFactory.getLogger(WebDriverHelper.class);
    static WebDriver webDriver =null;
    static Properties configValues=null;
    
    
    public static Properties readConfigValues() throws IOException {
        FileReader reader=new FileReader("config//configuration.properties");

        configValues=new Properties();
        configValues.load(reader);
        return configValues;
    }
    
    public static void getWebDriverHelper() throws IOException {
        readConfigValues();
        if(configValues.getProperty("browser").equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("use-fake-ui-for-media-stream");
            System.setProperty("webdriver.chrome.driver", configValues.getProperty("chromeDriverLocation"));
            webDriver = new ChromeDriver(options);

        }else if(configValues.getProperty("browser").equalsIgnoreCase("firefox")){

            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("permissions.default.microphone", 1);
            options.addPreference("permissions.default.camera", 1);
            System.setProperty("webdriver.chrome.driver", configValues.getProperty("firefoxDriverLocation"));
            webDriver = new FirefoxDriver(options);

        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public static ArrayList getTotalTabs(){
        ArrayList<String> newTb = new ArrayList<String>(webDriver.getWindowHandles());
        return newTb;
    }

    public void waitForElement(WebElement elementToBeFound) {
        Integer timeout = Integer.parseInt(configValues.getProperty("fluentObjectTimeout"));
        try {
            FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver());
            wait.withTimeout(Duration.ofSeconds(timeout));
            wait.pollingEvery(Duration.ofMillis(100));
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.elementToBeClickable(elementToBeFound));
        } catch (Exception e) {
            log.warn("Element not present: " + e);
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        WebDriverHelper.webDriver = webDriver;
    }

    public static Properties getConfigValues() {
        return configValues;
    }

    public static void setConfigValues(Properties configValues) {
        WebDriverHelper.configValues = configValues;
    }
}
