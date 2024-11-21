package pageobjectdesignpattern;

import net.datafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author : ismetsasaq
 * @created : 13/11/2024,05:52
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class AddCustomerTest extends BaseClass{
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerListPage customerListPage;
    @BeforeEach
    public void setUp(){
        openBrowser();
        loginPage=new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        dashboardPage=new DashboardPage(driver);
        customerListPage=new CustomerListPage(driver);
    }
    @Test
    public void addCustomerTest(){
         customerListPage.addToCart.click();
         customerListPage.addToCart1.click();
         customerListPage.shopingCar.click();
         customerListPage.checkOut.click();
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastname=faker.name().lastName();

         customerListPage.firstNameField.sendKeys(firstName);
        customerListPage.lastNameField.sendKeys(lastname);
         customerListPage.zipCodeField.sendKeys("2840");
         customerListPage.Continue.click();
         customerListPage.Finish.click();
        customerListPage.verifyCustomerAdded();
         //customerListPage.backToProducts.click();

      //customerListPage.addCustomer("mr","ali","alim","asd@email.com");
    Assertions.assertTrue(customerListPage.verifyCustomerAdded());
     //  dashboardPage.dropLink();
       // dashboardPage.logOut();
         }


  //@AfterEach
 // public void tearDown()
 //{
     //// closeBrowser();
    //}

}
