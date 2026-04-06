package databasetestautomation;

/**
 * @author : ismetsasaq
 * @created : 03/04/2026,22:27
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class TestDataHolder {
    public static  String productName;
    public static String getProductName(){
        return  productName;
    }

    public static void setProductName(String productName){
        TestDataHolder.productName=productName;
    }
    public static  String customerName;
    public  static  String customerName(){
        return customerName;
    }
    public static void setCustomerName(String customerName){
        TestDataHolder.customerName=customerName;
    }
}
