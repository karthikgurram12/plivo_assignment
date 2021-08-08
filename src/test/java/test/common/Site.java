package test.common;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plivo.framework.commons.WebDriverHelper;


import java.io.IOException;

public class Site extends WebDriverHelper{
    private static final Logger log = LoggerFactory.getLogger(Site.class);
    
    public static void launchSite() throws IOException {
        BasicConfigurator.configure();
        log.info("Launching Plivo Web SDK URL");
        if(readConfigValues().getProperty("applicationPlatform").equalsIgnoreCase("web")) {
            getWebDriverHelper();
            getWebDriver().get(getConfigValues().getProperty("webURL"));
            log.info("Navigating to " + getConfigValues().getProperty("webURL"));
        }else if(readConfigValues().getProperty("applicationPlatform").equalsIgnoreCase("android")){
            getAppiumHelper();
        }
    }
    
    public static void tearDown(){
        getWebDriver().quit();
    }
}
