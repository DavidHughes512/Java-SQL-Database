package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
/**This Class contains the methods and values required for GUI data manipulation and saving database data locally*/
public class Users {

    //==============================Declaring Variables==============================
    private int User_ID;
    private String User_Name;
    private String Password;
    java.sql.Timestamp Create_Date;
    private  String Created_By;
    java.sql.Timestamp Last_Update;
    private String Last_Updated_By;

    public static ObservableList<Users> users = FXCollections.observableArrayList();
    /** This is the constructor for the Users class*/
    public Users(int user_ID, String user_Name, String password, Timestamp create_Date, String created_By, Timestamp last_Update, String last_Updated_By) {
        User_ID = user_ID;
        User_Name = user_Name;
        Password = password;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
    }

    //==============================Declaring Methods==============================

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public String getLast_Updated_By() {
        return Last_Updated_By;
    }

    public void setLast_Updated_By(String last_Updated_By) {
        Last_Updated_By = last_Updated_By;
    }

    @Override
    public String toString(){
        return (User_Name);
    }

}
