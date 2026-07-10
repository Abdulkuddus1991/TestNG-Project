package TestRunner;

import Pages.CreateEmployee;
import Pages.LoginPage;
import Setup.BasePage1;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmployeeTestRunner extends BasePage1 {
    @Test(priority = 1)
    public void LoginWithValidData() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin("Admin", "admin123");
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public  void InputInfo() throws InterruptedException {
        CreateEmployee employee = new CreateEmployee(driver);
        employee.inputData("muhib","khan","molla","muhibkhan","1234567a","1234567a");
        Thread.sleep(2000);
    }

}