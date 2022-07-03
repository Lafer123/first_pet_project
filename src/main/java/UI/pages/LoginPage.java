package UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'mh-profile']/child::button")
    private WebElement openProfile;

    @FindBy(xpath = "//div[@id = 'customer-popup-menu']")
    private WebElement loginForm;

    @FindBy(xpath = "//div[@id = 'customer-popup-menu']//following-sibling::li")
    private WebElement registerForm;

    @FindBy(xpath = "//div[@id = 'customer-popup-menu']/descendant::li[position() = '1']")
    private WebElement entranceForm;

    /**
     * Enter to the account
     */

    @FindBy(xpath = "//div[@class = 'v_input_field']/input[@id = 'auth']")
    private WebElement enterEmailField;

    @FindBy(xpath = "//div[@class = 'v_input_field']/input[@id = 'v-login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class = 'modal-submit-button']")
    private WebElement enterButton;

    /**
     * Register form
     */

    @FindBy(xpath = "//input[@id = 'v-register-name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id = 'v-register_telephone_number']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id = 'vregister-password']")
    private WebElement registerPasswordField;

    @FindBy(xpath = "//button[@class = 'modal-submit-button']")
    private WebElement submitRegisterButton;

    /* Label`s */
    @FindBy(xpath = "//div[@class = 'validation-advice v-validation-error']//span")
    private WebElement errorMessageWhileRegistrationExistingUser;

    @FindBy(xpath = "//div[@class = 'modal-input validation-error']/label[@class = 'hidden-label']")
    private WebElement hiddenEntranceEmail;

    @FindBy(xpath = "//div[@class = 'validation-advice v-validation-error']//span")
    private WebElement validationRegisterError;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void openPopUpForLogin() {
        openProfile.click();
    }

    private LoginPage openEntranceForm() {
        openPopUpForLogin();
        waitVisibility(loginForm);
        entranceForm.click();
        return this;
    }

    private LoginPage enterEntranceEmail(String email) {
        enterEmailField.sendKeys(email);
        return this;
    }

    private LoginPage enterEntrancePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    private void confirmLoginButton() {
        enterButton.click();
    }

    public LoginPage login(String password, String email) {
        routeToPopUp().openEntranceForm().enterEntranceEmail(email).enterEntrancePassword(password).confirmLoginButton();
        return this;
    }

    private LoginPage typeName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    private LoginPage typePhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    private LoginPage typePassword(String email) {
        registerPasswordField.sendKeys(email);
        return this;
    }

    public void confirmRegister() {
        submitRegisterButton.click();
    }

    public LoginPage routeToPopUp() {
        openSite();
        openPopUpForLogin();
        return this;
    }

    public void registerAccount(String name, String phone, String password) {
        routeToPopUp();
        waitVisibility(registerForm);
        typeName(name).typePhone(phone).typePassword(password).confirmRegister();
    }

    public String getHiddenErrorLabel() {
        return hiddenEntranceEmail.getText();
    }

    public String getValidationRegisterErrorMessage() {
        waitVisibility(validationRegisterError);
        return validationRegisterError.getText();
    }

    public String getErrorMessageDuringRegistrationExistingUser() {
        waitVisibility(errorMessageWhileRegistrationExistingUser);
        return errorMessageWhileRegistrationExistingUser.getText();
    }
}
