package test.pageobjects;

import com.plivo.framework.commons.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.plivo_tests.PlivoMakeCallFromCallerToCalle;

public class PlivoLoginPageObject extends WebDriverHelper {
    private static final Logger log = LoggerFactory.getLogger(PlivoMakeCallFromCallerToCalle.class);
    
    @FindBy(id = "loginUser")
    @CacheLookup
    public WebElement loginUsr;

    @FindBy(id = "loginPwd")
    @CacheLookup
    public WebElement loginPass;
    
    @FindBy(id = "clickLogin")
    @CacheLookup
    public WebElement loginBtn;

    @FindBy(id = "etUsername")
    @CacheLookup
    public WebElement loginAppUsrName;
    
    @FindBy(id = "etPassword")
    @CacheLookup
    public WebElement loginAppPass;
    
    @FindBy(id = "btLogin")
    @CacheLookup
    public WebElement appLoginBtn;
    
    public PlivoHomePageObject login(String userName, String password)
    {
        loginUsr.sendKeys(userName);
        loginPass.sendKeys(password);
        loginBtn.click();
        log.info("Login Successful");
        return PageFactory.initElements(getWebDriver(), PlivoHomePageObject.class);
    }
    
    public PlivoHomePageObject appLogin(String userName, String password) {
        loginAppUsrName.sendKeys(userName);
        loginAppPass.sendKeys(password);
        appLoginBtn.click();
        log.info("Login Successful");
        return PageFactory.initElements(getWebDriver(), PlivoHomePageObject.class);
    }
    
    
}
