package databasetestautomation;

import com.unitedcoder.propertiesfiles.ReadFromConfig;
import cubecarttestng.FunctionsPage;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

/**
 * @author : ismetsasaq
 * @created : 29/12/2024,13:47
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class InsertStatementTest {
    String fileName="config.properties";
    String url= ReadFromConfig.readFromConfig(fileName,"dburl");
    String port=ReadFromConfig.readFromConfig(fileName,"dbPort");
    String userName=ReadFromConfig.readFromConfig(fileName,"dbUserName");
    String password=ReadFromConfig.readFromConfig(fileName,"dbPassWord");
    String dbSchema=ReadFromConfig.readFromConfig(fileName,"standAloneDataBase");
    DBConnection dbConnection;
    Connection connection;
    SQLQueries sqlQueries;
    FunctionsPage functionsPage;
    @BeforeClass
    public void connectToDataBase(){
        dbConnection=new DBConnection();
        dbConnection.connectToDB(url,port,userName,password,dbSchema,ConnectionType.MYSQL);
        sqlQueries=new SQLQueries();



    }
    @Test
    public void addNewProductIntoDB(){
        boolean isProductAdded = sqlQueries.insertNewProduct(connection);
        Assert.assertTrue(isProductAdded);

    }
    @Test
    public void InsertNewProduct(){
        int quantity=1+(int)(Math.random()*10000);
        Faker faker=new Faker();
        String productName=faker.brand().car();
        Products products=new Products(1,quantity,quantity,productName,quantity,quantity,"Product_Title",
                "Product Detail Descriptions","Cars");
        boolean isProductInserted=sqlQueries.insertNewProduct(products,connection);
        Assert.assertTrue(isProductInserted);
    }

@AfterClass
    public void closeDBConnection(){
        dbConnection.closeDBConnection(connection);
}
}
