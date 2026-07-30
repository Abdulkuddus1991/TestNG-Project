package Pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ScarEmployee {
    WebDriver driver;
    public ExtentTest test;
    @FindBy(className ="oxd-text")
    List<WebElement>  ClickDirectoryMenu;


    @FindBy(css ="input[placeholder='Type for hints...']")
    WebElement EmployeeName;

    @FindBy(css ="button.oxd-button--secondary[type='submit']")
    WebElement ClickSearch;

  

   
    public ScarEmployee (WebDriver driver, ExtentTest test){
        this.driver =driver;
        this.test = test;
        PageFactory.initElements(driver,this);
    }
    public ScarEmployee (WebDriver driver) {
        this(driver, null);
    }
      public void InputInfo() throws InterruptedException {
          ClickDirectoryMenu.get(8).click();
          if (test != null) test.info("Clicked Directory menu ");
          Thread.sleep(5000);

          String employeeName = "muhibkhanmolla";
          EmployeeName.sendKeys(employeeName);
          if (test != null) test.info("Entered employee name: " + employeeName);
          Thread.sleep(5000);
      }
}
