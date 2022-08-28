package login;

import org.openqa.selenium.By;

public class loginSelectors {
    // Facebook login page
    public final static By LOGIN_PAGE_USER_NAME_INPUT = By.id("email");
    public final static By LOGIN_PAGE_PASSWORD_INPUT = By.id("pass");
    public final static By LOGIN_PAGE_LOG_IN_BUTTON = By.name("login");
    public final static By YOUR_PROFILE_ICON = By.cssSelector(".j83agx80.l9j0dhe7");
}
