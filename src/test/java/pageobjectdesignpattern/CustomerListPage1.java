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
public class CustomerListPage1 {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
    @FindBy(id = "react-burger-menu-btn")
    WebElement dropLink;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCart;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addToCart1;
    @FindBy(id = "shopping_cart_container")
    WebElement shopingCar;
    @FindBy(id = "checkout")
    WebElement checkOut;
    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement zipCodeField;
    @FindBy(id = "continue")
    WebElement Continue;
    @FindBy(id = "finish")
    WebElement Finish;
    @FindBy(id = "back-to-products")
    WebElement backToProducts;
    @FindBy(className = "complete-header")
    WebElement customerAddedSuccessMessage;


    public CustomerListPage1(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionsLibrary=new FunctionsLibrary(driver);
    }
    public void addCustomer(String zipCode,String firstName,String lastName){
        functionsLibrary.waitForElementPresent(dropLink);
        dropLink.click();
        functionsLibrary.waitForElementPresent(addToCart);
        addToCart.click();
        functionsLibrary.waitForElementPresent(addToCart1);
        addToCart.click();
        functionsLibrary.waitForElementPresent(shopingCar);
        shopingCar.click();
        functionsLibrary.waitForElementPresent(checkOut);
        checkOut.click();
        functionsLibrary.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(firstName);
        functionsLibrary.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(lastName);
        functionsLibrary.waitForElementPresent(zipCodeField);
        zipCodeField.sendKeys(zipCode);
        functionsLibrary.waitForElementPresent(Continue);
        Continue.click();
        functionsLibrary.waitForElementPresent(Finish);
        Finish.click();
        functionsLibrary.waitForElementPresent(backToProducts);
        backToProducts.click();


    }
    public boolean verifyCustomerAdded(){
        functionsLibrary.waitForElementPresent(customerAddedSuccessMessage);
        if (customerAddedSuccessMessage.isDisplayed())
            return true;
        else
            return false;
    }
}
