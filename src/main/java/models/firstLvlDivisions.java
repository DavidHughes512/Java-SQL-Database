package models;

import java.sql.Timestamp;

public class firstLvlDivisions {


    //==============================Declaring Methods==============================
    private int Division_ID;
    private String Division;
    private java.sql.Timestamp Create_Date;
    private String Created_By;
    private java.sql.Timestamp Last_Updated;
    private String Last_Updated_by;
    private int Country_ID;

    //==============================Declaring Methods==============================

    public int getDivision_ID() {
        return Division_ID;
    }

    public void setDivision_ID(int division_ID) {
        Division_ID = division_ID;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public String getLast_Updated_by() {
        return Last_Updated_by;
    }

    public void setLast_Updated_by(String last_Updated_by) {
        Last_Updated_by = last_Updated_by;
    }

    public int getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(int country_ID) {
        Country_ID = country_ID;
    }

    public Timestamp getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(Timestamp create_Date) {
        Create_Date = create_Date;
    }

    public Timestamp getLast_Updated() {
        return Last_Updated;
    }

    public void setLast_Updated(Timestamp last_Updated) {
        Last_Updated = last_Updated;
    }
}
