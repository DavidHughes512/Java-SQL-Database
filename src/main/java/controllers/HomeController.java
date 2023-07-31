package controllers;

import dao.CustomerQs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Appointments;
import models.Contacts;
import models.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;

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
    private TableColumn<Appointments, ?> allAptContactCol;

    @FXML
    private TableColumn<Appointments, ?> allAptCustIdCol;

    @FXML
    private TableColumn<Appointments, ?> allAptDescCol;

    @FXML
    private TableColumn<Appointments, ?> allAptEndCol;

    @FXML
    private TableColumn<Appointments, ?> allAptIdCol;

    @FXML
    private TableColumn<Appointments, ?> allAptLocationCol;

    @FXML
    private TableColumn<Appointments, ?> allAptStartCol;

    @FXML
    private TableColumn<Appointments, ?> allAptTitleCol;

    @FXML
    private TableColumn<Appointments, ?> allAptTypeCol;

    @FXML
    private TableColumn<Appointments, ?> allAptUserIdCol;



    //==============================Month Appointments Tableview==============================\\

    @FXML
    private TableColumn<Appointments, ?> monthAptContactCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptCustIdCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptDescCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptEndCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptIdCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptLocationCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptStartCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptTitleCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptTypeCol;

    @FXML
    private TableColumn<Appointments, ?> monthAptUserIdCol;





    //==============================Week Appointments Tableview==============================\\

    @FXML
    private TableColumn<Appointments, ?> weekAptContactCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptCustIdCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptDescCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptEndCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptIdCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptLocationCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptStartCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptTitleCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptTypeCol;

    @FXML
    private TableColumn<Appointments, ?> weekAptUserIdCol;



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

            CustController ECustController = loader.getController();
            ECustController.sendCust((Customers) custTableView.getSelectionModel().getSelectedItem());


            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
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
            loader.setLocation(getClass().getResource("/Views/Customers.fxml"));
            loader.load();

            CustController ECustController = loader.getController();
            ECustController.sendCust((Customers) custTableView.getSelectionModel().getSelectedItem());


            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/Views/EditAppointments.fxml"));
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
        //======================= SETTING VALUES FOR CUSTOMERS TABLE =======================


        custTableView.setItems(Customers.CustomerList);
        CustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
        CustNameCol.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
        CustAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        CustPostCol.setCellValueFactory(new PropertyValueFactory<>("Postal_Code"));
        CustPhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));








        //======================= SETTING VALUES FOR APPOINTMENTS TABLES =======================





    }


}
