package apitestautomation;

import com.unitedcoder.propertiesfiles.ReadFromConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v116.fetch.model.AuthChallengeResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : ismetsasaq
 * @created : 08/01/2025,06:10
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ApiTestDemo1 {
    private static String baseUrl;
    private static String userName;
    private static String password;
    private String fileName="config.properties";
    @BeforeClass
    public void setUp(){
        baseUrl= ReadFromConfig.readFromConfig(fileName,"uri");
        userName=ReadFromConfig.readFromConfig(fileName,"api.username");
        password=ReadFromConfig.readFromConfig(fileName,"api.password");
        
    }
    @Test
    public void getAllCategory(){
        //send request--get response
Response response= RestAssured.given().auth().basic(userName,password).when().get(baseUrl+"/categories")
        .then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test
    public void getAllCustomers(){
        //send request--get response
        Response response= RestAssured.given().auth().basic(userName,password).when().get(baseUrl+"/customers")
                .then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test
    public void addCategoryTest(){
        //send request--get response
        Response response= RestAssured.given().header("Content-Type","application/json")//request header
                .and().body(JsonPayload.addCategoryPayload()) .auth().basic(userName,password).when().post(baseUrl+"/category")
                .then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getString("catName").equals(JsonPayload.catName));

    }
    @Test
    public void addCategoryTest1(){
        //send request--get response
        Response response= RestAssured.given().header("Content-Type","application/json")//request header
                .and().body(JsonPayload.getAddCategoryPayload()) .auth().basic(userName,password).when().post(baseUrl+"/category")
                .then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getString("catName").contains("Apple product"));
        int categoryId=response.jsonPath().getInt("id");
        System.out.println("category id is "+categoryId);

    }
}
