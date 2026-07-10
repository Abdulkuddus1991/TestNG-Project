package UtilityResource;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ScreenShortUtil {
         WebDriver driver;

        // Static method to capture screenshot
        public static void capture(WebDriver driver, String testName, String status) {
            try {
                // Take screenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                File srcFile = ts.getScreenshotAs(OutputType.FILE);

                // Ensure Downloads folder exists
                String folderPath = "C:\\Users\\User\\Downloads\\";
                new File(folderPath).mkdirs();

                // Generate unique filename
                Random rand = new Random();
                int autoNumber = rand.nextInt(1000);
                String filePath = folderPath + testName + "_" + autoNumber + ".png";

                // Save file
                File destFile = new File(filePath);
                FileUtils.copyFile(srcFile, destFile);
                System.out.println("Screenshot saved: " + destFile.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace(); // Show error if saving fails
            }


        }
    }










