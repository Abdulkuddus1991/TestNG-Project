package TestRunner;

import Pages.LoginPage;
import Pages.ScarEmployee;
import Setup.BasePage1;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmplySearchTestrunner extends BasePage1 {

    @Test(priority = 1)
    public void LoginWithValidData() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin("Admin", "admin123");
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void SearchEm() throws InterruptedException {
        ScarEmployee employee =new ScarEmployee(driver);
        employee.InputInfo();
        Thread.sleep(2000);
    }

}