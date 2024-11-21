package testngframework;

import net.datafaker.Faker;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
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
public class DataProviderDemo2 extends BaseClass  {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    FunctionsLibrary functionsLibrary;
    CustomerListPage customerListPage;

    @BeforeClass
    public void setUp() {
        openBrowser();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        functionsLibrary = new FunctionsLibrary(driver);
        customerListPage = new CustomerListPage(driver);


    }

    @Test(priority = 1, dataProvider = "loginData")
    public void loginTest(String userName, String password) {
        loginPage.login(userName, password);


    }

    //@Test(priority = 2, dataProvider = "customerInfo")
    //public void  addCustomerTest(String firstName,String lastName,String zipcode){

       // customerListPage.addCustomer(firstName,lastName,zipcode);
   // }

    @AfterClass
    public void tearDown() {
        dashboardPage.dropLink();
        dashboardPage.logOut();
        closeBrowser();
   }

    @DataProvider
    public Object[][] customerInfo() {
        long timeStamp = System.currentTimeMillis();
        Object[][] customerDetails = {
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()},
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()},
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()},
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()}
        };
        return customerDetails;
    }

    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"standard_user", "secret_sauce"}
        };

        return credentials;
    }
}