package cubecarttestng;

import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectdesignpattern.*;

/**
 * @author : ismetsasaq
 * @created : 05/03/2026,16:47
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class TestPage extends BaseClass{
    FunctionsPage functionsPage;
    LogInPage logInPage;
    CustomerPage customerPage;
    DashBoardPage dashBoardPage;
    @BeforeClass
    public void setUp() {
        openBrowser();
        logInPage = new LogInPage(firefoxDriver);
        dashBoardPage=new DashBoardPage(firefoxDriver);
        functionsPage = new FunctionsPage(firefoxDriver);
        customerPage = new CustomerPage(firefoxDriver);
    }
    @Test(priority = 1,dataProvider = "loginData")
        public void loginTest(String user, String pass)
    {
         logInPage.login(user, pass);
    }
    @Test(priority = 2,dependsOnMethods = "loginTest")
            public void addCustomerTest(){
       dashBoardPage.clickCustomerList();
       customerPage.addCustomer();
       boolean isCustomerAdded=customerPage.verifyCustomerAdded();
       Assertions.assertTrue(isCustomerAdded);
    }
    @Test(priority = 3,dependsOnMethods = "addCustomerTest")
    public void deleteCustomer(){
       //customerPage.deleteCustomer();
        customerPage.deleteOwenCustomer();
    boolean isCustomerDeleted=customerPage.verifyCustomerdeleted();
    Assert.assertTrue(isCustomerDeleted);



    }

    @AfterClass
            public void tearDown(){


        dashBoardPage.logout();
        firefoxDriver.quit();
    }
    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"cubecart", "cubecart"}
        };

        return credentials;
    }



    }
