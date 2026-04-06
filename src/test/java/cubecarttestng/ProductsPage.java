package cubecarttestng;

import databasetestautomation.TestDataHolder;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

/**
 * @author : ismetsasaq
 * @created : 03/04/2026,22:08
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ProductsPage {
    FirefoxDriver firefoxDriver;
    FunctionsPage functionsPage;
    @FindBy(xpath = "//*[contains(text(),\"Add Product\")]")
    WebElement addProduct;
    @FindBy(id = "name")
    WebElement productNameField;
    @FindBy(id = "product_code")
    WebElement productCodeField;
    @FindBy(xpath = "//input[@name=\"submit_cont\"]")
    WebElement saveButton;
    @FindBy(xpath = "//div[@class=\"success\"]")
    WebElement productAddedSuccessMessage;
    @FindBy(css = "i.fa,fa-trash")
    WebElement deleteIcon;
    @FindBy(xpath = "//*[contains(text(),\"Product(s) successfully deleted.\")]")
    WebElement productDeletedSuccessMessage;

    public ProductsPage(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
        PageFactory.initElements(firefoxDriver, this);
        functionsPage = new FunctionsPage(firefoxDriver);
    }

    public void addProduct() {
        functionsPage.waitForElementPresent(addProduct);
        addProduct.click();
//        functionsPage.waitForElementPresent(productNameField);
//        String productName = functionsPage.generateFakeProductName();
//        TestDataHolder.setProductName(productName);
//        productNameField.sendKeys(productName);
//        productCodeField.sendKeys("Bng123");
        functionsPage.waitForElementPresent(saveButton);
        saveButton.click();
    }
    public boolean verifyProductAdded() {
        functionsPage.waitForElementPresent(productAddedSuccessMessage);
        ;
        if (productAddedSuccessMessage.isDisplayed()) {
            System.out.println("Product Added Successfully!!");

            return true;
        } else{
            System.out.println("Failed to Add Product");
        }
        return false;
    }

    }


