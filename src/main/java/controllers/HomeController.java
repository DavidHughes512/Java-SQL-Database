package controllers;

import dao.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Appointments;
import models.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

public class HomeController {

Stage stage;
Parent scene;


    //==============================Customer Tableview==============================\\


    @FXML
    private TableView<Customers> custTableView;

    @FXML
    private TableColumn<Customers, String> CustAddressCol;

    @FXML
    private TableColumn<Customers, String> CustCountryCol;

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
    private Button deleteAptButton;


    //==============================Customer Buttons Actions==============================\\

    @FXML
    void onActionAddCust(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }


    @FXML
    void onActionDeleteCust(ActionEvent event) throws IOException {
       /*
        try {
         //Insert delete method
        }
        catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please select a Customer to delete!");
            alert.showAndWait();
            return;
        }*/
    }


    @FXML
    void onActionEditCust(ActionEvent event) throws IOException {

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
    void onActionAddApt(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/EditAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDeleteApt(ActionEvent event) {
        /*
        try {
         //Insert delete method
        }
        catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please select a Customer to delete!");
            alert.showAndWait();
            return;
        }*/
    }

    @FXML
    void onActionEdirApt(ActionEvent event) throws IOException {
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
        ContactQs.select();
        CountryQs.select();
        LvLDivisionQs.select();
        UserQs.select();

        //=========TEST VALUES FOR QUERIES=====================
        java.sql.Timestamp now = new Timestamp(System.currentTimeMillis());
        AppointmentQs.insert(3, "Title", "test", "home", "test", now, now, now, "me", now, "Me", 1, 1, 1);



        //======================= SETTING VALUES FOR CUSTOMERS TABLE =======================
        if(Customers.CustomerList.isEmpty()){
            CustomerQs.select();
            custTableView.setItems(Customers.CustomerList);
            CustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
            CustNameCol.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
            CustAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
            CustPostCol.setCellValueFactory(new PropertyValueFactory<>("Postal_Code"));
            CustPhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        }
        else{
            custTableView.setItems(Customers.CustomerList);
            CustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
            CustNameCol.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
            CustAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
            CustPostCol.setCellValueFactory(new PropertyValueFactory<>("Postal_Code"));
            CustPhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        }








        //======================= SETTING VALUES FOR APPOINTMENTS TABLES =======================

        if(Appointments.allApts.isEmpty()){
            AppointmentQs.select();
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
        }
        else{
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
        }


        //======================= SETTING VALUES FOR WEEK TABLE VIEW ==================================
        if(Appointments.weekApts.isEmpty()){
            AppointmentQs.selectByWeek();
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
        }
        else{
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
        }



        //======================= SETTING VALUES FOR MONTH TABLE VIEW ==================================

        if(Appointments.monthApts.isEmpty()){
            AppointmentQs.selectByMonth();
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
        }else{
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
        }




    }


}
