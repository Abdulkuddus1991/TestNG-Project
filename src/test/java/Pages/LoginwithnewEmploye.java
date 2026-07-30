package Pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginwithnewEmploye {
    public static WebDriver driver;
    public ExtentTest test;


    @FindBy(name ="username")
    WebElement inputUsername;

    @FindBy(name ="password")
    WebElement inputPassword;

    @FindBy(className ="oxd-button")
    List<WebElement> SubmitButton;

    @FindBy(className = "oxd-userdropdown-name")
    public List<WebElement> profileFullName;


    @FindBy(xpath = "//span[text()='My Info']")
    WebElement menuMyInfo;

    @FindBy(className = "oxd-radio-wrapper")
    List<WebElement> maleRadio;

    @FindBy(className = "oxd-button--secondary")
    List<WebElement> clickSave;

   @FindBy(className = "oxd-select-text-input")
    List<WebElement> BloodSelection;

   @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[normalize-space(text())='B+']")
 WebElement Bpositive;

    @FindBy(className = "oxd-button--secondary")
    List<WebElement> Save;


    public LoginwithnewEmploye (WebDriver driver, ExtentTest test){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public LoginwithnewEmploye (WebDriver driver) {
        this(driver, null);
    }

    public void inputMyInfo() throws InterruptedException {
        // --- Username ---
        String username = "muhibkhan";
        inputUsername.sendKeys(username);
        Thread.sleep(2000);
        if (test != null) test.info("Entered username: " + username);

        // --- Password ---
        String password = "1234567a";
        inputPassword.sendKeys(password);
        Thread.sleep(2000);
        if (test != null) test.info("Entered password: " + password);

        // --- Submit Login ---
        SubmitButton.get(0).click();
        Thread.sleep(5000);
        if (test != null) test.info("Clicked on Submit/Login button");

        // --- Navigate to My Info ---
        menuMyInfo.click();
        Thread.sleep(5000);
        if (test != null) test.info("Navigated to My Info section");

        // --- Select Gender ---
        maleRadio.get(0).click();
        Thread.sleep(3000);
        if (test != null) test.info("Selected gender: Male");

        // --- Save Personal Info ---
        clickSave.get(0).click();
        Thread.sleep(5000);
        if (test != null) test.info("Clicked Save button for personal details");

        // --- Scroll Down ---
        JavascriptExecutor jk = (JavascriptExecutor) driver;
        jk.executeScript("window.scrollBy(0,400)");
        Thread.sleep(5000);
        if (test != null) test.info("Scrolled page down by 400 pixels");

        // --- Blood Group Selection ---
        String bloodGroup = "B+";
        BloodSelection.get(2).click();
        if (test != null) test.info("Opened blood group dropdown");

        BloodSelection.get(2).sendKeys(bloodGroup);
        Thread.sleep(5000);
        if (test != null) test.info("Typed blood group: " + bloodGroup);

        Bpositive.click();
        Thread.sleep(5000);
        if (test != null) test.info("Selected blood group option: B+");

     //   BloodSelection.get(2).sendKeys(Keys.ENTER);
       // Thread.sleep(5000);
        //if (test != null) test.info("Confirmed blood group selection with Enter key");

        // --- Save Blood Group ---
        Save.get(1).click();
        Thread.sleep(5000);
        if (test != null) test.info("Clicked Save button for blood group");
    }

}



