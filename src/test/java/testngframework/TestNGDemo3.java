package testngframework;

import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 10/11/2024,21:52
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class TestNGDemo3 {
    @Test(invocationCount = 3,invocationTimeOut = 100)
    public void myTest(){
        System.out.println("Test Pass!!");
    }
    @Test(timeOut = 10)
    public void test2(){
        System.out.println("Test 2...");
    }
}
