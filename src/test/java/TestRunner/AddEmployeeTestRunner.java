package TestRunner;

import Pages.LoginPage;
import Pages.AddEmployeeWithJson;
import Setup.BasePage1;
import UtilityResource.UtilityFile;
import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class AddEmployeeTestRunner extends BasePage1 {
    public ExtentTest test;
    @Test(priority = 1)
    public void LoginWithValidData() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver,test);
        loginPage.inputLogin("Admin", "admin123");
        Thread.sleep(2000);
        test = extent.createTest("Login with valid credential");
        UtilityPage.getScreenShot(driver, "Login with valid credential", test);
    }
    @Test(priority = 2)
    public void EnterPimInfo() throws InterruptedException, IOException, ParseException {
        AddEmployeeWithJson pimPage =new AddEmployeeWithJson(driver,test);
        Faker faker =new Faker();
        String firstname=faker.name().firstName();
        String middlename=faker.name().nameWithMiddle();
        String lastname=faker.name().lastName();
        String username= faker.name().username();
        Random random =new Random();
        int number=random.nextInt(999999)+111111;
        String prefix="A@a";
        String randomPassword=number+prefix;
        pimPage.inputPim(firstname,middlename,lastname,username, randomPassword, randomPassword);

        UtilityFile.saveEmployeeInfo( firstname,lastname,username, randomPassword);
        Thread.sleep(2000);
        test = extent.createTest("Create Employee ");
        UtilityPage.getScreenShot(driver, "Create Employee", test);
    }
}
