package TestRunner;

import Pages.CreateEmployee;
import Pages.LoginPage;
import Setup.BasePage1;
import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentTest;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateEmployeeTestRunner extends BasePage1 {
    public ExtentTest test;
    @Test(priority = 1,description = "Login with valid credential")
    @Description("Positive test")
    public void LoginWithValidData() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver,test);
        loginPage.inputLogin("Admin", "admin123");
        Thread.sleep(2000);
        test = extent.createTest("Login with valid credential");
        UtilityPage.getScreenShot(driver, "Login with valid credential", test);
    }
    @Test(priority = 2 , description = "Create new Employee")
    @Description("Positive test")
    public  void InputInfo() throws InterruptedException, IOException {
        CreateEmployee employee = new CreateEmployee(driver,test);
        employee.inputData("muhib","khan","molla","muhibkhan","1234567a","1234567a");
        Thread.sleep(2000);
        test = extent.createTest("Create new Employee ");
        UtilityPage.getScreenShot(driver, "Create Employee successfully", test);
    }

}