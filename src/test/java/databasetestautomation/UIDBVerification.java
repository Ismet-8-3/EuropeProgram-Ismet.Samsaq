package databasetestautomation;

import com.unitedcoder.propertiesfiles.ReadFromConfig;
import cubecarttestng.*;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectdesignpattern.LoginPage;

import java.sql.Connection;

/**
 * @author : ismetsasaq
 * @created : 03/04/2026,21:45
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class UIDBVerification extends BaseClass {
    String fileName="config.properties";
    String url= ReadFromConfig.readFromConfig(fileName,"dburl");
    String port=ReadFromConfig.readFromConfig(fileName,"dbPort");
    String userName=ReadFromConfig.readFromConfig(fileName,"dbUserName");
    String password=ReadFromConfig.readFromConfig(fileName,"dbPassWord");
    String dbSchema=ReadFromConfig.readFromConfig(fileName,"dbfaultDataBase");
    DBConnection dbConnection;
    Connection connection;
    SQLQueries queries;
    LogInPage logInPage;
    DashBoardPage dashBoardPage;
    CustomerPage customerPage;
    ProductsPage productsPage;
    FunctionsPage functionsPage;
    String email=null;
    @BeforeClass
    public  void setUp(){
        openBrowser();
        logInPage = new LogInPage(firefoxDriver);
        dashBoardPage=new DashBoardPage(firefoxDriver);
        functionsPage=new FunctionsPage(firefoxDriver);
        productsPage=new ProductsPage(firefoxDriver);
        customerPage=new CustomerPage(firefoxDriver);
        //'SQL'ge ulash uchun ishlitimiz.
//        dbConnection=new DBConnection();
//        queries=new SQLQueries();
//        connection=dbConnection.connectToDB(url,port,userName,password,dbSchema,ConnectionType.MYSQL);

    }

    @Test(priority = 1,dataProvider = "loginData",groups = {"smock Test","regression test"})
    public void loginTest(String user, String pass)
    {
        logInPage.login(user, pass);
    }
    @Test(priority = 2)
    public void  addProductTest(){
        dashBoardPage.clickProductList();
        productsPage.addProduct();
        productsPage.verifyProductAdded();
        //'SQL'ge ulash uchun ishlitimiz.
//        Assert.assertTrue(productsPage.verifyProductAdded());
//        boolean isProductExist=queries.getProductInfo(TestDataHolder.getProductName(),connection);
//        Assert.assertTrue(isProductExist);
    }
    @Test(priority = 2,dependsOnMethods = "loginTest",groups = "regression test")
    public void addCustomerTest(){
        dashBoardPage.clickCustomerList();
        String firstName=functionsPage.generateFakeFirstName();
        String lastName=functionsPage.generateFakeFirstName();
        email=firstName+"."+lastName+System.currentTimeMillis()+"@gmail.com";
        customerPage.AddCustomer1("MR",firstName,lastName,email);
        Assertions.assertTrue(customerPage.verifyCustomerAdded());
        //'SQL'ge ulash uchun ishlitimiz.
//        Assert.assertTrue(customerPage.verifyCustomerAdded());
//        boolean isCustomerExist=queries.getCustomerInfo(TestDataHolder.getProductName(),connection);
//        Assert.assertTrue(isCustomerExist);

    }



    @Test(priority = 4,dependsOnMethods = "addCustomerTest")
    public void verifyCustomerInDataBase(){
        boolean isCustomerExist=queries.getCustomerInfo(email,connection);
        Assert.assertTrue(isCustomerExist);

    }
//    @AfterClass
//    public void tearDown(){
//        closeBrowser();
//       // dbConnection.closeDBConnection(connection);
//    }
    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"cubecart", "cubecart"}
        };

        return credentials;
    }
}
