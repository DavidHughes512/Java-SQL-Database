package models;

import dao.CustomerQs;
import dao.LvLDivisionQs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.sql.Timestamp;

import javafx.collections.ObservableList;

public class Customers {

    //==============================Declaring Variables==============================

    private int Customer_ID;
    private String Customer_Name;
    private String Address;
    private String Postal_Code;
    private String Phone;
    //private java.sql.Timestamp Create_Date;
   // private String Created_By;
    //private java.sql.Timestamp Last_Update;
   // private String Last_Updated_By;
    private int Division_ID;

    public static ObservableList<Customers> CustomerList = FXCollections.observableArrayList();
    public static ObservableList<Customers> DivisionList = FXCollections.observableArrayList();

    public Customers(int customerId, String customerName, String address, String postalCode, String phone, int divisionId) {
        Customer_ID = customerId;
        Customer_Name = customerName;
        Address = address;
        Postal_Code = postalCode;
        Phone = phone;
        Division_ID = divisionId;
    }



    //==============================Declaring Methods==============================

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostal_Code() {
        return Postal_Code;
    }

    public void setPostal_Code(String postal_Code) {
        Postal_Code = postal_Code;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    /*public String getCreated_By() {
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

     */
    public int getDivision_ID() {
        return Division_ID;
    }

    public void setDivision_ID(int division_ID) {
        Division_ID = division_ID;
    }
    public void getAllCustomers() throws SQLException {
        CustomerQs.select();
    }
  /*  public Countries getCountry(FirstLvlDivisions state){
        int countryID = 0;
        for(FirstLvlDivisions states : FirstLvlDivisions.States) {
            if(state.getDivision_ID() == states.getDivision_ID()){
                countryID = states.getCountry_ID();
                break;
            }
        }
       return Countries.Countries.get(countryID);
    }*/

    @Override
    public String toString(){
        return (Customer_Name);
    }
}
