package login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.Utils;

import static login.loginConfig.FB_APPLICATION_LOGIN;
import static login.loginSelectors.*;
import static util.SystemProperties.*;
import static util.Utils.delay;

public class loginScript {

    private final WebDriver driver;
    private final WebDriver wait;

    public loginScript(WebDriver driver, WebDriver wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public loginScript signIn() {
        driver.navigate().to(FB_APPLICATION_LOGIN);
        delay(1000);

        String expectedUrl = FB_APPLICATION_HOST;
        Assert.assertTrue("Expected to be in facebook login", driver.getCurrentUrl().contains(expectedUrl));
        this.getUserInput().sendKeys(FB_APPLICATION_USER_NAME);
        this.getPasswordField().sendKeys(FB_APPLICATION_USER_PASSWORD);
        this.getLoginButton().click();

        return this;
    }

    public void logoutFromApplication(){
        this.getYourProfileIcon().click();
        Utils.delay(1000);

        Select objProfileIcon = new Select(this.getYourProfileIcon());
        String selectLogout = "Log Out";
        objProfileIcon.selectByVisibleText(selectLogout);
    }

    private WebElement getUserInput(){
        return driver.findElement(LOGIN_PAGE_USER_NAME_INPUT);
    }

    private WebElement getPasswordField(){
        return driver.findElement(LOGIN_PAGE_PASSWORD_INPUT);
    }

    private WebElement getLoginButton(){
        return driver.findElement(LOGIN_PAGE_LOG_IN_BUTTON);
    }

    private WebElement getYourProfileIcon(){
        return driver.findElement(YOUR_PROFILE_ICON);
    }
}
