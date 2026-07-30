package Pages;

import UtilityResource.UtilityPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LoginPage {
    public static WebDriver driver;
    public ExtentTest test;
    @FindBy(name = "username")
    WebElement inputUsername;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(className = "oxd-button")
    List<WebElement> SubmitButton;

    @FindBy(className = "oxd-userdropdown-name")
    public WebElement profileName;

    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message')]")
    public WebElement fieldErrorMessage;

    // --- Constructor (Fixed & Clean) ---
    public LoginPage(WebDriver driver, ExtentTest test) {
        LoginPage.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this); // ✅ Critical: Loads all @FindBy elements
    }

    public LoginPage(WebDriver driver) {
        this(driver, null);
    }

    public void inputLogin(String username, String password) throws InterruptedException, IOException {

        inputUsername.clear();
        inputUsername.sendKeys(username);
        if (test != null) test.info("Entered username: " + username);
        Thread.sleep(1000);

        inputPassword.clear();
        inputPassword.sendKeys(password);
        if (test != null) test.info("Entered password");
        Thread.sleep(1000);

        // Simple direct submit — NO if/else
        SubmitButton.get(0).click();
        if (test != null) test.info("Clicked Login button");
        UtilityPage.getScreenShot(driver, "After clicking Submit button", test);
        Thread.sleep(3000);

    }

    public String getText(WebElement element) {
        String value = element.getText().trim();
        if (test != null) test.info("Fetched value: " + value);
        return value;

    }

}







