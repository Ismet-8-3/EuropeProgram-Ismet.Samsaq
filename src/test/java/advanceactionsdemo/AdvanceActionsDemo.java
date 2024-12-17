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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        @Test
        public void menuTest(){
        driver.get("https://jqueryui.com/menu/");
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        Actions actions=new Actions(driver);
        WebElement musicElement=driver.findElement(By.id("ui-id-9"));
        functionsLibrary.waitForElementPresent(musicElement);
        actions.moveToElement(musicElement).build().perform();
        WebElement jazzMenu=driver.findElement(By.id("ui-id-13"));
        functionsLibrary.waitForElementPresent(jazzMenu);
        actions.moveToElement(jazzMenu).build().perform();
        WebElement bigBand=driver.findElement(By.id("ui-id-15"));
        functionsLibrary.waitForElementPresent(bigBand);
        Assert.assertTrue(bigBand.isDisplayed());
        }
        /*@Test
        public void multipleWindowTest(){
        driver.get("www.google.com");
        WebElement newWindowButton=driver.findElement(By.id("windowbutton"));
        functionsLibrary.waitForElementPresent(newWindowButton);
        String currentWindowName=driver.getWindowHandle();
            System.out.println("Current window name"+currentWindowName);
            newWindowButton.click();
            Set<String> allWindows=driver.getWindowHandles();
            for (String eachWindow:allWindows){
                System.out.println("each window name:"+eachWindow);
                if (!eachWindow.equalsIgnoreCase(currentWindowName)){
                    driver.switchTo().window(eachWindow);
                    WebElement goBackButton=driver.findElement(By.id("dsdssd"));
                    Assert.assertTrue(goBackButton.isDisplayed());
                }
            }

        }*/
    @Test
    public void testHyperLink(){
        driver.get("https://jqueryui.com/");
        List<WebElement> links= driver.findElements(By.xpath("//*[@id=\"sidebar\"]//a"));
        int totalLinkCounts= links.size();
        System.out.println("Total Links"+totalLinkCounts);
        List<String> urls=new ArrayList<>();
        for (WebElement l:links){
            urls.add(l.getAttribute("href"));
        }
        int count=0;

        for (String eachUrl:urls){
            driver.navigate().to(eachUrl);
            count++;
         
        }
        Assert.assertEquals(totalLinkCounts,count);
    }
        @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
        }

    }

