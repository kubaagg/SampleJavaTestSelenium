package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredPage {
    private WebDriver driver;

    public RegisteredPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(), 'Thank you for registering with Fake Online Clothing Store.')]")
    WebElement registeredField;


    public WebElement getRegisteredField() {
        return registeredField;
    }
}
