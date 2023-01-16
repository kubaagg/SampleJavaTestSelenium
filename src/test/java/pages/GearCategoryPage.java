package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearCategoryPage {
    private WebDriver driver;

    public GearCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='product-item-link']")
    private WebElement examplesThignsAddToCart;

    private static final Logger logger = LogManager.getLogger();

    public void addToCartExamplesThings() {
        logger.info("Clicking on the product");
        examplesThignsAddToCart.click();
    }
}
