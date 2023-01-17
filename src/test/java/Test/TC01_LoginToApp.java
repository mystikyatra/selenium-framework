package Test;

import login.LoginScript;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC01_LoginToApp{
    WebDriver driver = new ChromeDriver();

    private LoginScript loginScript = new LoginScript(driver, driver);

    @Test
    public void loginToApp(){

        loginScript.signIn()
                .SelectFirstItem()
                .BackFromAddToCart()
                .LogoutFromApp();
    }

    @After
    public void closeDriver(){
        if(driver!=null){
            this.driver.quit();
            this.driver = null;
        }
    }
}




