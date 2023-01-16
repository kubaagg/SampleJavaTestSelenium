package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoggedUserPage;
import pages.SignInPage;
import utils.BasicTest;

public class SignInTest extends BasicTest {


    @Test
    public void signInTest() {
        ExtentTest test = extentReports.createTest("Login Test");
        HomePage homePage = new HomePage(driver);
        homePage.openSign();
        test.log(Status.PASS, "Open login page");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openLogin("Testowy123456@info.pl", "Testowy123");
        test.log(Status.PASS, "Completing login fields");
        WebElement loggedUserMessage = signInPage.getLoggedUser();

        Assert.assertTrue(loggedUserMessage.isDisplayed());

    }

    @Test
    public void logoutTest() {
        ExtentTest test = extentReports.createTest("Logout Test");
        HomePage homePage = new HomePage(driver);
        homePage.openSign();
        test.log(Status.PASS, "Open login page");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openLogin("Testowy123456@info.pl", "Testowy123");
        test.log(Status.PASS, "Completing login fields");
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        loggedUserPage.openMenuButton();
        test.log(Status.PASS, "Open menu button");
        loggedUserPage.signOut();
        test.log(Status.PASS, "Clicking logout");

        Assert.assertTrue(homePage.getLoggedOutField().isEnabled());
    }
}
