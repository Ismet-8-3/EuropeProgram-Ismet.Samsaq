package testngframework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectdesignpattern.BaseClass;
import pageobjectdesignpattern.DashboardPage;
import pageobjectdesignpattern.LoginPage;

/**
 * @author : ismetsasaq
 * @created : 12/11/2024,11:33
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DataProviderDemo1 extends BaseClass {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @BeforeClass
    public void setUp(){
       openBrowser();
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);

    }
    @Test(dataProvider = "loginData")
    public void loginTest(String userName,String password){
        loginPage.login(userName,password);
        dashboardPage.dropLink();
        // dashboardPage.logOut();
    }
    @DataProvider
       public Object[][] loginData(){
    Object[][] credentials={
                {"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"}

        };
        return credentials;
    }
}
