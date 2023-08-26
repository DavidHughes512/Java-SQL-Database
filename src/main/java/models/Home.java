package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.*;
/**This Class contains the methods and values required for GUI data manipulation and saving database data locally*/
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


   //======================CREATING DATETIME FOR CONVERSIONS===========================

    public static LocalDate myLD = LocalDate.now();

    public static LocalTime myLT = LocalTime.now();

    public static LocalDateTime myLDT = LocalDateTime.of(myLD, myLT);

    public static ZoneId myZID = ZoneId.systemDefault();

    public static ZonedDateTime mfZDT = ZonedDateTime.of(myLDT, myZID);

    public static LocalDate getMyLD() {
        return myLD;
    }

    public static LocalTime getMyLT() {
        return myLT;
    }

    public static LocalDateTime getMyLDT() {
        return myLDT;
    }

    public static ZoneId getMyZID() {
        return myZID;
    }

    public static ZonedDateTime getMfZDT() {
        return mfZDT;
    }
}
