package test;

import login.LoginScript;
import org.junit.Assert;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static util.SystemProperties.SAUCE_DEMO_URl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC01_LoginToApp{
    WebDriver driver = new ChromeDriver();

    private LoginScript loginScript;

    @Test
    public void loginToApp(){
        loginScript.signIn();
    }

    @After
    public void closeDriver(){
        if(driver!=null){
            this.driver.quit();
            this.driver = null;
        }
    }
}
