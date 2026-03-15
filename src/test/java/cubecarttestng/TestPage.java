package cubecarttestng;

import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        customerPage.customerList.click();
        customerPage.addCustomer.click();
        //customerPage.status.click();
        customerPage.title.sendKeys(functionsPage.generateFakeTitle());
        customerPage.firstN.sendKeys(functionsPage.generateFakeName());
        customerPage.lastN.sendKeys(functionsPage.generateFakeName());
        customerPage.type.click();
        customerPage.USD.click();
        customerPage.Notes.sendKeys(functionsPage.generateFakeNotes());
        customerPage.amount.sendKeys(functionsPage.generateFakeAmount());
        customerPage.Email.sendKeys(functionsPage.generateFakeEmail());
        customerPage.Phone.sendKeys(functionsPage.generateFakePhone());
        customerPage.Mobile.sendKeys(functionsPage.generateFakeMobile());
        customerPage.subToNew.click();
        customerPage.Save.submit();

        Assertions.assertTrue(customerPage.verifyCustomerAdded());
    }
    @Test(dependsOnMethods = "addCustomerTest")
    public void deleteCustomer(){



    }

    @AfterClass
            public void logOut(){


        dashBoardPage.logout();
        firefoxDriver.quit();






    }
   // @Test(priority = 2,dependsOnMethods = "loginTest")
   // public void logOut(){

   // }

    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"cubecart", "cubecart"}
        };

        return credentials;
    }



    }
