package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.SQLRecoverableException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/**This Class contains the methods and values required for GUI data manipulation and saving database data locally*/
public class Appointments {

    //==============================Declaring Variables==============================

    private int Appointment_ID;
    private String Title;
    private String Description;
    private String Location;
    private String Type;
    private String Start;
    private String End;
    private java.sql.Date Create_Date;
    private String Created_By;
    private java.sql.Timestamp Last_updated;
    private String Last_Updated_By;
    private int Customer_ID;
    private int User_ID;
    private int Contact_ID;

    public static ObservableList<Appointments> allApts = FXCollections.observableArrayList();

    public static ObservableList<Appointments> weekApts= FXCollections.observableArrayList();

    public static ObservableList<Appointments> monthApts = FXCollections.observableArrayList();

    public static ObservableList<Appointments> anikaApts = FXCollections.observableArrayList();
    public static ObservableList<Appointments> danielApts = FXCollections.observableArrayList();
    public static ObservableList<Appointments> liApts = FXCollections.observableArrayList();

    /** This is the constructor for the Appointments class*/
    public Appointments(int appointment_ID, String title, String description, String location, String type, String start, String end, java.sql.Date create_Date, String created_By, java.sql.Timestamp last_updated, String last_Updated_By, int customer_ID, int user_ID, int contact_ID) {
        Appointment_ID = appointment_ID;
        Title = title;
        Description = description;
        Location = location;
        Type = type;
        Start = start;
        End = end;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_updated = last_updated;
        Last_Updated_By = last_Updated_By;
        Customer_ID = customer_ID;
        User_ID = user_ID;
        Contact_ID = contact_ID;
    }

    //==============================Declaring Methods==============================


    public String getStart() {return Start;}
    /** This is the getStartDateTime method. This method Gets the start time and formats it to a different format*/
    public LocalDateTime getStartDateTime(String startDate){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(startDate, dtf);
        return dateTime;
    }

    public void setStart(String start) {
        Start = start;
    }
    /** This is the getStartDateTime method. This method Gets the end time and formats it to a different format*/
    public LocalDateTime getEndDateTime(String endDate){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, dtf);
        return endDateTime;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public Date getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(Date create_Date) {
        Create_Date = create_Date;
    }

    public Timestamp getLast_updated() {
        return Last_updated;
    }

    public void setLast_updated(Timestamp last_updated) {
        Last_updated = last_updated;
    }

    public int getAppointment_ID() {
        return Appointment_ID;
    }

    public void setAppointment_ID(int appointment_ID) {
        Appointment_ID = appointment_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
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

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getContact_ID() {
        return Contact_ID;
}

    public void setContact_ID(int contact_ID) {
        Contact_ID = contact_ID;
    }
}
