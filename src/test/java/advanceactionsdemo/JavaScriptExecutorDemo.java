package advanceactionsdemo;

import nopc.FuctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 17/03/2026,11:21
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class JavaScriptExecutorDemo {
    ChromeDriver driver;
    FuctionLibrary fuctionLibrary;
    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        fuctionLibrary=new FuctionLibrary(driver);
    }
    @Test
    public void scrollToElement(){
        driver.get("https://jqueryui.com/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement addClassButton=driver.findElement(By.linkText("Add Class"));
        fuctionLibrary.waitForElementPresent(addClassButton);
        js.executeScript("arguments[0].scrollIntoView(true);",addClassButton);
//        js.executeScript("scrollBy(0,400)");
//        js.executeScript("scrollBy(0,500)");
//        js.executeScript("scrollBy(0,-300)");
        Assert.assertTrue(addClassButton.isDisplayed());
        addClassButton.click();
        WebElement addClass=driver.findElement(By.xpath
                ("//h1[@class='entry-title']"));
        fuctionLibrary.waitForElementPresent(addClass);
        Assert.assertTrue(addClass.isDisplayed());
    }
    @Test
    public void jsClickTest(){
        driver.get("https://jqueryui.com/dialog/#animated");
        driver.switchTo().frame(0);
        WebElement openDialogButton=driver.findElement(By.id("opener"));
        fuctionLibrary.waitForElementPresent(openDialogButton);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",openDialogButton);
        WebElement basicDialog=driver.findElement(By.xpath
                ("//span[text()='Basic dialog']"));
        Assert.assertTrue(basicDialog.isDisplayed());
    }
    @Test
    public void sendKeysWithJS(){
        driver.get("https://demo.cubecart.com/cc6/admin_5xArPd.php");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.getElementById('username').value='cubecart'");
        WebElement userNameField=driver.findElement(By.id("username"));
        String fieldValue=userNameField.getAttribute("value");
        System.out.println("Field Value Is;"+fieldValue);
        Assert.assertEquals(fieldValue,"cubecart");

    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}

