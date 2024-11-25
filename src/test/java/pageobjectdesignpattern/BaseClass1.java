package pageobjectdesignpattern;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author : ismetsasaq
 * @created : 10/11/2024,11:09
 * @Email : noah.yisimaiti@Gmail.com
 **/
public  class BaseClass1 {

   public ChromeDriver driver;
    public void openBrowser(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.mahara.org/");
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
