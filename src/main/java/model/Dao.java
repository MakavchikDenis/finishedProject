package model;


import ClassCollection.ClassPerson;

import javax.swing.table.TableCellEditor;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

 public abstract class Dao {
    private Connection con;

    public  Dao() {};

    public abstract void closeConnection ();

    public abstract void insertPerson(String name,String surname,String email);

    public abstract List getGroup();

    public abstract List getSelectMember(String name);

    public abstract void funUpdate(String name, String email);

    public abstract void funDelete(String name,String surname);


}
