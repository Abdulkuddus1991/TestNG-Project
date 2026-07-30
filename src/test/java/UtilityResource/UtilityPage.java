package UtilityResource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class UtilityPage {
    public static ExtentReports extent;
    private static WebDriver driver;
    private static final String BASE_PATH = System.getProperty("user.dir") + "/report/"; // Match your report folder

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(BASE_PATH + "ExtentReport.html");
            spark.config().setReportName("Login Test Results");
            extent.attachReporter(spark);
        }
        return extent;
    }

    // Take screenshot & attach to report
    public static void getScreenShot(WebDriver driver, String message, ExtentTest test) throws IOException {
        //  Short wait before capture — ensure page loads fully
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // Screenshot folder INSIDE report folder
        String screenshotDir = BASE_PATH + "screenshots/";
        new File(screenshotDir).mkdirs();

        String fileName = "screenshot_" + generateRandomNumber() + ".png";
        String fullPath = screenshotDir + fileName;

        FileUtils.copyFile(srcFile, new File(fullPath));

        // ✅ Critical fix: Relative path matches report location
        if (test != null) {
            test.info(message, MediaEntityBuilder.createScreenCaptureFromPath("screenshots/" + fileName).build());
        }
    }

    // Simple screenshot without report logging
    public static void getScreenShot(WebDriver driver) throws IOException, InterruptedException {
        getScreenShot(driver, "Screenshot taken", null);
    }

    // Generate unique random number
    public static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(99999) + 1;
    }



}
