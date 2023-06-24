package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Home {

    //==============================Declaring Cust TableView List==============================

    private static ObservableList<Customers> allCustomers = FXCollections.observableArrayList();


    //==============================Declaring Cust TableView Methods==============================

    public static void addCust (Customers cust) {
        allCustomers.add(cust);
    }

    public static void updateCust (int index, Customers selectedCust) {
        allCustomers.set(index, selectedCust);
    }

    public static void deleteCust (Customers selectedCust){
        allCustomers.remove(selectedCust);
    }




    //==============================Declaring Apt TableView Lists==============================


    private static ObservableList<Appointments> allApts = FXCollections.observableArrayList();

    private static ObservableList<Appointments> weekApts= FXCollections.observableArrayList();

    private static ObservableList<Appointments> monthApts = FXCollections.observableArrayList();





    //==============================Declaring Apt TableView Methods==============================







}
