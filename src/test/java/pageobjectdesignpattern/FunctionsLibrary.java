package pageobjectdesignpattern;

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
public class FunctionsLibrary {
    ChromeDriver driver;
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void  waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds((6)).getSeconds());
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
