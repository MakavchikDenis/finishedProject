package model;


import com.sun.jdi.connect.Connector;
import util.ConnectorDB;
import ClassCollection.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao extends Dao {
    private final static String SQL_GET_PERSON = "Select *from person";
    private final static String SQL_INSERT_PERSON = "Insert into person (namel,surnamel,email)" +
            "values(?,?,?)";
    private final static String SQL_SELECT_MEMBER_PERSON= "Select *from person where namel=?";
    private final static String SQL_SELECT_UPDATE_PERSON="Update person set email=? where namel=?";
    private final static String SQL_DELETE_PERSON ="Delete from person where namel=? and surnamel=?";


    private Connection con;
    public PersonDao() {
        try {
            if(con==null){
                con= ConnectorDB.getConnection();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    };

    @Override
    public void closeConnection (){
        try {
            if(con!=null){
                con.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    };

    @Override
    public void insertPerson(String name,String surname,String email){
        try {
            PreparedStatement pr= con.prepareStatement(SQL_INSERT_PERSON);
            pr.setString(1,name);
            pr.setString(2,surname);
            pr.setString(3,email);
            pr.executeUpdate();
            pr.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    };

    @Override
    public List<ClassPerson> getGroup(){
        List<ClassPerson> group=new ArrayList<ClassPerson>();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(SQL_GET_PERSON);
            ClassPerson person=null;
            while (rs.next()){
                person=new ClassPerson(rs.getString("namel"),
                        rs.getString("surnamel"),rs.getString("email"));
                group.add(person);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return  group;
    }

    @Override
    public List getSelectMember(String name) {
        List<ClassPerson> group=new ArrayList<>();
        try {
            PreparedStatement pr=con.prepareStatement(SQL_SELECT_MEMBER_PERSON);
            pr.setString(1,name);
            ResultSet res=pr.executeQuery();
            while (res.next()){
                group.add(new ClassPerson(res.getString("namel"),res.getString("surnamel"),
                        res.getString("email")));
            }
            res.close();
            pr.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return group;
    };

    @Override
    public void funUpdate(String name, String email) {
        try {
            PreparedStatement pr=con.prepareStatement(SQL_SELECT_UPDATE_PERSON);
            pr.setString(1,email);
            pr.setString(2,name);
            pr.executeUpdate();
            pr.close();
        }
       catch (SQLException e){
            e.printStackTrace();
       }
    };

    @Override
    public void funDelete(String name, String surname) {
        try {
            PreparedStatement pr=con.prepareStatement(SQL_DELETE_PERSON);
            pr.setString(1,name);
            pr.setString(2,surname);
            pr.executeUpdate();
            pr.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
};

