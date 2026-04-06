package databasetestautomation;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

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
    public boolean getCustomerInfo(String customerEmail, Connection connection){
        boolean isCustomerExist=false;
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
                    ("select film_id,email,first_name ,last_name from Film_list where name='%S'", customerEmail);
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
                    int customerID = cachedRowSet.getInt("customer_id");
                   String email = cachedRowSet.getString("first_name");
                    String  firstName = cachedRowSet.getString("email");
                    String lastName=cachedRowSet.getString("last_name");
                    System.out.println(String.format("customer_id=%d email=%s first_name=%s last_name=$s", customerID,email,firstName,lastName));
                    rowCount = cachedRowSet.getRow();
                }}catch (SQLException e) {
                e.printStackTrace();
            }

            if (rowCount >= 1 && name.equalsIgnoreCase(customerEmail)) {
                isCustomerExist = true;

            }
        }
        return isCustomerExist;
    }
    public boolean insertNewProduct(Connection connection) {
        String insertStatement = "Insert into cc_CubeCart_inventory(status,quantity,price,name,stock_level,tax_type, " +
                "seo_meta_title,seo_meta_Description,seo_meta_keywords)" +
                "values(1,10,55,'Casio',200,2,'seo-title','keywords')";
        Statement statement=null;
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int affectedRowsCount=0;
        try {
            affectedRowsCount=statement.executeUpdate(insertStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (affectedRowsCount>=1) {
            System.out.println(String.format("%d rows affected",affectedRowsCount));
            return true;
        }else
            return false;

    }
    public boolean insertNewProduct(Products products ,Connection connection) {
        String insertStatement = "Insert into cc_CubeCart_inventory(status,quantity,price,name,stock_level,tax_type, " +
                "seo_meta_title,seo_meta_Description,seo_meta_keywords)" +
                "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(insertStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {


                preparedStatement.setInt(1, products.getStatus());
                preparedStatement.setInt(2, products.getQuantity());
                preparedStatement.setDouble(3, products.getPrice());
                preparedStatement.setString(4, products.getName());
                preparedStatement.setInt(5, products.getStock_level());
                preparedStatement.setInt(6, products.getTaxType());
                preparedStatement.setString(7, products.getSeoMetaTitle());
                preparedStatement.setString(8, products.getSeoMetaDescription());
                preparedStatement.setString(9, products.getSeoMetaDescription());
            }catch(SQLException s){
                s.printStackTrace();

            }
        int affectedRowe=0;
        try {
            affectedRowe= preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("%d rows affected",affectedRowe));
        if (affectedRowe>=1){
            return true;
        }else
return false;
    }
}
