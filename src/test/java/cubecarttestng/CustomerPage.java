package cubecarttestng;

import net.datafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 05/03/2026,16:46
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class CustomerPage {
    FirefoxDriver firefoxDriver;
    FunctionsPage functionsPage;
    DashBoardPage dashBoardPage;

    @FindBy(xpath = "//a[@href=\"?_g=customers\"]")
    WebElement customerList;
    @FindBy(xpath = "//a[@href=\"https://demo.cubecart.com/cc6/admin_5xArPd.php?_g=customers&action=add\"]")
     WebElement addCustomer;
    @FindBy(id = "customer_status")
    WebElement status;
    @FindBy(id = "cust-title")
    WebElement title;
    @FindBy(id = "cust-firstname")
    WebElement firstN;
    @FindBy(id = "cust-lastname")
    WebElement lastN;
    @FindBy(id = "cust-type")
    WebElement type;
    @FindBy(xpath = "//select[@id='currency']/option[@value='USD']")
    WebElement USD;
    @FindBy(id = "cust-notes")
    WebElement Notes;
    @FindBy(id = "cust-credit")
    WebElement amount;
    @FindBy(id = "cust-email")
    WebElement Email;
    @FindBy(id = "cust-phone")
    WebElement Phone;
    @FindBy(id = "cust-mobile")
    WebElement Mobile;
    @FindBy(xpath = "//select[@id='subscription_status']/option[@value='2']")
    WebElement subToNew;
    @FindBy(name = "save")
    WebElement Save;
    @FindBy(className = "success")
    WebElement customerAddedSuccessMessage;




    public CustomerPage(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
        PageFactory.initElements(firefoxDriver, this);
        functionsPage = new FunctionsPage(firefoxDriver);
    }


    public void addCustomer(String Title,String firstName,String lastName,String notes,String email,String phone
    ,String mobile){
        functionsPage.waitForElementPresent(customerList);
        customerList.click();
        functionsPage.waitForElementPresent(addCustomer);
        addCustomer.click();
        functionsPage.waitForElementPresent(status);
        status.click();
        functionsPage.waitForElementPresent(title);
        title.sendKeys();
        functionsPage.waitForElementPresent(firstN);
        firstN.sendKeys();
        functionsPage.waitForElementPresent(lastN);
        lastN.sendKeys();
        functionsPage.waitForElementPresent(type);
        type.click();
        functionsPage.waitForElementPresent(USD);
        USD.click();
        functionsPage.waitForElementPresent(Notes);
        Notes.sendKeys();
        functionsPage.waitForElementPresent(amount);
        amount.sendKeys();
        functionsPage.waitForElementPresent(Email);
        Email.sendKeys();
        functionsPage.waitForElementPresent(Phone);
        Phone.sendKeys();
        functionsPage.waitForElementPresent(Mobile);
        Mobile.sendKeys();
        functionsPage.waitForElementPresent(subToNew);
        subToNew.click();
        functionsPage.waitForElementPresent(Save);
        Save.submit();







    }
    public boolean verifyCustomerAdded(){
        functionsPage.waitForElementPresent(customerAddedSuccessMessage);
        if (customerAddedSuccessMessage.isDisplayed())
            return true;
        else
            return false;
    }
    public void deleteCustomer(){
        functionsPage.deletCustomer();

    }

}

