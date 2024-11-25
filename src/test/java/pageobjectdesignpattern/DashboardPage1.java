package pageobjectdesignpattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 09/11/2024,22:44
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DashboardPage1 {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
@FindBy(className = "user-toggle")
WebElement dropLink;
@FindBy(id = "nav-title")
WebElement logOutLink;
    public DashboardPage1(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionsLibrary=new FunctionsLibrary(driver);
    }
    public void dropLink(){
        functionsLibrary.waitForElementPresent(dropLink);
        dropLink.click();


    }
    ////public void dropLink(){
      //  functionsLibrary.waitForElementPresent(dropLink();dropLink.);
   // }
    public void logOut(){
        functionsLibrary.waitForElementPresent(logOutLink);
        logOutLink.click();
    }
}
