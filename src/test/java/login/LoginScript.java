package login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.SystemProperties;
import util.Utils;
import static login.loginSelectors.*;
import static util.SystemProperties.*;
import static util.Utils.delay;

public class LoginScript {
    private final WebDriver driver;
    private final WebDriver wait;
    public LoginScript(WebDriver driver, WebDriver wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public LoginScript signIn() {
        String expectedUrl = SAUCE_DEMO_URl;
        Assert.assertTrue("Expected to be in Saucedemo login", driver.getCurrentUrl().contains(expectedUrl));
        driver.get(expectedUrl);
        String username = System.getenv("SAUCE_DEMO_USERNAME");
        System.out.println(username);
        this.getUsername().sendKeys(username);
        String password = System.getenv("SAUCE_DEMO_PASSWORD");
        System.out.println(password);
        this.getPasswordField().sendKeys(password);
        this.getLoginButton().click();
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
}
