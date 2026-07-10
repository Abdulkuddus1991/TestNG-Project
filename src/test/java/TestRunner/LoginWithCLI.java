package TestRunner;

import Pages.LoginPage;
import Setup.BasePage1;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithCLI extends BasePage1 {
   @Test
    public void DoLoginWithCLI() throws IOException, InterruptedException {
       String username = System.getProperty("username");
       String password = System.getProperty("password");
       String suiteName = System.getProperty("suitename");
        LoginPage loginPage =new LoginPage(driver);
        loginPage.inputLogin(username,password);
    }
}
