package TestRunner;

import Pages.LoginPage;
import Pages.ScarEmployee;
import Setup.BasePage1;
import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmplySearchTestrunner extends BasePage1 {
    public ExtentTest test;
    @Test(priority = 1,description = "Login with valid credential")
    public void LoginWithValidData() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin("Admin", "admin123");
        Thread.sleep(2000);
        test = extent.createTest("Login with valid credential");
        UtilityPage.getScreenShot(driver, "Login with valid credential", test);
    }
    @Test(priority = 2,description = "Search Employee")
    public void SearchEm() throws InterruptedException, IOException {
        ScarEmployee employee =new ScarEmployee(driver);
        employee.InputInfo();
        Thread.sleep(5000);
        test = extent.createTest("Search Employee");
        UtilityPage.getScreenShot(driver, "Search Employee with Username"
                , test);
    }

}