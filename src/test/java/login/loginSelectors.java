package login;

import org.openqa.selenium.By;

public class loginSelectors {
    // Saucedemo username and password.
    public final static By SAUCEDEMO_USERNAME = By.id("user-name");
    public final static By SAUCEDEMO_PASSWORD = By.id("password");
    public final static By SAUCEDEMO_LOGIN_BUTTON = By.id("login-button");

    // Expand the navigation menu in left side.
    public final static By EXPAND_NAVIGATION_MENU = By.id("react-burger-menu-btn");

    // Logout from saucedemo website.
    public final static By LOGOUT_FROM_SAUCEDEMO = By.id("logout_sidebar_link");

    // SelectItems from saucedemo.
    public final static By SELECT_FIRST_ITEM = By.id("item_4_title_link");
    public final static By FIRST_ITEM_TO_CART = By.id("add-to-cart-sauce-labs-backpack");

    // Back from Add to Cart page.
    public final static By BACK_FROM_ADDTOCART = By.id("back-to-products");
}




