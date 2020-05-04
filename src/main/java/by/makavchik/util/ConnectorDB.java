package main.java.by.makavchik.util;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;


public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
       try {
           Class.forName("com.mysql.jdbc.Driver");
       }
        catch (ClassNotFoundException e){
           e.printStackTrace();
        }
        ResourceBundle resource = ResourceBundle.getBundle("db", Locale.getDefault());
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
