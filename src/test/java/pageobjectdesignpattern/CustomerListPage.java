package pageobjectdesignpattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 09/11/2024,23:01
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class CustomerListPage {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
    @FindBy(linkText = "Add Customer")
    WebElement addCustomerLink;
    @FindBy(id = "cust-title")
    WebElement titleField;
    @FindBy(id = "name")
    WebElement firstNameField;
    @FindBy(id = "name")
    WebElement lastNameField;
    @FindBy(id = "name")
    WebElement emailField;
    @FindBy(name = "save")
    WebElement saveButton;
    @FindBy(id = "customer successfully added")
    WebElement customerAddedSuccessMessage;


    public CustomerListPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionsLibrary=new FunctionsLibrary(driver);
    }
    public void addCustomer(String title,String firstName,String lastName,String email){
        functionsLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionsLibrary.waitForElementPresent(titleField);
        titleField.sendKeys(title);
        functionsLibrary.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(firstName);
        functionsLibrary.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(lastName);
        functionsLibrary.waitForElementPresent(emailField);
        emailField.sendKeys(email);
        functionsLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }
    public boolean verifyCustomerAdded(){
        functionsLibrary.waitForElementPresent(customerAddedSuccessMessage);
        if (customerAddedSuccessMessage.isDisplayed())
            return true;
        else
            return false;
    }
}
