package controllers;

import javafx.scene.control.*;
import models.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

Stage stage;
Parent scene;


    //==============================Customer Tableview==============================\\

    @FXML
    private TableView<?> custTableView;

    @FXML
    private TableColumn<?, ?> CustAddressCol;

    @FXML
    private TableColumn<?, ?> CustCountryCol;

    @FXML
    private TableColumn<?, ?> CustIdCol;

    @FXML
    private TableColumn<?, ?> CustNameCol;

    @FXML
    private TableColumn<?, ?> CustPhoneCol;

    @FXML
    private TableColumn<?, ?> CustPostCol;

    @FXML
    private TableColumn<?, ?> CustStateCol;


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
    private TableView<?> weekAptTableView;

    @FXML
    private TableView<?> monthAptTableView;

    @FXML
    private TableView<?> allAptTableView;

    //==============================All Appointments Tableview==============================\\


    @FXML
    private TableColumn<?, ?> allAptContactCol;

    @FXML
    private TableColumn<?, ?> allAptCustIdCol;

    @FXML
    private TableColumn<?, ?> allAptDescCol;

    @FXML
    private TableColumn<?, ?> allAptEndCol;

    @FXML
    private TableColumn<?, ?> allAptIdCol;

    @FXML
    private TableColumn<?, ?> allAptLocationCol;

    @FXML
    private TableColumn<?, ?> allAptStartCol;

    @FXML
    private TableColumn<?, ?> allAptTitleCol;

    @FXML
    private TableColumn<?, ?> allAptTypeCol;

    @FXML
    private TableColumn<?, ?> allAptUserIdCol;



    //==============================Month Appointments Tableview==============================\\

    @FXML
    private TableColumn<?, ?> monthAptContactCol;

    @FXML
    private TableColumn<?, ?> monthAptCustIdCol;

    @FXML
    private TableColumn<?, ?> monthAptDescCol;

    @FXML
    private TableColumn<?, ?> monthAptEndCol;

    @FXML
    private TableColumn<?, ?> monthAptIdCol;

    @FXML
    private TableColumn<?, ?> monthAptLocationCol;

    @FXML
    private TableColumn<?, ?> monthAptStartCol;

    @FXML
    private TableColumn<?, ?> monthAptTitleCol;

    @FXML
    private TableColumn<?, ?> monthAptTypeCol;

    @FXML
    private TableColumn<?, ?> monthAptUserIdCol;





    //==============================Week Appointments Tableview==============================\\

    @FXML
    private TableColumn<?, ?> weekAptContactCol;

    @FXML
    private TableColumn<?, ?> weekAptCustIdCol;

    @FXML
    private TableColumn<?, ?> weekAptDescCol;

    @FXML
    private TableColumn<?, ?> weekAptEndCol;

    @FXML
    private TableColumn<?, ?> weekAptIdCol;

    @FXML
    private TableColumn<?, ?> weekAptLocationCol;

    @FXML
    private TableColumn<?, ?> weekAptStartCol;

    @FXML
    private TableColumn<?, ?> weekAptTitleCol;

    @FXML
    private TableColumn<?, ?> weekAptTypeCol;

    @FXML
    private TableColumn<?, ?> weekAptUserIdCol;



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
}
