package pageobjectdesignpattern;

import net.datafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author : ismetsasaq
 * @created : 09/11/2024,22:31
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class  FunctionsLibrary {
  ChromeDriver driver;
  Faker faker=null;

    public FunctionsLibrary(ChromeDriver driver) {
        this.driver = driver;
        faker=new Faker();
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void  waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(element));

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
