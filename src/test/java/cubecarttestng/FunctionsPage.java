package cubecarttestng;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author : ismetsasaq
 * @created : 05/03/2026,16:47
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class FunctionsPage {
    FirefoxDriver firefoxDriver;
    Faker faker;


    public FunctionsPage( FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
        faker=new Faker();
    }
    public void  waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(firefoxDriver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(firefoxDriver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public String generateFakeFirstName(){
        String firstName=faker.name().firstName();
        return  firstName;

    }
    public String generateFakeLastName(){
        String lastName=faker.name().lastName();
        return lastName;
    }


    public String generateFakeTitle(){
        String title=faker.name().title();
        return  title;

    }
    public String generateFakePhone(){
        String phone=faker.phoneNumber().phoneNumber();
        return  phone;

    }
    public String generateFakeMobile(){
        String mobile=faker.phoneNumber().cellPhone();
        return  mobile;

    }
    public String generateFakeProductName(){
        String Product=faker.commerce().productName();
        return Product;
    }
    public String generateFakeNotes(){
        String notis=faker.azure().appServicePlan();
        return  notis;

    }
    public String generateFakeEmail(){
        String email=faker.internet().emailAddress();
        return email;
    }
    public String generateFakeAmount(){
        String amount=faker.number().digit();
        return  amount;


    }



}
