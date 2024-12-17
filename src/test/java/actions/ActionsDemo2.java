package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 17/12/2024,16:22
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ActionsDemo2 {
    WebDriver driver=new ChromeDriver();
    @Test
    public void copyAndPaste(){
        driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");
        WebElement textField=driver.findElement(By.id("textInput"));

       /* Keys cmdCtrl;
        if (Platform.getCurrent().is(Platform.MAC))
            cmdCtrl=Keys.COMMAND;
        else
            cmdCtrl=Keys.CONTROL;*/
        //Ternary Operator
        Keys cmdCtrl=Platform.getCurrent().is(Platform.MAC)?Keys.COMMAND:Keys.CONTROL;
        new Actions(driver)
                .sendKeys(textField,"Attila")
                .keyDown(cmdCtrl)
                .sendKeys("axvvv")
                .keyUp(cmdCtrl)
                .build().perform();
       // Assert.assertEquals(textField.getAttribute("velue"),"AttilaAttilaAttila");
    }
}
