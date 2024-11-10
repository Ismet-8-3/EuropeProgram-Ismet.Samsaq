package testngframework;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author : ismetsasaq
 * @created : 10/11/2024,19:26
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class TestNGDemo2 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class runs once before all");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method runs once before each test method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method runs once after each test method");
    }
    @Test
    public void addCustomerTest(){
        System.out.println("Add customer test");
        Assert.assertEquals("Add Customer","Add Customer");
    }
    @Test
    public void editCustomerTest(){
        System.out.println("Edit Customer Test");
        Assert.assertTrue("Customer Name".contains("Name"));
    }
    @Test(dependsOnMethods = "addCustomerTest")
    public void deleteCustomer(){
        System.out.println("Delete customer test..");
        Assert.assertTrue(19>9);

    }
    @Test
    public void addProduct(){
        System.out.println("Add Product test");
        Assert.assertTrue(11>10);
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class runs once after all tests");

    }
}
