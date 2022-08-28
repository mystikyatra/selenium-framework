package login;

import util.SystemProperties;

import static util.SystemProperties.FB_APPLICATION_HOST;

public abstract class loginConfig {
    public static final String FB_APPLICATION_LOGIN = FB_APPLICATION_HOST;
    public static final String USER = SystemProperties.FB_APPLICATION_USER_NAME;
    public static final String PASSWORD = SystemProperties.FB_APPLICATION_USER_PASSWORD;
}
