package cubecarttestng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author : ismetsasaq
 * @created : 05/03/2026,16:45
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class BaseClass {
    public FirefoxDriver firefoxDriver =new FirefoxDriver();
    public void openBrowser(){

        firefoxDriver.manage().window().maximize();
        firefoxDriver.get("https://demo.cubecart.com/cc6/admin_5xArPd.php");
    }
    public void closeBrowser(){
        firefoxDriver.close();
        firefoxDriver.quit();
    }
}
