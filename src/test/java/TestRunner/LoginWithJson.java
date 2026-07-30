package TestRunner;

import Pages.LoginPage;
import Setup.BasePage;
import UtilityResource.UtilityFile;
import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentTest;
import jdk.jfr.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class LoginWithJson extends BasePage {
    public ExtentTest test;
    @Test(description = "Login with json")
    @Description("Positive test")
    public void LoginWithJsonData() throws IOException, ParseException, InterruptedException {
        LoginPage page = new LoginPage(driver,test);
        Map<String, Object> user = UtilityFile.getUserInfo();

          String username=user.get("UserName").toString();
          String password =user.get("Password").toString();

        if (username.isBlank() || password.isBlank()) throw new RuntimeException("Missing credentials");
        page.inputLogin(username, password);
        Thread.sleep(2000);
        test = extent.createTest("Login with json");
        UtilityPage.getScreenShot(driver, "Login with json successfully", test);

    }
}



