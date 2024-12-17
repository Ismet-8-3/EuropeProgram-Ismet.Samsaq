package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author : ismetsasaq
 * @created : 17/12/2024,15:43
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ActionsDemo1 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.mahara.org/");
        driver.manage().window().maximize();
        WebElement userNameField=driver.findElement(By.id("login_login_username"));
        WebElement passWordField=driver.findElement(By.id("login_login_password"));
        WebElement logIn=driver.findElement(By.id("login_submit"));
        Actions actions=new Actions(driver);
        actions.sendKeys(userNameField,"admin").sendKeys
                (passWordField,"MaharaDemo").click(logIn).build().perform();


    }

}
