package advanceactionsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjectdesignpattern.FunctionsLibrary;

/**
 * @author : ismetsasaq
 * @created : 08/12/2024,11:45
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class AdvanceActionsDemo {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        functionsLibrary=new FunctionsLibrary(driver);
        }
        @Test
    public void moveToElement(){
        driver.get("https://jqueryui.com/");
            WebElement contributeLink=driver.findElement(By.xpath(
                    "//section[@id=\"global-nav\"]//div//ul[@class=\"links\"]//*[contains(text(),\"Contribute\")]"));
            Actions actions=new Actions(driver);
            actions.moveToElement(contributeLink).build().perform();
            WebElement CLALink=driver.findElement(By.xpath("//a[contains(text(),\"CLA\")]"));
            functionsLibrary.waitForElementPresent(CLALink);
            actions.click(CLALink).build().perform();
            WebElement becameMemberButton=driver.findElement(By.linkText("Become a member"));
            functionsLibrary.waitForElementPresent(becameMemberButton);
            boolean isCLAClicked=becameMemberButton.isDisplayed();
            Assert.assertTrue(isCLAClicked);
        }
        @Test
        public void dragAndDropTest(){
        driver.get("https://jqueryui.com/droppable/");
        //WebElement iframe=driver.findElement(By.tagName("iframe"));
       // driver.switchTo().frame(iframe);
            driver.switchTo().frame(0);
            WebElement draggableElement=driver.findElement(By.id("draggable"));
            WebElement droppableElement=driver.findElement(By.id("droppable"));
            Actions actions=new Actions(driver);
          // actions.clickAndHold(draggableElement).moveToElement(droppableElement).build().perform();
            actions.dragAndDrop(draggableElement,droppableElement).build().perform();
            //actions.clickAndHold(draggableElement).moveByOffset(50,0).moveByOffset(30,0)
                    //.release().build().perform();
            Assert.assertTrue(droppableElement.getText().contains("Dropped"));
            driver.switchTo().defaultContent();
            driver.findElement(By.linkText("Selectable")).click();

        }
        @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
        }

    }

