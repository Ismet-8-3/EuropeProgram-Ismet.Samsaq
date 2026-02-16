package junittestingframework;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * @author : ismetsasaq
 * @created : 16/02/2026,21:56
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class JunitTestDemo2 {
   @BeforeAll
    public static void beforeAllMethod(){
        System.out.println("Before all runs once");
    }

    @BeforeEach
    public void beforeEachMethod(){
        System.out.println("Before each method..");
    }

    @Test

    public void addCustomerTest(){
        System.out.println("Add customer test..");
        Assertions.assertTrue(10>9);

    }

    @Test

    public void editCustomer(){
        System.out.println("Edit customer test");
        Assertions.assertEquals(10,10);
    }

    @Test

    public void deleteCustomer(){

        System.out.println("Delete customer test");
        Assert.assertEquals(4,4);
        Assert.assertEquals("ok","ok");
    }
    @AfterEach
    public void afterEachMethod(){
        System.out.println("After each method");
    }
    @AfterAll
    public static void afterAllMethod(){
        System.out.println("After all runs once");
    }
}


