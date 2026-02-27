package nopc;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author : ismetsasaq
 * @created : 25/02/2026,20:38
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class BaseClass {
    public ChromeDriver chromeDriver =new ChromeDriver();
    public void openBrowser(){

        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");
    }
    public void closeBrowser(){
        chromeDriver.close();
        chromeDriver.quit();
    }
}
