package pageobjectdesignpattern;

import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : ismetsasaq
 * @created : 29/11/2024,11:04
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class EducationPage {
    ChromeDriver driver;
FunctionsLibrary functionsLibrary;

@FindBy(id = "progress_item_educationhistory")
WebElement educationHistory;
@FindBy(xpath = "//span[@class=\"icon icon-chevron-down right\"]")
    WebElement addEducationHistory;
@FindBy(id = "addeducationhistory_startdate")
WebElement startDate;
@FindBy(id = "addeducationhistory_institution")
WebElement institution;
@FindBy(id = "addeducationhistory_submitbtn")
WebElement save;
@FindBy(xpath = "//div[@class=\"alert alert-success\"]")
WebElement addedSuccessMessage;
@FindBy(xpath = "//span[@class=\"icon icon-trash-alt text-danger\"]")
WebElement deleteIcon;
@FindBy(xpath = "//div[@class=\"alert alert-success\"]")
WebElement deletedSuccessMessage;
    public EducationPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionsLibrary=new FunctionsLibrary(driver);

    }
    public void addEducationHistory(){
        functionsLibrary.waitForElementPresent(educationHistory);
        educationHistory.click();
        functionsLibrary.waitForElementPresent(addEducationHistory);
        addEducationHistory.click();
        functionsLibrary.waitForElementPresent(startDate);
        startDate.sendKeys("2016-11-23");
        functionsLibrary.waitForElementPresent(institution);
        institution.sendKeys("2017-03-22");
        functionsLibrary.waitForElementPresent(save);
        save.submit();


    }
    public boolean verifyEducationHistory(){
        functionsLibrary.waitForElementPresent(addedSuccessMessage);
        if (addedSuccessMessage.isDisplayed()){
            System.out.println("Added Successfully!");
            return true;
    }else {
            System.out.println("failed to add Education History");
            return false;
}
    }
    public void deleteIconEducation(){
        functionsLibrary.waitForElementPresent(deleteIcon);
       deleteIcon.click();
       functionsLibrary.waitForAlertPresent();
       Alert alert=driver.switchTo().alert();
       alert.accept();

    }
    public boolean verifyEducationDeleted(){
        functionsLibrary.waitForElementPresent(deletedSuccessMessage);
        if (deletedSuccessMessage.isDisplayed()){
            System.out.println("Education History is Deleted!");
            return true;
        }
        else {
            System.out.println("Failed to Delete !");
            return false;
        }
    }
}
