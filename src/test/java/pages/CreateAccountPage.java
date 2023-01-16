package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPassword;

    @FindBy(xpath = "//span[contains(text(), 'Create an Account')]")
    private WebElement createAccountButton;

    private static final Logger logger = LogManager.getLogger();

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    @FindBy(id = "email_address-error")
    private WebElement emailErrorMessage;


    public void createAccount(String name, String secondName, String email, String password) {
        logger.info("Create new account");
        firstName.sendKeys(name);
        lastName.sendKeys(secondName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPassword.sendKeys(password);
        createAccountButton.click();
        logger.info("Account created");
    }


}
