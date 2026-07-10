package TestRunner;

import Pages.LoginPage;
import Setup.BasePage;
import UtilityResource.UtilityFile;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class LoginWithJson extends BasePage {

@Test
    public void LoginWithJsonData() throws IOException, ParseException, InterruptedException {
        LoginPage page = new LoginPage(driver);
        Map<String, Object> user = UtilityFile.getUserInfo();

       // String username = String.valueOf(user.getOrDefault("UserName", "hortencia.okon")).trim();
        //String password = String.valueOf(user.getOrDefault("Password", "384175A@a")).trim();
          String username=user.get("UserName").toString();
          String password =user.get("Password").toString();

        if (username.isBlank() || password.isBlank()) throw new RuntimeException("Missing credentials");

        page.inputLogin(username, password);
    }
}



