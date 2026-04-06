package cubecarttestng;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 15/03/2026,12:36
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class loginTest extends BaseClass {

    FunctionsPage functionsPage;

    LogInPage logInPage;
    CustomerPage customerPage;
    DashBoardPage dashBoardPage;

    @BeforeClass
    public void setUp() {
        openBrowser();
        logInPage = new LogInPage(firefoxDriver);

    }

    @Test(priority = 1,dataProvider = "loginData")
    public void loginTest(String user, String pass)
    {
        logInPage.login(user, pass);

    }










    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = {{"cubecart", "cubecart"}
        };

        return credentials;
    }
}
