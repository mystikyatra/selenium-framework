package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {
    // Required Variables
    public static final String SAUCE_DEMO_URl;
    public static final String RUNTIME_ENV;
    public static final String BUILD_ID;
    public static final String REMOTE_DRIVER_URL;
    public static final String REMOTE_DRIVER_BROWSER_NAME;
    public static final String REMOTE_DRIVER_BROWSER_VERSION;

    private SystemProperties(){
            }
    private Properties readProperties(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("config/automation-tests.properties");

        Properties properties = new Properties();

        try{
            properties.load(is);
        } catch (IOException e){
            // do nothing
        }
        return properties;
    }

    static {
        SystemProperties systemProperties = new SystemProperties();
        Properties properties = systemProperties.readProperties();

        // Required Variables
        RUNTIME_ENV = properties.getProperty("runtime.environment", "LOCAL");
        BUILD_ID = System.getenv("BUILD_ID");

        // These variables are required to run automation in remote server like docker.
        REMOTE_DRIVER_URL = properties.getProperty("remote.driver.url");
        REMOTE_DRIVER_BROWSER_NAME = properties.getProperty("remote.driver.browser.name", "chrome");
        REMOTE_DRIVER_BROWSER_VERSION = properties.getProperty("remote.driver.browser.version", "94.0");

        SAUCE_DEMO_URl = properties.getProperty("sd.app.url");

    }
}
