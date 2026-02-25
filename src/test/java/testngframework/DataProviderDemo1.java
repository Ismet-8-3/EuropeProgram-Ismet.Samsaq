package testngframework;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectdesignpattern.*;

/**
 * @author : ismetsasaq
 * @created : 12/11/2024,11:33
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DataProviderDemo1 extends BaseClass1 {
    LoginPage1 loginPage1;
    DashboardPage1 dashboardPage1;
    @BeforeClass
    public void setUp(){
       openBrowser();
        loginPage1=new LoginPage1(driver);
        dashboardPage1=new DashboardPage1(driver);

    }
    @Test(dataProvider = "loginData")
     public void loginTest(String userName,String password){
        loginPage1.login(userName,password);
        dashboardPage1.dropLink();
         dashboardPage1.logOut();
    }
  //  @AfterClass
  //  public void tearDown(){
   //     closeBrowser();
   // }




    @DataProvider
       public Object[][] loginData(){
    Object[][] credentials={
                {"admin","MaharaDemo"},
                {"student","MaharaDemo"}

        };
        return credentials;
    }
}
