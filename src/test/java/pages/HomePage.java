package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[contains(text(), 'Create an Account')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//li[@class='authorization-link']//a")
    private WebElement signInButton;

    public WebElement getLoggedOutField() {
        return loggedOutField;
    }

    @FindBy(css = "div[class='panel header'] span[class='not-logged-in']")
    private WebElement loggedOutField;

    private static final Logger logger = LogManager.getLogger();


    public void openCreateAccount() {
        logger.info("Open create account page");
        createAccountButton.click();
    }

    public void openSign() {
        logger.info("Open in sign in button");
        signInButton.click();
    }


}
