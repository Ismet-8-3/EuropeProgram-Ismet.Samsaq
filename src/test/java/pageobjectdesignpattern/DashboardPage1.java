package pageobjectdesignpattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author : ismetsasaq
 * @created : 09/11/2024,22:44
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DashboardPage1 {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
@FindBy(xpath = "//span[@class=\"icon icon-chevron-down collapsed\"]")
WebElement dropLink;
@FindBy(id = "logoutbutton")
WebElement logOutLink;
@FindBy(id = "progress_item_educationhistory")
WebElement educationHistory;
    public DashboardPage1(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionsLibrary=new FunctionsLibrary(driver);
    }


    public void dropLink(){
        functionsLibrary.waitForElementPresent(dropLink);
        dropLink.click();
    }
    public void educationHistory(){
        functionsLibrary.waitForElementPresent(educationHistory);
        educationHistory.click();
   }
    public void logOut(){
        functionsLibrary.waitForElementPresent(logOutLink);
        logOutLink.click();
    }
}
