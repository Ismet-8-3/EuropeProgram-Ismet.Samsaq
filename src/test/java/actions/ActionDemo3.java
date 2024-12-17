package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 17/12/2024,17:08
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ActionDemo3 {
    WebDriver driver=new ChromeDriver();

    @Test
    public void rightClick(){
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        WebElement clickableInput=driver.findElement(By.id("clickable"));
        new Actions(driver).contextClick(clickableInput).build().perform();
        WebElement status=driver.findElement(By.id("click-status"));
        Assert.assertEquals(status.getText(),"context-clicked","not succesfuly");
    }

}
