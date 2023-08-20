package controllers;

import dao.*;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class HomeController {

Stage stage;
Parent scene;

    public static void refreshAllApt() throws SQLException {
        Appointments.allApts.clear();
        AppointmentQs.select();
    }

    public static void refreshWeekApt() throws SQLException {
        Appointments.weekApts.clear();
        AppointmentQs.selectByWeek();
    }

    public static void refreshMonthApt() throws SQLException {
        Appointments.monthApts.clear();
        AppointmentQs.selectByMonth();
    }

    public static void refreshContacts() throws SQLException {
        Contacts.Contacts.clear();
        ContactQs.select();
    }
    public static void refreshCountries() throws SQLException {
        Countries.Countries.clear();
        CountryQs.select();
    }
    public static void refreshCLvLDs() throws SQLException {
        FirstLvlDivisions.States.clear();
        LvLDivisionQs.select();
    }
    public static void refreshUsers() throws SQLException {
        Users.users.clear();
        UserQs.select();
    }
    public static void refreshCustomers() throws SQLException{
        Customers.CustomerList.clear();
        CustomerQs.select();
    }


    //==============================Customer Tableview==============================\\


    @FXML
    private TableView<Customers> custTableView;

    @FXML
    private TableColumn<Customers, String> CustAddressCol;

    @FXML
    private TableColumn<Customers, Integer> CustIdCol;

    @FXML
    private TableColumn<Customers, String> CustNameCol;

    @FXML
    private TableColumn<Customers, String> CustPhoneCol;

    @FXML
    private TableColumn<Customers, String> CustPostCol;

    @FXML
    private TableColumn<Customers, String> CustStateCol;


    //==============================Customer Tableview Buttons==============================\\
    @FXML
    private Button addCustButton;

    @FXML
    private Button editCustButton;

    @FXML
    private Button deleteCustButton;


    //==============================Appointment Tableview Tabs==============================\\
    @FXML
    private Tab allTab;
    @FXML
    private Tab monthTab;

    @FXML
    private Tab weekTab;

    @FXML
    private TableView<Appointments> weekAptTableView;

    @FXML
    private TableView<Appointments> monthAptTableView;

    @FXML
    private TableView<Appointments> allAptTableView;

    //==============================All Appointments Tableview==============================\\


    @FXML
    private TableColumn<Appointments, Integer> allAptContactCol;

    @FXML
    private TableColumn<Appointments, Integer> allAptCustIdCol;

    @FXML
    private TableColumn<Appointments, String> allAptDescCol;

    @FXML
    private TableColumn<Appointments, java.sql.Date> allAptEndCol;

    @FXML
    private TableColumn<Appointments, Integer> allAptIdCol;

    @FXML
    private TableColumn<Appointments, String> allAptLocationCol;

    @FXML
    private TableColumn<Appointments, java.sql.Date> allAptStartCol;

    @FXML
    private TableColumn<Appointments, String> allAptTitleCol;

    @FXML
    private TableColumn<Appointments, String> allAptTypeCol;

    @FXML
    private TableColumn<Appointments, Integer> allAptUserIdCol;



    //==============================Month Appointments Tableview==============================\\

    @FXML
    private TableColumn<Appointments, String> monthAptContactCol;

    @FXML
    private TableColumn<Appointments, Integer> monthAptCustIdCol;

    @FXML
    private TableColumn<Appointments, String> monthAptDescCol;

    @FXML
    private TableColumn<Appointments, Timestamp> monthAptEndCol;

    @FXML
    private TableColumn<Appointments, Integer> monthAptIdCol;

    @FXML
    private TableColumn<Appointments, String> monthAptLocationCol;

    @FXML
    private TableColumn<Appointments, Timestamp> monthAptStartCol;

    @FXML
    private TableColumn<Appointments, String> monthAptTitleCol;

    @FXML
    private TableColumn<Appointments, String> monthAptTypeCol;

    @FXML
    private TableColumn<Appointments, Integer> monthAptUserIdCol;





    //==============================Week Appointments Tableview==============================\\

    @FXML
    private TableColumn<Appointments, String> weekAptContactCol;

    @FXML
    private TableColumn<Appointments, Integer> weekAptCustIdCol;

    @FXML
    private TableColumn<Appointments, String> weekAptDescCol;

    @FXML
    private TableColumn<Appointments, Timestamp> weekAptEndCol;

    @FXML
    private TableColumn<Appointments, Integer> weekAptIdCol;

    @FXML
    private TableColumn<Appointments, String> weekAptLocationCol;

    @FXML
    private TableColumn<Appointments, Timestamp> weekAptStartCol;

    @FXML
    private TableColumn<Appointments, String> weekAptTitleCol;

    @FXML
    private TableColumn<Appointments, String> weekAptTypeCol;

    @FXML
    private TableColumn<Appointments, Integer> weekAptUserIdCol;



    //==============================Appointment Buttons=======================================\\

    @FXML
    private Button editAptButton;

    @FXML
    private Button addAptButton;

    @FXML
    private Button deleteAllAptButton;
    @FXML
    private Button deleteWeekAptButton;
    @FXML
    private Button deleteMonthAptButton;
    @FXML
    private Button AptReportsButton;

    //==============================Customer Buttons Actions==============================\\

    @FXML
    void onActionAddCust(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }




    @FXML
    void onActionDeleteCust(ActionEvent event) throws IOException, SQLException {

        try {
            CustomerQs.delete(custTableView.getSelectionModel().getSelectedItem().getCustomer_ID());
            refreshCustomers();
        }
        catch(NullPointerException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("Please select a Customer to delete!");
                alert.showAndWait();

            }
        }



    @FXML
    void onActionEditCust(ActionEvent event) throws IOException, SQLException {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/Customers.fxml"));
            loader.load();

            ECustController eCustController = loader.getController();
            eCustController.sendCust(custTableView.getSelectionModel().getSelectedItem());


            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
        catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please select a Customer to edit!");
            alert.showAndWait();
            return;
        }

    }

    //==============================Appointment Buttons Actions==============================\\

    @FXML
    void onActionReports(ActionEvent event) throws SQLException, IOException{
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/aptReports.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionAddApt(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/EditAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDeleteAllApt(ActionEvent event) throws SQLException, IOException{

        try {
            /*int deleteID = -1;

            if(allAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID() != -1){
                deleteID = allAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID();
            }
            if(weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID() != -1){
                deleteID = weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID();
            }
            if(weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID() != -1){
                deleteID = weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID();
            }

            AppointmentQs.delete(deleteID);
            deleteID = -1;
            refreshAllApt();
            refreshWeekApt();
            refreshMonthApt();
            for (Appointments appointments : Appointments.allApts) {
                if (appointments.getAppointment_ID() == deleteID) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment failed to delete!");
                    alert.showAndWait();
                    break;
                    }
                }
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Appointment deleted!");
            alert.showAndWait();*/
            AppointmentQs.delete(allAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
            refreshAllApt();
            refreshMonthApt();
            refreshWeekApt();

        }
        catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please select an Appointment from Proper Tab to delete!");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void onActionDeleteMonthApt(ActionEvent event) throws SQLException, IOException{

        try {
        AppointmentQs.delete(monthAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
        refreshAllApt();
        refreshMonthApt();
        refreshWeekApt();

    }
        catch (NullPointerException e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setContentText("Please select an Appointment from Proper Tab to delete!");
        alert.showAndWait();
        return;
    }
    }

    @FXML
    void onActionDeleteWeekApt(ActionEvent event) throws SQLException, IOException{

        try {
        AppointmentQs.delete(weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
        refreshAllApt();
        refreshMonthApt();
        refreshWeekApt();

    }
        catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("Please select an Appointment from Proper Tab to delete!");
                alert.showAndWait();
                return;
                }
    }

    @FXML
    void onActionEdirApt(ActionEvent event) throws IOException, SQLException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/EditAppointments.fxml"));
            loader.load();

            EAptController EditAppointmentController = loader.getController();
            EditAppointmentController.sendApt(allAptTableView.getSelectionModel().getSelectedItem());


            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please select an appointment to edit!");
            alert.showAndWait();
            return;
        }

    }













    @FXML
    void initialize() throws SQLException {

        //======================= GETTING VALUES FOR COMBO BOXES =======================
        refreshContacts();
        if(Countries.Countries.isEmpty()){
            refreshCountries();
        }
        refreshUsers();
        if(FirstLvlDivisions.States.isEmpty()) {
            refreshCLvLDs();
        }
        //=========TEST VALUES FOR QUERIES=====================
        java.sql.Timestamp now = new Timestamp(System.currentTimeMillis());
        /*AppointmentQs.insert(3, "Title", "test", "home", "test", now, now, now, "me", now, "Me", 1, 1, 1);
        AppointmentQs.insert(4, "Title", "test", "home", "test", now, now, now, "me", now, "Me", 1, 1, 1);
        AppointmentQs.insert(5, "Title", "test", "home", "test", now, now, now, "me", now, "Me", 1, 1, 1);*/


        //======================= SETTING VALUES FOR CUSTOMERS TABLE =======================
            refreshCustomers();
            custTableView.setItems(Customers.CustomerList);
            CustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
            CustNameCol.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
            CustAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
            CustPostCol.setCellValueFactory(new PropertyValueFactory<>("Postal_Code"));
            CustPhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            CustStateCol.setCellValueFactory(new PropertyValueFactory<>("Division_ID"));




        //======================= SETTING VALUES FOR APPOINTMENTS TABLE =======================
           refreshAllApt();
            allAptTableView.setItems(Appointments.allApts);
            allAptIdCol.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
            allAptTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
            allAptDescCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
            allAptLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
            allAptContactCol.setCellValueFactory(new PropertyValueFactory<>("Contact_ID"));
            allAptTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
            allAptStartCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
            allAptEndCol.setCellValueFactory(new PropertyValueFactory<>("End"));
            allAptCustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
            allAptUserIdCol.setCellValueFactory(new PropertyValueFactory<>("User_ID"));


        //======================= SETTING VALUES FOR WEEK TABLE VIEW ==================================
            refreshWeekApt();
            weekAptTableView.setItems(Appointments.weekApts);
            weekAptIdCol.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
            weekAptTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
            weekAptDescCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
            weekAptLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
            weekAptContactCol.setCellValueFactory(new PropertyValueFactory<>("Contact_ID"));
            weekAptTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
            weekAptStartCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
            weekAptEndCol.setCellValueFactory(new PropertyValueFactory<>("End"));
            weekAptCustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
            weekAptUserIdCol.setCellValueFactory(new PropertyValueFactory<>("User_ID"));

        //======================= SETTING VALUES FOR MONTH TABLE VIEW ==================================
            refreshMonthApt();
            monthAptTableView.setItems(Appointments.monthApts);
            monthAptIdCol.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
            monthAptTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
            monthAptDescCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
            monthAptLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
            monthAptContactCol.setCellValueFactory(new PropertyValueFactory<>("Contact_ID"));
            monthAptTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
            monthAptStartCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
            monthAptEndCol.setCellValueFactory(new PropertyValueFactory<>("End"));
            monthAptCustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
            monthAptUserIdCol.setCellValueFactory(new PropertyValueFactory<>("User_ID"));

        int loopLength = 0;
        int flag = 0;
        for(Appointments appointments : Appointments.allApts) {
            LocalDateTime listAptDT = appointments.getStartDateTime(appointments.getStart().toString());
            LocalTime listAptT = listAptDT.toLocalTime();
            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime nowoclockBF = LocalDateTime.now();
            LocalTime nowoclock= nowoclockBF.toLocalTime();


            if(listAptT.isAfter(nowoclock) && listAptT.isBefore(nowoclock.plusMinutes(15))){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Upcoming Appointment!");
                alert.setContentText("Apointment ID: " + appointments.getAppointment_ID() + "   " + "Date: " + listAptDT.toLocalDate().toString() + "    " + "Time: " + listAptDT.toLocalTime().toString());
                alert.showAndWait();
                loopLength++;
                flag++;

            }
            else{
                loopLength++;
                System.out.println("This is looplength: " + loopLength);
            }

            if(loopLength == Appointments.allApts.size() && flag != 1){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("No Upcoming Appointments!");
                alert.showAndWait();
            }

        }

    }

}



