package cubecarttestng;

import nopc.FuctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 05/03/2026,16:46
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class LogInPage {  FirefoxDriver firefoxDriver;
    FunctionsPage functionsPage;
   @FindBy(id = "username")
   WebElement userName;
    @FindBy(id = "password")

    WebElement passWord;
    @FindBy(id = "login"
    )
   WebElement loginButton;

    public LogInPage(FirefoxDriver firefoxDriver) {
        this.firefoxDriver =firefoxDriver ;
        PageFactory.initElements(firefoxDriver,this);
        functionsPage=new FunctionsPage(firefoxDriver);
    }

    public void login(String user,String pass) {
        functionsPage.waitForElementPresent(userName);
        userName.sendKeys(user);
        functionsPage.waitForElementPresent(passWord);
        passWord.sendKeys(pass);

        functionsPage.waitForElementPresent(loginButton);
        loginButton.click();

    }

}
