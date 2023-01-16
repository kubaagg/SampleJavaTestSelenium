package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Gear')]")
    private WebElement gearCategory;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement menuButton;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    private WebElement signOutButton;

    private static final Logger logger = LogManager.getLogger();

    public void openGearCategory() {
        logger.info("Open Gear category");
        gearCategory.click();
    }

    public void openMenuButton() {
        logger.info("Open menu button");
        menuButton.click();
    }

    public void signOut() {
        logger.info("Clicking logout");
        signOutButton.click();
    }
}
