package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.SystemProperties.*;

public class Utils {

    public static void delay(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static WebDriver getRemoteWebDriver(String testName){
        WebDriver driver = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
        try{
            DesiredCapabilities browser = new DesiredCapabilities();
            browser.setBrowserName(REMOTE_DRIVER_BROWSER_NAME);
            browser.setVersion(REMOTE_DRIVER_BROWSER_VERSION);

            // VNC config
            browser.setCapability("enableVNC", true);
            browser.setCapability("screenResolution", "1920*1080*24");

            // Video recording config
            browser.setCapability("enableVideo", true);
            browser.setCapability("videoScreenSize", "1920*1080");
            browser.setCapability("videoName", BUILD_ID + "-" + testName + "-" + sdf.format(new Date()) + ".mp4");

            // Logs config
            browser.setCapability("enableLog", true);

            // SSL config
            browser.setAcceptInsecureCerts(true);

            driver = new RemoteWebDriver(new URL(REMOTE_DRIVER_URL), browser);
            driver.manage().window().maximize();
        } catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriver getLocalWebDriver(){
        WebDriver driver = null;

        try{
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        } catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

    // This method will switch to all opened tabs and get each URL to compare with the given parameter.
    public static boolean browserTabExists(WebDriver driver, String url){
        for (String handle : driver.getWindowHandles()){
            delay(1000);
            driver.switchTo().window(handle);
            delay(1000);
            if(driver.getCurrentUrl().contains(url)){
                return true;
            }
        }
        return false;
    }

    public static WebDriver getWebDriver(String testName) {
        WebDriver driver = null;

        if (RUNTIME_ENV.equalsIgnoreCase("LOCAL")){
            driver = getLocalWebDriver();
        } else {
            driver = getRemoteWebDriver(testName);
        }
        return driver;
    }
}




