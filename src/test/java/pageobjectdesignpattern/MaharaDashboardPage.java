package pageobjectdesignpattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 22/02/2026,14:02
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class MaharaDashboardPage {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
    @FindBy(xpath = "//span[@class=\"icon icon-chevron-down collapsed\"]")
    WebElement dropLink;
    @FindBy(id = "logoutbutton")
    WebElement logOutLink;
    @FindBy(id = "progress_item_educationhistory")
    WebElement educationHistory;
    public MaharaDashboardPage(ChromeDriver driver) {
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

