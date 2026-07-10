package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginwithnewEmploye {


    WebDriver driver;
    @FindBy(name ="username")
    WebElement inputUsername;

    @FindBy(name ="password")
    WebElement inputPassword;

    @FindBy(className ="oxd-button")
    List<WebElement> SubmitButton;

    @FindBy(className = "oxd-userdropdown-name")
    public List<WebElement> profileFullName;

   // @FindBy(className = "oxd-userdropdown-name")
  //  WebElement profileName;

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


    public LoginwithnewEmploye (WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void inputMyInfo() throws InterruptedException {
        inputUsername.sendKeys("muhibkhan");
        Thread.sleep(2000);
        inputPassword.sendKeys("1234567a");
        Thread.sleep(2000);
        SubmitButton.get(0).click();
        Thread.sleep(5000);
        menuMyInfo.click();
        Thread.sleep(5000);
        maleRadio.get(0).click();
        Thread.sleep(5000);
        clickSave.get(0).click();
        Thread.sleep(5000);
        JavascriptExecutor jk = (JavascriptExecutor) driver;
        jk.executeScript("window.scrollBy(0,400)");
        Thread.sleep(3000);

    BloodSelection.get(2).click();
    Thread.sleep(2000);
    BloodSelection.get(2).sendKeys("B+");
    Thread.sleep(3000);
    Bpositive.click();
    BloodSelection.get(2).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    Save.get(1).click();
    Thread.sleep(2000);

}

    }

