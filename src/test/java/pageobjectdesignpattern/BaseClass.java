package pageobjectdesignpattern;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author : ismetsasaq
 * @created : 10/11/2024,11:09
 * @Email : noah.yisimaiti@Gmail.com
 **/
public  class BaseClass {

   public ChromeDriver driver;
        public void openBrowser(){
            driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");
        }
        public void closeBrowser(){
            driver.close();
        driver.quit();
    }
}
