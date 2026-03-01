package nopc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjectdesignpattern.FunctionsLibrary;

/**
 * @author : ismetsasaq
 * @created : 25/02/2026,22:03
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class Customers {
    ChromeDriver chromeDriver;
    FuctionLibrary fuctionLibrary;
    @FindBy(xpath = "(//li[(@class=\"nav-item has-treeview\")])[4]")
    WebElement dropLink;
    @FindBy(xpath = "//a[@href=\"/Admin/Customer/List\"]")

    WebElement customer;
    @FindBy(xpath = "//a[@href=\"/Admin/Customer/Create\"]")
    WebElement addNew;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "Password")
    WebElement passWord;
    @FindBy(id = "FirstName")
    WebElement firstName;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(id = "Gender_Male")
    WebElement gender;
    @FindBy(xpath = "class=\"field-validation-valid\"")
    WebElement customerRoles;

    @FindBy(name = "save")
    WebElement save;
    @FindBy(xpath = "//li[@id=\"select2-SelectedCustomerRoleIds-result-rw7e-3\"]")
    WebElement guests;
    @FindBy(xpath = "//span[@class=\"select2-selection__choice__remove\"]")
    WebElement remove;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]//span[contains(text(),'successfully')]")
    WebElement successfully;
    public Customers(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver,this);
        fuctionLibrary=new FuctionLibrary(chromeDriver);
    }
    public void addCustomer(String Email,String FirstName,String LastName){
        fuctionLibrary.waitForElementPresent(dropLink);
        dropLink.click();
        fuctionLibrary.waitForElementPresent(customer);
        customer.click();
        fuctionLibrary.waitForElementPresent(addNew);
        customer.click();
        fuctionLibrary.waitForElementPresent(email);
        email.sendKeys(Email);
        fuctionLibrary.waitForElementPresent(passWord);
        passWord.sendKeys();
        fuctionLibrary.waitForElementPresent(firstName);
        firstName.sendKeys(FirstName);
        fuctionLibrary.waitForElementPresent(lastName);
        lastName.sendKeys(LastName);
        fuctionLibrary.waitForElementPresent(gender);
        gender.click();
        fuctionLibrary.waitForElementPresent(remove);
        remove.click();
        fuctionLibrary.waitForElementPresent(customerRoles);
        customerRoles.click();
        fuctionLibrary.waitForElementPresent(guests);
        guests.click();
        fuctionLibrary.waitForElementPresent(save);
        save.click();
        fuctionLibrary.waitForElementPresent(successfully);
        successfully.isDisplayed();
    }
    public boolean verifyCustomerAdded() {
        fuctionLibrary.waitForElementPresent(successfully);
        if (successfully.isDisplayed())
            return true;


        else
            return false;


    }
}
