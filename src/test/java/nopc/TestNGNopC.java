package nopc;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 02/03/2026,16:51
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class TestNGNopC extends BaseClass {
    FuctionLibrary fuctionLibrary;
    LogInPage logInPage;
    DashBoard dashBoard;
    Customers customers;
    @BeforeClass
    public void setUp(){
        openBrowser();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");
        logInPage=new LogInPage(chromeDriver);
        logInPage.login("admin@yourstore.com","admin");
        fuctionLibrary=new FuctionLibrary(chromeDriver);
        dashBoard=new DashBoard(chromeDriver);
        customers=new Customers(chromeDriver);
    }
    @Test(priority = 1, dataProvider = "loginData")
     public void loginTest() {
       // logInPage.login("admin@yourstore.com","admin");


    }

}
