package pageobjectdesignpattern;

import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 12/11/2024,11:33
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class mahara1 extends BaseClass1  {
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


    @Test(priority = 2)
    public void addCustomerTest(){
        customerListPage1.addBlogAddress.click();
        customerListPage1.addEmailAddress.click();
        customerListPage1.addNewEmail.sendKeys(functionsLibrary.generateFakeEmail());
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastname=faker.name().lastName();
        String email=faker.internet().emailAddress();
        customerListPage1.officialWebsite.sendKeys(email);
        //customerListPage1.Country.click();
        customerListPage1.Town.sendKeys(lastname);
        customerListPage1.mobileNumber.sendKeys(firstName);
        customerListPage1.saveProfile.submit();



        //customerListPage.addCustomer("mr","ali","alim","asd@email.com");

        Assertions.assertTrue(customerListPage1.verifyCustomerAdded());

    }




  /*@DataProvider
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

    @AfterClass
    public void tearDown(){


        dashboardPage1.dropLink();
        dashboardPage1.logOut();
        closeBrowser();


    }




    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"admin", "MaharaDemo"}
        };

        return credentials;
    }
}