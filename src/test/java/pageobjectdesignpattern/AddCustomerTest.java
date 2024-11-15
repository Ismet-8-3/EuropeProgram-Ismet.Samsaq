package pageobjectdesignpattern;

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
        dashboardPage=new DashboardPage(driver);
        customerListPage=new CustomerListPage(driver);
    }
    @Test
    public void addCustomerTest(){
        loginPage.login("admin","maharademo");
        dashboardPage.clickCustomerListLink();
        customerListPage.addCustomer("mr","ali","alim","asd@email.com");
        Assertions.assertTrue(customerListPage.verifyCustomerAdded());
    }
    @AfterEach
    public void tearDown(){
        closeBrowser();
    }
}
