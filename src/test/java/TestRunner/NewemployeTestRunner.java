package TestRunner;

import Pages.LoginPage;
import Pages.LoginwithnewEmploye;
import Setup.BasePage1;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewemployeTestRunner extends BasePage1 {



    @Test
    public void InfoUpdate() throws InterruptedException {
        LoginwithnewEmploye NewLogin=new LoginwithnewEmploye(driver);
        NewLogin.inputMyInfo();
        Thread.sleep(2000);
        Assert.assertTrue(NewLogin.profileFullName.isEmpty(), " Profile name is not visible!");
    }
    }
