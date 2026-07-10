package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ScarEmployee {
    WebDriver driver;
    @FindBy(className ="oxd-text")
    List<WebElement>  ClickDirectoryMenu;


    @FindBy(css ="input[placeholder='Type for hints...']")
    WebElement EmployeeName;

    @FindBy(css ="button.oxd-button--secondary[type='submit']")
    WebElement ClickSearch;

  

   
    public ScarEmployee (WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
      public void InputInfo() throws InterruptedException {
          ClickDirectoryMenu.get(8).click();
          Thread.sleep(5000);
        EmployeeName.sendKeys("muhibkhanmolla");
        Thread.sleep(5000);

      }
}
