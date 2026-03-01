package pageobjectdesignpattern;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 09/11/2024,22:12
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class LoginPage{
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
   @FindBy(xpath = "//input[@class=\"email valid\"]")
   WebElement userNameField;

    @FindBy(id = "Password")
 WebElement passwordField;
    @FindBy(xpath ="//button[@type=\"submit\"]"
    )
    WebElement loginButton;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionsLibrary=new FunctionsLibrary(driver);
    }
   public void login(String userName,String password) {
        functionsLibrary.waitForElementPresent(userNameField);
        userNameField.sendKeys(userName);
        functionsLibrary.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
        functionsLibrary.waitForElementPresent(loginButton);
        loginButton.click();
    }
    }



