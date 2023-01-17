package login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.log.Log;
import util.SystemProperties;
import util.Utils;
import static login.loginSelectors.*;
import static util.SystemProperties.*;

public class LoginScript {
    private final WebDriver driver;
    private final WebDriver wait;
    public LoginScript(WebDriver driver, WebDriver wait) {
        new SystemProperties().readProperties();
        this.driver = driver;
        this.wait = wait;
    }
    public LoginScript signIn() {
        String expectedUrl = SAUCE_DEMO_URl;
        driver.get(expectedUrl);
        driver.manage().window().maximize();
        Assert.assertTrue("Expected to be in Saucedemo login", driver.getCurrentUrl().contains(expectedUrl));
        String username = System.getenv("SAUCE_DEMO_USERNAME");
        this.getUsername().sendKeys(username);
        String password = System.getenv("SAUCE_DEMO_PASSWORD");
        this.getPasswordField().sendKeys(password);
        this.getLoginButton().click();
        return this;
    }
    public LoginScript SelectFirstItem(){
        Utils.delay(1000);
        this.getSelectFirstItem().click();
        Utils.delay(2000);
        this.getFirstItemToCart().click();
        Utils.delay(2000);
        return this;
    }
    public LoginScript BackFromAddToCart(){
        Utils.delay(1000);
        this.getBackFromAddToCart().click();
        Utils.delay(2000);
        return this;
    }
    public LoginScript LogoutFromApp(){
        Utils.delay(1000);
        this.getExpandNavigationMenu().click();
        Utils.delay(5000);
        this.getLogoutFromSaucedemo().click();
        Utils.delay(5000);
        return this;
    }
    private WebElement getUsername () {
        return driver.findElement(SAUCEDEMO_USERNAME);
    }

    private WebElement getPasswordField () {
        return driver.findElement(SAUCEDEMO_PASSWORD);
    }

    private WebElement getLoginButton () {
        return driver.findElement(SAUCEDEMO_LOGIN_BUTTON);
    }
    private WebElement getSelectFirstItem (){
        return driver.findElement(SELECT_FIRST_ITEM);
    }
    private WebElement getFirstItemToCart (){
        return driver.findElement(FIRST_ITEM_TO_CART);
    }
    private WebElement getBackFromAddToCart (){
        return driver.findElement(BACK_FROM_ADDTOCART);
    }
    private WebElement getExpandNavigationMenu(){
        return driver.findElement(EXPAND_NAVIGATION_MENU);
    }
    private WebElement getLogoutFromSaucedemo(){
        return driver.findElement(LOGOUT_FROM_SAUCEDEMO);
    }
}




