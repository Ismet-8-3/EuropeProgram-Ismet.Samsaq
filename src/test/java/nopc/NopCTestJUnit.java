package nopc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author : ismetsasaq
 * @created : 25/02/2026,20:18
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class NopCTestJUnit extends BaseClass {
    LogInPage logInPage;
    DashBoard dashBoard;
    Customers customers;

    @BeforeEach
    public void setUp(){
        openBrowser();
       logInPage=new LogInPage(chromeDriver);
       logInPage.login("admin@yourstore.com","admin");
        dashBoard=new DashBoard(chromeDriver);
        customers=new Customers(chromeDriver);


    }
    @Test
    public void AddCustomers(){

        customers.dropLink.click();
        customers.customer.click();
        customers.addNew.click();
        customers.email.sendKeys("fdirsutssName"+System.currentTimeMillis()+"@gmail.com");
        customers.passWord.sendKeys("papa");
        customers.firstName.sendKeys("firstName");
        customers.lastName.sendKeys("lastname");
        customers.gender.click();
        //customers.remove.click();
       // customers.customerRoles.click();
     // customers.guests.click();
        customers.save.click();
        customers.successfully.isDisplayed();
        Assertions.assertTrue(customers.verifyCustomerAdded());




    }

    //  @Test
   // public void Logout(){
      //  dashBoard.logOut();
   // }


   /* @AfterEach
    public void tearDown(){
     closeBrowser();


    }*/
}
