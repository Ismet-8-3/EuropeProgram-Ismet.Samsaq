package databasetestautomation;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : ismetsasaq
 * @created : 03/04/2026,19:34
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class SQLQueries {
    public boolean getProductInfo(String productName, Connection connection){
        boolean isProductExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;
        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {


            statement = connection.createStatement();
            String sqlScript = String.format
                    ("select film_id,film_name,price from Film_list where name='%S'", productName);
            resultSet = statement.executeQuery(sqlScript);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet==null){
            System.out.println("No records found!");

        }else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int rowCount = 0;
            String name=null;

            try {


            while (cachedRowSet.next()) {
                int productID = cachedRowSet.getInt("FID");
                 name = cachedRowSet.getString("name");
                double price = cachedRowSet.getDouble("price");
                System.out.println(String.format("FID=%d name=%s price=%.2f", productID, name, price));
                rowCount = cachedRowSet.getRow();
            }}catch (SQLException e) {
                e.printStackTrace();
            }

                if (rowCount >= 1 && name.equalsIgnoreCase(productName)) {
                    isProductExist = true;

                }
            }
        return isProductExist;
    }
}
