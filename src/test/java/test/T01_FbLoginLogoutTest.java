package test;

import login.loginScript;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Utils;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class T01_FbLoginLogoutTest {

    //private WebDriver driver = null;
    //private WebDriverWait wait = null;

    private loginScript LoginScript;

    @Rule
    public TestName name = new TestName();

    @Before
    public void init(){
        this.driver = Utils.getWebDriver(name.getMethodName());
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        this.LoginScript = new loginScript(driver, wait);
    }

    @Test
    public void t01_loginAndLogoutFromApplication_test(){
        LoginScript.signIn();
        LoginScript.logoutFromApplication();
            }
}
