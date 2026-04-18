package com.unitedcoder.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author : ismetsasaq
 * @created : 08/04/2026,18:59
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class URLtest {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.coeck.be/nl-be/");
        driver.manage().window().maximize();
        WebElement overCoeck=driver.findElement(By.xpath("//a[@aria-current=\"page\"]"));
        overCoeck.click();
    }
}
