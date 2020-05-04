package main.java.by.makavchik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.by.makavchik.model.UserNew;
import main.java.by.makavchik.util.ConnectorDB;

public class UserDao {
    private final static String SQL_GET_USER = "Select login,passw from users where login=? and passw = ?";
    private final static String SQL_SET_USER="INSERT users (login,passw) values (?,?)";
    private final static String SQL_GET_USER_CHECK = "Select login from users where login=?";
    private Connection connection;

    public UserDao() {
        try {
            connection = ConnectorDB.getConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isValidUser(final String login, final byte[] password){
        PreparedStatement pr=null;
        try {
            pr=connection.prepareStatement(SQL_GET_USER);
            pr.setString(1,login);
            pr.setBytes(2,password);
            ResultSet rs=pr.executeQuery();

            while (rs.next()){
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(pr!=null){
                try {
                    pr.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean insertUser(UserNew ob){
        try {
            PreparedStatement pr=connection.prepareStatement(SQL_GET_USER_CHECK);
            pr.setString(1,ob.getLogin());
            ResultSet res =pr.executeQuery();
            if (res.next()){
                pr.close();
                return false;

            }
            else {
                PreparedStatement pr_new=connection.prepareStatement(SQL_SET_USER);
                pr_new.setString(1,ob.getLogin());
                pr_new.setBytes(2,ob.getPassword());
                pr_new.executeUpdate();
                pr_new.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
