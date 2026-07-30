package Setup;

import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static ExtentReports extent;

    @BeforeSuite
    public void initReport() {
        extent = UtilityPage.getInstance();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Flush report ONCE after all tests finish
    @AfterSuite
    public void saveReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}












