package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
/**This Class contains the methods and values required for GUI data manipulation and saving database data locally*/
public class Reports {

    private String Month;

    private String Type;

    /** This is the constructor for the Reports class*/
    public Reports(String month, String type) {
        Month = month;
        Type = type;
    }

    String[] Months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static ObservableList<Reports> reportsList = FXCollections.observableArrayList();
    public static ObservableList<String> monthList = FXCollections.observableArrayList();
    public static ObservableList<String> typeList = FXCollections.observableArrayList();
    public static ObservableList<Integer> totalList = FXCollections.observableArrayList();
    int[] total ={};


    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public static void refreshReportsList(){
        reportsList.clear();
        for(Appointments appointments : Appointments.allApts){
            String type = appointments.getType();
            String month = appointments.getStartDateTime(appointments.getStart()).getMonth().toString();
            Reports.reportsList.add(new Reports(month, type));
        }
    }
    public static void createTypeList(){
        for(Reports reports : reportsList){

        }
    }

    public static void refreshMonthList(){
        monthList.clear();
        for(Reports reports : reportsList){
            monthList.add(reports.getMonth());
        }
    }

    public static void refreshTypeList(){
        typeList.clear();
        for(Reports reports : reportsList){
            typeList.add(reports.getType());
        }
    }

}
