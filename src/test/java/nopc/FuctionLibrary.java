package nopc;

import net.datafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author : ismetsasaq
 * @created : 25/02/2026,20:55
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class FuctionLibrary {
    ChromeDriver chromeDriver;
    Faker faker=null;

    public FuctionLibrary(ChromeDriver driver) {
        this.chromeDriver = driver;
        faker=new Faker();
    }








    public void  waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(chromeDriver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(chromeDriver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public String generateFakeName(){
        String firstName=faker.name().firstName();
        return  firstName;

    }
    public String generateFakeEmail(){
        String email=faker.internet().emailAddress();
        return email;
    }
}
