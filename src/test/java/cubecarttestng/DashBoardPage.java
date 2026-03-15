package cubecarttestng;

import net.datafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 05/03/2026,16:46
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DashBoardPage {
    FunctionsPage functionsPage;
    FirefoxDriver firefoxDriver;

    @FindBy(xpath = "//*[contains(text(),\"Log Out \")]")
    WebElement logOutLink;
    public DashBoardPage(FirefoxDriver firefoxDriver) {
        this.firefoxDriver =firefoxDriver ;
        PageFactory.initElements(firefoxDriver,this);
        functionsPage=new FunctionsPage(firefoxDriver);

    }



    public void logout(){
        functionsPage.waitForElementPresent(logOutLink);
        logOutLink.click();


    }

}
