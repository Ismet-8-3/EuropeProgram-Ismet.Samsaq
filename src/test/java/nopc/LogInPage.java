package nopc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjectdesignpattern.FunctionsLibrary;

/**
 * @author : ismetsasaq
 * @created : 25/02/2026,20:43
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class LogInPage {
    ChromeDriver chromeDriver;
    FuctionLibrary fuctionLibrary;
    @FindBy(xpath ="//button[@type=\"submit\"]"
    )
    WebElement loginButton;

    public void login(String userName,String password) {

        fuctionLibrary.waitForElementPresent(loginButton);
        loginButton.click();
    }
    public LogInPage(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver,this);
        fuctionLibrary=new FuctionLibrary(chromeDriver);
    }
}
