package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateNewUser {

    WebDriver driver;
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

    public CreateNewUser(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public void inputPim(String firstname,String middlename,String lastname,String username,String password,String confirmpassword) throws InterruptedException {
        ClickPIMMenu.get(1).click();
        Thread.sleep(2000);
        ClickAdd.get(2).click();
        Thread.sleep(2000);
        Infirstputname.sendKeys(firstname);
        Thread.sleep(2000);
        Inputmiddlename.sendKeys(middlename);
        Thread.sleep(2000);
        InputLastname.sendKeys(lastname);
        Thread.sleep(2000);
        SwitchButton.get(0).click();
        Thread.sleep(2000);
        inputusername.get(5).sendKeys(username);
        Thread.sleep(2000);
        inputuserpassword.get(6).sendKeys(password);
        Thread.sleep(2000);
        confirompassword.get(7).sendKeys(confirmpassword);
        Thread.sleep(5000);
        ClickSave.get(1).click();
        Thread.sleep(3000);


    }
}
