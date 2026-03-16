package cubecarttestng;

import net.datafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
    String customerEmail=null;
    @FindBy(xpath = "//a[@href=\"https://demo.cubecart.com/cc6/admin_5xArPd.php?_g=customers&action=add\"]")
    WebElement addCustomer;
    @FindBy(xpath = "//img[@class=\"checkbox cbs\"]")
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
    @FindBy(xpath = "//*[contains(text(),\"Customer successfully added.\")]")
    WebElement customerAddedSuccessMessage;
    @FindBy(css = "i.fa.fa-trash")
    WebElement deleteIcon;
    @FindBy(xpath = "//*[contains(text(),\"Some or all selected Customer successfully deleted.\")]")
    WebElement customerDeletedSuccessMessage;






    public CustomerPage(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
        PageFactory.initElements(firefoxDriver, this);
        functionsPage = new FunctionsPage(firefoxDriver);
    }


    public void addCustomer() {

        functionsPage.waitForElementPresent(addCustomer);
        addCustomer.click();
       functionsPage.waitForElementPresent(status);
        status.click();
        functionsPage.waitForElementPresent(title);
        title.sendKeys(functionsPage.generateFakeTitle());
        functionsPage.waitForElementPresent(firstN);
        firstN.sendKeys(functionsPage.generateFakeFirstName());
        functionsPage.waitForElementPresent(lastN);
        lastN.sendKeys(functionsPage.generateFakeLastName());
        functionsPage.waitForElementPresent(type);
        type.click();
        functionsPage.waitForElementPresent(USD);
        USD.click();
        functionsPage.waitForElementPresent(Notes);
        Notes.sendKeys(functionsPage.generateFakeNotes());
        functionsPage.waitForElementPresent(amount);
        amount.sendKeys(functionsPage.generateFakeAmount());
        functionsPage.waitForElementPresent(Email);
        customerEmail=functionsPage.generateFakeEmail();
        Email.sendKeys(customerEmail);
        functionsPage.waitForElementPresent(Phone);
        Phone.sendKeys(functionsPage.generateFakePhone());
        functionsPage.waitForElementPresent(Mobile);
        Mobile.sendKeys(functionsPage.generateFakeMobile());
        functionsPage.waitForElementPresent(subToNew);
        subToNew.click();
        functionsPage.waitForElementPresent(Save);
        Save.submit();




    }

  public boolean verifyCustomerAdded() {
      functionsPage.waitForElementPresent(customerAddedSuccessMessage);
      if (customerAddedSuccessMessage.isDisplayed()) {
          System.out.println("Customer Added Successfully!!");

          return true;
      } else{
          System.out.println("Failed to Add Customer");
      }
          return false;
    }

public void deleteCustomer(){
        functionsPage.waitForElementPresent(deleteIcon);
        deleteIcon.click();
        functionsPage.waitForAlertPresent();
        Alert alert=firefoxDriver.switchTo().alert();
        alert.accept();
}
public void deleteOwenCustomer() {
    WebElement deletIcon = firefoxDriver.findElement(By.xpath(String.format
            ("//td[text()='%s']/following-sibling::td/\n" +
                    "descendant::i[@title='Delete']", customerEmail)));
    deletIcon.click();
    functionsPage.waitForAlertPresent();
    Alert alert = firefoxDriver.switchTo().alert();
    alert.accept();


}
      public boolean verifyCustomerdeleted() {
          functionsPage.waitForElementPresent(customerDeletedSuccessMessage);
          if (customerDeletedSuccessMessage.isDisplayed()) {
              System.out.println("Customer Deleted Successfully!!");
              return true;
          } else {
              System.out.println("Failed to Delete Customer");
              return false;


          }
      }
  }

