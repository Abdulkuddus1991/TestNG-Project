package TestRunner;

import Pages.LoginPage;
import Setup.BasePage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class LoginTestRunner extends BasePage {
    @Test(priority = 1, description = "Login with credential")
    @Description("Positive test")
    public void LoginWithValidData() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin("Admin", "admin123");
        Thread.sleep(2000);
        loginPage.takeScreenshot("LoginWithValidData");

        Assert.assertFalse(loginPage.getProfileName().isEmpty(), " Login failed");
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("dashboard"), " Not on dashboard");

        System.out.println(" Valid login test passed");
    }

    @Test(priority = 2, description = "Wrong password")
    @Description("Negative test")
    public void wrongPassword() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin("Admin", "admin124");
        loginPage.takeScreenshot("wrongPassword");
        // assertion:
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Invalid credentials"), " Wrong error message");
        System.out.println(" Invalid login test passed");
    }

    @Test(priority = 3, description = "Empty username")
    public void emptyUsername() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin("", "admin123");
        loginPage.takeScreenshot("emptyUsername");

//loginPage.takeScreenshot();

        Assert.assertTrue(loginPage.getFieldError().contains("Required"), " 'Required' not shown");
        System.out.println(" Empty username test passed");
    }
}