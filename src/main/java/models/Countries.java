package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;

public class Countries {

    //==============================Declaring Variables==============================

    private int Country_ID;
    private String Country;
    private java.sql.Timestamp Create_Date;
    private String Created_By;
    private java.sql.Timestamp Last_Update;
    private String Last_Updated_By;

    public static ObservableList<Countries> Countries = FXCollections.observableArrayList();

    public Countries(int country_ID, String country, Timestamp create_Date, String created_By, Timestamp last_Update, String last_Updated_By) {
        Country_ID = country_ID;
        Country = country;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
    }

    //==============================Declaring Methods==============================

    public int getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(int country_ID) {
        Country_ID = country_ID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
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

    public Timestamp getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(Timestamp create_Date) {
        Create_Date = create_Date;
    }

    public Timestamp getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(Timestamp last_Update) {
        Last_Update = last_Update;
    }

    @Override
    public String toString(){
        return (Country);
    }

}


