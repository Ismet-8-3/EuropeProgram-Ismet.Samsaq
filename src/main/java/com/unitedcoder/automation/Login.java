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
        driver.get("https://demo.cubecart.com/cc6/admin_5xArPd.php");
        driver.manage().window().maximize();

       WebElement userNameField=driver.findElement(By.id("username"));
        userNameField.sendKeys("cubecart");
       WebElement passWordField=driver.findElement(By.id("password"));
        passWordField.sendKeys("cubecart");
        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
       // WebElement customer=driver.findElement(By.id("password"));
       // customer.click();
       // WebElement cutomers=driver.findElement(By.id("login"));
       // cutomers.click();
    }
}
