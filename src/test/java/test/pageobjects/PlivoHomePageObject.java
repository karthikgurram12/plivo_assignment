package test.pageobjects;


import com.plivo.framework.commons.AssertionHelper;
import com.plivo.framework.commons.WebDriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.common.HelperConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.plivo_tests.PlivoMakeCallFromCallerToCalle;

import java.io.IOException;


public class PlivoHomePageObject extends WebDriverHelper {
    private static final Logger log = LoggerFactory.getLogger(PlivoMakeCallFromCallerToCalle.class);
    
    AssertionHelper assertionHelper = new AssertionHelper();
    WebDriver driver;
    
    public PlivoHomePageObject(WebDriver driver){
        this.driver = driver;
    }
    
    @FindBy(id = "sipUserName")
    public WebElement sipUserNme;

    @FindBy(xpath = "//*[@class='logout']")
    public WebElement logoutBtn;
    
    @FindBy(id = "callstatus")
    public WebElement callStatus;
    
    @FindBy(id = "callerid")
    public WebElement callerId;

    @FindBy(id = "toNumber")
    public WebElement toNum;
    
    @FindBy(id = "makecall")
    public WebElement callBtn;
    
    @FindBy(xpath = "//*[@id='answerIncoming']/button")
    public WebElement answerCall;
    
    @FindBy(id = "hangup")
    public WebElement hangUp;
    
    public void verifyCallerLoginSuccess() throws IOException {
        waitForElement(sipUserNme);
        assertionHelper.getHardAssert().assertEquals(sipUserNme.getText(), readConfigValues().getProperty("caller")+"@phone.plivo.com", 
                "SIP UserName is not visible or incorrect in HomePage");
        assertionHelper.getHardAssert().assertEquals(callStatus.getText(), HelperConstants.IDLE_STATUS);
        assertionHelper.getHardAssert().assertTrue(callBtn.isDisplayed());
        log.info("Verified caller login");
    }
    
    public PlivoLoginPageObject openCalleInNewTab()  {
        log.info("open new window with js execute_script()");
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.open('');");
        navCalleTab();
        driver.get(getConfigValues().getProperty("webURL"));
        return  PageFactory.initElements(getWebDriver(), PlivoLoginPageObject.class);
    }
    
    public void navCallerTab(){
        log.info("Navigating to Caller Tab");
        driver.switchTo().window(getTotalTabs().get(0).toString());
    }

    public void navCalleTab(){
        log.info("Navigating to Callee Tab");
        driver.switchTo().window(getTotalTabs().get(1).toString());
    }

    public void MakeAnOutboundCall(String calle) {
        toNum.sendKeys(calle);
        callBtn.click();
        log.info("Calling...");
    }
    
    public void answerCallAtCalleEnd() throws InterruptedException {
        waitForElement(answerCall);
        answerCall.click();
        log.info("Answering...");
        Thread.sleep(5000);
    }

    public void verifyCallConnection() throws InterruptedException {
        Thread.sleep(5000);
        assertionHelper.getHardAssert().assertEquals(callStatus.getText(), HelperConstants.ANSWERED_STATUS);
        log.info("Call Connected Successfully");
    }
    
    public void hangUpCallAtCallerSide(){
        hangUp.click();
        log.info("Call Disconnected Successfully");
    }
    
}
