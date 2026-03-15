package com.unitedcoder.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author : ismetsasaq
 * @created : 03/03/2026,19:40
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class mahara {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://demo.mahara.org/");
        driver.manage().window().maximize();


        WebElement loginButton=driver.findElement(By.id("login_login_username"));
        loginButton.sendKeys("admin");
        WebElement pass=driver.findElement(By.id("login_login_password"));
        pass.sendKeys("MaharaDemo");
        WebElement log=driver.findElement(By.id("login_submit"));
        log.click();
        //WebElement addAcadimy=driver.findElement(By.id("progress_item_academicgoal"));
       // addAcadimy.click();
        WebElement grup=driver.findElement(By.xpath("//div[@class=\"list-group-item-heading sidebar-item-heading\"]"));
        grup.click();
    }
}
