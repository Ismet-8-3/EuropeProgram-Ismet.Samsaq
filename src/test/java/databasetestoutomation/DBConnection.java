package databasetestoutomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : ismetsasaq
 * @created : 29/12/2024,13:06
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class DBConnection {
    public Connection connectToDB(String dbUrl, String dbPort, String userName, String password,
                                  String defaultDB, ConnectionType connectionType){
        String JTDS_Driver="net.source.jtds.jdbc.Driver";//for mssql
        String MYSQL_Driver="com.mysql.cj.jdbc.Driver";//for mysql
        Connection connection=null;
        switch (connectionType){
            case MSSQL:
                try {
                    Class.forName(MYSQL_Driver);//load the driver
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String mySQLConnectionPath="jdbc:mysql://"+dbUrl+":"+dbPort+"/"+defaultDB+"?useSSL=false";
                try {
                    connection= DriverManager.getConnection(mySQLConnectionPath,userName,password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (!connection.isClosed()){
                        System.out.println("Data Base connection is established successfully!!");

                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case MYSQL:
                try {
                    Class.forName(JTDS_Driver);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String connectionPath="jdbc:jtds:sqlserver://"+dbUrl+";dataBaseName="+defaultDB;
                try {
                    connection=DriverManager.getConnection(connectionPath,userName,password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
                   return connection;
    }
    public void closeDBConnection(Connection connection){
        try {
            if (connection.isClosed()){
                System.out.println("Data base connection is close!!");
            }else {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
