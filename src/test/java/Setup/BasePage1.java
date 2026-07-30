package Setup;

import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BasePage1 {
    public static WebDriver driver;
    public static ExtentReports extent;

    @BeforeTest
    public void setup() {
        extent = UtilityPage.getInstance();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterTest
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
        // Generate final report
        if (extent != null) {
            extent.flush();
        }

    }
}


