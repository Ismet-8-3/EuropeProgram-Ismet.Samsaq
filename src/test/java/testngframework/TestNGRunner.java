package testngframework;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjectdesignpattern.*;

/**
 * @author : ismetsasaq
 * @created : 26/11/2024,11:01
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class TestNGRunner extends BaseClass1 {
    LoginPage1 loginPage1;
    FunctionsLibrary functionsLibrary;
    DashboardPage1 dashboardPage1;
    EducationPage educationPage;

    @BeforeClass
    public void setUp(){
        openBrowser();
loginPage1 =new LoginPage1(driver);
dashboardPage1=new DashboardPage1(driver);
functionsLibrary=new FunctionsLibrary(driver);
educationPage=new EducationPage(driver);
loginPage1.login("admin","MaharaDemo");
    }
    @Test
    public void addProductTest(){
        dashboardPage1.educationHistory();
        educationPage.addEducationHistory();
        boolean isEducationHistoryAdded=educationPage.verifyEducationHistory();
        Assert.assertTrue(isEducationHistoryAdded);

    }
    @Test
    public void deleteproduct(){
        educationPage.deleteIconEducation();
        boolean isEducationHistoryDeleted=educationPage.verifyEducationDeleted();
        Assert.assertTrue(isEducationHistoryDeleted);

    }
    @AfterClass
    public void tearDown(){
        dashboardPage1.dropLink();
        dashboardPage1.logOut();
        closeBrowser();


    }
}
