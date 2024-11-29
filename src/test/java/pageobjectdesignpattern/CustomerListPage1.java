package pageobjectdesignpattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 09/11/2024,23:01
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class CustomerListPage1  {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
    @FindBy(xpath = "//span[@class=\"icon icon-chevron-down collapsed\"]")
    WebElement dropLink;
    @FindBy(id = "progress_item_blogaddress")
    WebElement addBlogAddress;
    @FindBy(xpath = "//button[@class=\"btn btn-secondary btn-sm align-with-input\"]")
    WebElement addEmailAddress;
    @FindBy(id = "addnewemail")
    WebElement addNewEmail;
    @FindBy(id = "profileform_officialwebsite")
    WebElement officialWebsite;
    @FindBy(id = "profileform_country")
    WebElement Country;
    @FindBy()
    WebElement lastNameField;
    @FindBy(id = "profileform_town")
    WebElement Town;
    @FindBy(id = "profileform_mobilenumber")
    WebElement mobileNumber;
    @FindBy(id = "profileform_submit")
    WebElement saveProfile;
    @FindBy(id = "back-to-products")
    WebElement backToProducts;
    @FindBy(id = "messages")
    WebElement profilesavedsuccessfully;


    public CustomerListPage1(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

        functionsLibrary=new FunctionsLibrary(driver);
    }
    public void addCustomer(String zipCode,String firstName,String lastName,String email){

        functionsLibrary.waitForElementPresent(addBlogAddress);
        addBlogAddress.click();
        functionsLibrary.waitForElementPresent(addEmailAddress);
        addEmailAddress.click();
        functionsLibrary.waitForElementPresent(addNewEmail);
        addEmailAddress.sendKeys(email);
        functionsLibrary.waitForElementPresent(officialWebsite);
        officialWebsite.sendKeys("www.mahara.com");
        functionsLibrary.waitForElementPresent(Country);
        Country.click();
        functionsLibrary.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(lastName);
        functionsLibrary.waitForElementPresent(Town);
        Town.sendKeys("Terhagen");
        functionsLibrary.waitForElementPresent(mobileNumber);
        mobileNumber.sendKeys("23443233");
        functionsLibrary.waitForElementPresent(saveProfile);
        saveProfile.click();
        functionsLibrary.waitForElementPresent(dropLink);
        dropLink.click();


    }
    public boolean verifyCustomerAdded(){
        functionsLibrary.waitForElementPresent(profilesavedsuccessfully);
        if (profilesavedsuccessfully.isDisplayed())
            return true;
        else
            return false;
    }
}
