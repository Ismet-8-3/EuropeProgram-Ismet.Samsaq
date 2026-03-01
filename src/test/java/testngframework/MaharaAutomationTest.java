package testngframework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectdesignpattern.*;

/**
 * @author : ismetsasaq
 * @created : 22/02/2026,13:55
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class MaharaAutomationTest extends BaseClass1 {
    LoginPage1 loginPage1;
    MaharaDashboardPage maharaDashboardPage;
    ProfileCompletionTips profileCompletionTips;
    FunctionsLibrary functionsLibrary;
    ProfilePage profilePage;

    @BeforeClass
    public void setUp() {
        openBrowser();
        loginPage1 =new LoginPage1(driver);
        maharaDashboardPage=new MaharaDashboardPage(driver);
        functionsLibrary=new FunctionsLibrary(driver);
        profilePage=new ProfilePage(driver);
        profileCompletionTips=new ProfileCompletionTips(driver);

}
    @Test(priority = 1, dataProvider = "loginData")
    public void loginTest(String userName, String password) {

        loginPage1.login(userName, password);

    }
    @Test(priority = 1, dataProvider = "loginData")
    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"admin", "MaharaDemo"}
        };

        return credentials;
    }
}

