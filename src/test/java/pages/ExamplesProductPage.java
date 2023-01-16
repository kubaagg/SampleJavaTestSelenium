package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class ExamplesProductPage {
    private WebDriver driver;

    public ExamplesProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement productAddToCart;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement addedToCart;

    private static final Logger logger = LogManager.getLogger();

    public WebElement getAddedToCart() {
        WaitHelper.waitForElementToBeVisible(driver, addedToCart);
        return addedToCart;
    }

    public void addToCart() {
        logger.info("Adding to cart");
        WaitHelper.waitForElementToBeVisible(driver, productAddToCart);
        productAddToCart.click();
        logger.info("Added to cart");
    }
}
