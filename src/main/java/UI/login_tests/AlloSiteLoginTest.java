package UI.login_tests;

import UI.WebDriverConfiguration.WebDriverEnumeration;
import UI.WebDriverConfiguration.WebDriverFactory;
import UI.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static API.Constants.Constants.LOGGER;
import static UI.Constants.Constants.*;
import static org.testng.Assert.assertFalse;

public class AlloSiteLoginTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private LoginPage loginPage;

    @BeforeTest
    public void createDriver() {
        driver.set(WebDriverFactory.getWebDriver(WebDriverEnumeration.CHROME));
        loginPage = new LoginPage(driver.get());
    }

    @Test(description = "Verify ability to login to the allo site with incorrect credentials", priority = 2)
    public void verifyLoginWithIncorrectData() {
        loginPage.login(PHONE_NUMBER, PHONE_NUMBER);
        LOGGER.info("The text from form : " + loginPage.getHiddenErrorLabel());

        assertFalse(loginPage.getHiddenErrorLabel().isEmpty());
    }

    @Test(description = "Verify ability to create a new account with incorrect data", priority = 3)
    public void verifyRegisterWithIncorrectData() {
        loginPage.registerAccount(PHONE_NUMBER, PHONE_NUMBER, PHONE_NUMBER);
        LOGGER.info("The text from form : " + loginPage.getValidationRegisterErrorMessage());

        assertFalse(loginPage.getValidationRegisterErrorMessage().isEmpty());
    }

    @Test(description = "Verify ability to create a new account with existing data", priority = 4)
    public void verifyRegisterUserAgain() {
        loginPage.registerAccount(NAME, EMAIL, "");
        LOGGER.info("The text from form : " + loginPage.getErrorMessageDuringRegistrationExistingUser());

        assertFalse(loginPage.getErrorMessageDuringRegistrationExistingUser().isEmpty());
    }

    @AfterTest
    public void disposeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}
