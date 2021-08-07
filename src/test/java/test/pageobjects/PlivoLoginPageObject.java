package test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.plivo_tests.PlivoMakeCallFromCallerToCalle;

public class PlivoLoginPageObject {
    private static final Logger log = LoggerFactory.getLogger(PlivoMakeCallFromCallerToCalle.class);
    
    WebDriver driver;
    
    public PlivoLoginPageObject(WebDriver driver){
        this.driver=driver;
    }
    
    @FindBy(id = "loginUser")
    @CacheLookup
    public WebElement loginUsr;

    @FindBy(id = "loginPwd")
    @CacheLookup
    public WebElement loginPass;
    
    @FindBy(id = "clickLogin")
    @CacheLookup
    public WebElement loginBtn;
    
    public PlivoHomePageObject login(String userName, String password)
    {
        loginUsr.sendKeys(userName);
        loginPass.sendKeys(password);
        loginBtn.click();
        log.info("Login Successful");
        return PageFactory.initElements(driver, PlivoHomePageObject.class);
    }
    
    
}
