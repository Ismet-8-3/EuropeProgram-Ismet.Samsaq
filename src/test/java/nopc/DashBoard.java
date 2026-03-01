package nopc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjectdesignpattern.FunctionsLibrary;

/**
 * @author : ismetsasaq
 * @created : 25/02/2026,21:35
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DashBoard {
    ChromeDriver chromeDriver;

    FuctionLibrary fuctionLibrary;
    @FindBy(xpath ="//a[@href=\"/logout\"]")
    WebElement logOut;

    public DashBoard(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver,this);
        fuctionLibrary=new FuctionLibrary(chromeDriver);
    }



    ////public void dropLink(){
    //  functionsLibrary.waitForElementPresent(dropLink();dropLink.);
    // }
     public void logOut(){
       fuctionLibrary.waitForElementPresent(logOut);
        logOut.click();
   }

}
