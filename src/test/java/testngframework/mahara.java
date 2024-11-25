package testngframework;

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
public class mahara extends BaseClass1  {
    LoginPage1 loginPage1;
    DashboardPage1 dashboardPage1;
    FunctionsLibrary functionsLibrary;
    CustomerListPage1 customerListPage1;

    @BeforeClass
    public void setUp() {
        openBrowser();
       loginPage1 =new LoginPage1(driver);
      dashboardPage1=new DashboardPage1(driver);
        functionsLibrary = new FunctionsLibrary(driver);
        customerListPage1 = new CustomerListPage1(driver);


    }

    @Test(priority = 1, dataProvider = "loginData")
    public void loginTest(String userName, String password) {
        loginPage1.login(userName, password);



    }
@Test(priority = 2,dataProvider = "logOut")
public void logoutTest(){
        dashboardPage1.logOut();
}

    //@Test(priority = 2, dataProvider = "customerInfo")

    //public void  addCustomerTest( String firstName,String lastName,String zipcode){
       // customerListPage.verifyCustomerAdded();
      // customerListPage.addCustomer(firstName,lastName,zipcode);
   // }


   @AfterClass
   public void tearDown(){
        dashboardPage1.dropLink();
        dashboardPage1.logOut();
        closeBrowser();
   }

   /* @DataProvider
    public Object[][] customerInfo() {
        long timeStamp = System.currentTimeMillis();
        Object[][] customerDetails = {
                {"Ismet","Samsaq","ismet"+timeStamp+"@gmail.com"},
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()},
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()},
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()},
                {functionsLibrary.generateFakeName(), functionsLibrary.generateFakeName(), functionsLibrary.generateFakeEmail()}
        };
        return customerDetails;
    }*/

    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"admin", "MaharaDemo"}
        };

        return credentials;
    }
}