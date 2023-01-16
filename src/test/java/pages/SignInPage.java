package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    private WebElement signInButton;

    @FindBy(xpath = "//li[@class='greet welcome']//span")
    private WebElement loggedUser;

    public WebElement getLoggedUser() {
        return loggedUser;
    }
    private static final Logger logger = LogManager.getLogger();

    public void openLogin(String email, String password) {
        logger.info("Login to the website");
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();

    }

}
