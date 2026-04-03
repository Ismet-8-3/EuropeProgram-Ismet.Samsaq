package databasetestautomation;

import com.unitedcoder.propertiesfiles.ReadFromConfig;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : ismetsasaq
 * @created : 29/12/2024,13:47
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DBTest {
    String fileName="config.properties";
    String url= ReadFromConfig.readFromConfig(fileName,"dburl");
    String port=ReadFromConfig.readFromConfig(fileName,"dbPort");
    String userName=ReadFromConfig.readFromConfig(fileName,"dbUserName");
    String password=ReadFromConfig.readFromConfig(fileName,"dbPassWord");
    String dbSchema=ReadFromConfig.readFromConfig(fileName,"dbfaultDataBase");
    DBConnection dbConnection;
    Connection connection;
    SQLQueries sqlQueries;
    @BeforeTest
    public void connectToDataBase(){
        dbConnection=new DBConnection();
        dbConnection.connectToDB(url,port,userName,password,dbSchema,ConnectionType.MYSQL);
        sqlQueries=new SQLQueries();



    }
    @Test
    public void getProductInfoTest(){
        boolean isProductFound = sqlQueries.getProductInfo("ismet samsaq",connection);
        Assert.assertTrue(isProductFound);

    }

@AfterClass
    public void closeDBConnection(){
        dbConnection.closeDBConnection(connection);
}
}
