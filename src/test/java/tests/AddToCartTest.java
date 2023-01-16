package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExamplesProductPage;
import pages.GearCategoryPage;
import pages.LoggedUserPage;
import utils.BasicTest;

public class AddToCartTest extends BasicTest {

    @Test
    public void addToCartTest() {
        ExtentTest test = extentReports.createTest("Add to cart test");
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        loggedUserPage.openGearCategory();
        test.log(Status.PASS, "Open Gear Category");
        GearCategoryPage gearCategoryPage = new GearCategoryPage(driver);
        gearCategoryPage.addToCartExamplesThings();
        test.log(Status.PASS, "Open examples product");
        ExamplesProductPage examplesProductPage = new ExamplesProductPage(driver);
        examplesProductPage.addToCart();
        test.log(Status.PASS, "Adding examples product to cart");
        String addedMassage = examplesProductPage.getAddedToCart().getText();

        Assert.assertEquals(addedMassage, "You added Fusion Backpack to your shopping cart.");


    }
}
