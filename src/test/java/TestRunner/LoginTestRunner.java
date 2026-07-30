package TestRunner;

import Pages.LoginPage;
import Setup.BasePage;
import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class LoginTestRunner extends BasePage {
    public ExtentTest test;

    @Test(priority = 1, description = "Login with valid credential")
    @Description("Positive test")
    public void LoginWithValidData() throws InterruptedException, IOException {
        // Pass ExtentTest to LoginPage constructor
        LoginPage loginPage = new LoginPage(driver, test);
        loginPage.inputLogin("Admin", "admin123");
        Thread.sleep(1000);
        test = extent.createTest("Login with valid credential");
        UtilityPage.getScreenShot(driver, "Login with valid credential", test);
        Assert.assertFalse(loginPage.getText(loginPage.profileName).isEmpty(), "Login failed: Profile name is empty");
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("dashboard"), "Not redirected to dashboard");

        System.out.println("Valid login test passed");
    }

    @Test(priority = 2, description = "emptyInfo")
    @Description("Negative test")
    public void emptyInfo() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver, test);
        loginPage.inputLogin("", "");
        Thread.sleep(1000);
        test = extent.createTest("Login with emptyInfo");
        UtilityPage.getScreenShot(driver, "Login with emptyInfo", test);
        System.out.println(" emptyInfo test passed");
    }

    @Test(priority = 3, description = "Wrong Username")
    @Description("Negative test")
    public void emptyUsername() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver, test);
        loginPage.inputLogin("Rid", "admin123");
        Thread.sleep(1000);
        test = extent.createTest("Login with invalid Username");
        UtilityPage.getScreenShot(driver, "Login with invalid Username", test);
        System.out.println("Invalid Username test passed");
    }

    @Test(priority = 4, description = "Wrong password")
    @Description("Negative test")
    public void wrongPassword() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver, test);
        loginPage.inputLogin("Admin", "admin124");
        Thread.sleep(1000);
        test = extent.createTest("Login with invalid password");
        UtilityPage.getScreenShot(driver, "Login with invalid password", test);
        String actualError = loginPage.getText(loginPage.errorMessage);
        Assert.assertTrue(actualError.contains("Invalid credentials"), "Wrong error message displayed");
        System.out.println("Invalid login test passed");
    }

   
}