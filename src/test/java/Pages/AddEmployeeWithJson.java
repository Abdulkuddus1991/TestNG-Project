package Pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEmployeeWithJson {

    static WebDriver driver;
    public ExtentTest test;
    @FindBy(className ="oxd-text")
    List<WebElement> ClickPIMMenu;

    @FindBy(className ="oxd-button")
    List<WebElement> ClickAdd;

    @FindBy(name ="firstName")
    WebElement Infirstputname;

    @FindBy(name ="middleName")
    WebElement Inputmiddlename;

    @FindBy(name ="lastName")
    WebElement InputLastname;

    @FindBy(className="oxd-switch-input")
    List<WebElement> SwitchButton;

    @FindBy(className ="oxd-input")
    List<WebElement> inputusername;

    @FindBy(className ="oxd-input")
    List<WebElement> inputuserpassword;

    @FindBy(className ="oxd-input")
    List<WebElement> confirompassword;

    @FindBy(className ="oxd-button")
    List<WebElement> ClickSave;

    public AddEmployeeWithJson(WebDriver driver, ExtentTest test){
        AddEmployeeWithJson.driver =driver;
        this.test = test;
        PageFactory.initElements(driver,this);
    }
    public AddEmployeeWithJson(WebDriver driver) {
        this(driver, null);
    }
    public void inputPim(String firstname,String middlename,String lastname,String username,String password,String confirmpassword) throws InterruptedException {
        ClickPIMMenu.get(1).click();
        if (test != null) test.info("Clicked on PIM Menu");
        Thread.sleep(2000);

        ClickAdd.get(2).click();
        if (test != null) test.info("Clicked on Add Employee button");
        Thread.sleep(2000);

        Infirstputname.sendKeys(firstname);
        if (test != null) test.info("Entered First Name: " + firstname);
        Thread.sleep(2000);

        Inputmiddlename.sendKeys(middlename);
        if (test != null) test.info("Entered Middle Name: " + middlename);
        Thread.sleep(2000);

        InputLastname.sendKeys(lastname);
        if (test != null) test.info("Entered Last Name: " + lastname);
        Thread.sleep(2000);

        SwitchButton.get(0).click();
        if (test != null) test.info( "Enabled Login Details toggle");
        Thread.sleep(2000);

        inputusername.get(5).sendKeys(username);
        if (test != null) test.info("Entered Username: " + username);
        Thread.sleep(2000);

        inputuserpassword.get(6).sendKeys(password);
        if (test != null) test.info("Entered Password");
        Thread.sleep(2000);

        confirompassword.get(7).sendKeys(confirmpassword);
        if (test != null) test.info("Entered Confirm Password");
        Thread.sleep(3000);

        ClickSave.get(1).click();
        if (test != null) test.info("Clicked Save button -  Add Employee  successfully");
        Thread.sleep(5000);


    }
}
