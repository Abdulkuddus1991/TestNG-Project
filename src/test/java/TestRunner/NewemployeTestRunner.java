package TestRunner;

import Pages.LoginPage;
import Pages.LoginwithnewEmploye;
import Setup.BasePage1;
import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewemployeTestRunner extends BasePage1 {
    public ExtentTest test;


    @Test(description = "Update Employee Info")
    @Description("Positive test")
    public void InfoUpdate() throws InterruptedException, IOException {
        LoginwithnewEmploye NewLogin=new LoginwithnewEmploye(driver,test);
        NewLogin.inputMyInfo();
        Thread.sleep(5000);
        test = extent.createTest("Login with valid credential");
        UtilityPage.getScreenShot(driver, "Update Employee Info", test);
    }
    }
