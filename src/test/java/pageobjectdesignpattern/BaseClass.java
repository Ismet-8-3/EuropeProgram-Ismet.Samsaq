package pageobjectdesignpattern;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author : ismetsasaq
 * @created : 10/11/2024,11:09
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class BaseClass {
    ChromeDriver driver;
    public void openBrowser(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mahara.org/?login");
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
