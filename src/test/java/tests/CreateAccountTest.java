package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.RegisteredPage;
import utils.BasicTest;

public class CreateAccountTest extends BasicTest {

    int randomNumber = (int) (Math.random() * 1000);

    @Test
    public void createAccountTest() {
        ExtentTest test = extentReports.createTest("Create new account test");
        HomePage homePage = new HomePage(driver);
        homePage.openCreateAccount();
        test.log(Status.PASS, "Open create account page");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.createAccount("Testowy" + randomNumber, "Second" + randomNumber,
                randomNumber + "testowy@info.pl", "Testowy12345");
        test.log(Status.PASS, "Completing register fields");
        RegisteredPage registeredPage = new RegisteredPage(driver);
        WebElement registeredMessage = registeredPage.getRegisteredField();

        Assert.assertEquals(registeredMessage.getText(), "Thank you for registering with Fake Online Clothing Store.");
        test.log(Status.PASS, "Registration assertion check");
    }
    @Test
    public void incorrectDataCreateAccountTest() {
        ExtentTest test = extentReports.createTest("Entering invalid fields");
        HomePage homePage = new HomePage(driver);
        homePage.openCreateAccount();
        test.log(Status.PASS, "Open create account page");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.createAccount("Testowy", "Testowy", "tesowy.pl", "123");
        test.log(Status.PASS, "Completing register invalid fields");
        WebElement error = createAccountPage.getEmailErrorMessage();

        Assert.assertTrue(error.isDisplayed());
        test.log(Status.PASS, "Checking the assertion in the wrong field");
    }

}
