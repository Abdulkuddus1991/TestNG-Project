package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class LoginPage {
    WebDriver driver;
    @FindBy(name ="username")
    WebElement inputUsername;

    @FindBy(name ="password")
    WebElement inputPassword;

   @FindBy(className ="oxd-button")
    List<WebElement> SubmitButton;

    @FindBy(className = "oxd-userdropdown-name")
   WebElement profileName;

    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
     WebElement errorMessage;

    @FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message')]")
    WebElement fieldErrorMessage;

    public LoginPage(WebDriver driver) throws IOException, InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void takeScreenshot(String testName) throws IOException, InterruptedException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        Random rand = new Random();
        int autoNumber = rand.nextInt(500);

        // ✅ File name = TestName + random number
        String filePath = "C:/Users/User/Downloads/logintest/" + testName + "_" + autoNumber + ".png";
        File destFile = new File(filePath);

        FileUtils.copyFile(srcFile, destFile);
        Thread.sleep(1000);
        System.out.println("📸 Screenshot saved: " + filePath);
    }






    public void inputLogin(String username,String password) throws InterruptedException, IOException {

     //   inputUsername.clear();
        inputUsername.sendKeys(username);
        Thread.sleep(1000);

       // inputPassword.clear();
        inputPassword.sendKeys(password);
        Thread.sleep(1000);

        SubmitButton.get(0).click();
        Thread.sleep(3000);

    }




    // Fixed: returns actual profile name instead of null
   public String getProfileName() {
        return profileName.getText().trim();
    }

    // Fixed: returns actual error message instead of empty string
    public String getErrorMessage() {
        return errorMessage.getText().trim();
    }


    public String getFieldError() {
        return fieldErrorMessage.getText().trim();
    }


}

