package test.plivo_tests;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import test.common.Site;
import test.pageobjects.PlivoHomePageObject;
import test.pageobjects.PlivoLoginPageObject;

import java.io.IOException;

public class PlivoMakeCallFromCallerToCalle extends Site{
    private static final Logger log = LoggerFactory.getLogger(PlivoMakeCallFromCallerToCalle.class);
    
    @Test
    public void makeCallUsingPlivoWebSDK() throws IOException, InterruptedException {
        makeCall();
    }
    
    public void makeCall() throws IOException, InterruptedException {
        
        launchSite();
        PlivoLoginPageObject plivoLoginPageObject= PageFactory.initElements(getWebDriver(), PlivoLoginPageObject.class);
        log.info("Logging with the Caller credentials");
        PlivoHomePageObject plivoHomePageObject = plivoLoginPageObject.login(getConfigValues().getProperty("caller"), getConfigValues().getProperty("password"));
        plivoHomePageObject.verifyCallerLoginSuccess();
        
        log.info("Opening new tab and performing calle login to attempt call");
        plivoLoginPageObject = plivoHomePageObject.openCalleInNewTab();
        plivoHomePageObject = plivoLoginPageObject.login(getConfigValues().getProperty("callee"), getConfigValues().getProperty("password"));
        
        log.info("Navigating to caller tab to make outbound call");
        plivoHomePageObject.navCallerTab();
        plivoHomePageObject.MakeAnOutboundCall(getConfigValues().getProperty("callee"));

        log.info("Navigating to calle tab to answer incoming call");
        plivoHomePageObject.navCalleTab();
        plivoHomePageObject.answerCallAtCalleEnd();
        
        log.info("Navigating back to caller tab to verify call connection");
        plivoHomePageObject.navCallerTab();
        plivoHomePageObject.verifyCallConnection();
        
        log.info("End the Call at Caller Side");
        plivoHomePageObject.hangUpCallAtCallerSide();
        
        log.info("Closing the web application");
        tearDown();
        
    }
}
