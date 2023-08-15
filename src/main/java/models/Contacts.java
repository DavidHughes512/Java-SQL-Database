package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacts {

    //==============================Declaring Variables==============================

    private int Contact_ID;
    private String Contact_Name;
    private String Email;

    public static ObservableList<Contacts> Contacts = FXCollections.observableArrayList();

    public Contacts(int customer_ID, String contact_Name, String email) {
        Contact_ID = customer_ID;
        Contact_Name = contact_Name;
        Email = email;
    }

    //==============================Declaring Methods==============================

    public int getContact_ID() {
        return Contact_ID;
    }

    public void setContact_ID(int customer_ID) {
        Contact_ID = customer_ID;
    }

    public String getContact_Name() {
        return Contact_Name;
    }

    public void setContact_Name(String contact_Name) {
        Contact_Name = contact_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString(){
        return (Contact_Name);
    }
}
