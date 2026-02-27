package com.unitedcoder.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author : ismetsasaq
 * @created : 25/02/2026,20:25
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class Login {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();

       // WebElement userNameField=driver.findElement(By.xpath("//input[@class=\"email valid\"]"));
       // userNameField.sendKeys("admin@yourstore.com");
       // WebElement passWordField=driver.findElement(By.id("Password"));
       // passWordField.sendKeys("admin");
        WebElement loginButton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();
        WebElement customer=driver.findElement(By.xpath("(//li[(@class=\"nav-item has-treeview\")])[4]"));
        customer.click();
        WebElement cutomers=driver.findElement(By.xpath("//a[@href=\"/Admin/Customer/List\"]"));
        cutomers.click();
    }
}
