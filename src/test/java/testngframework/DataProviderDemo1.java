package testngframework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pageobjectdesignpattern.DashboardPage;
import pageobjectdesignpattern.LoginPage;

/**
 * @author : ismetsasaq
 * @created : 12/11/2024,11:33
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DataProviderDemo1 {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @BeforeClass
    public void setUp(){
       // openBrowser();
        loginPage=new LoginPage(new ChromeDriver());

    }
}
