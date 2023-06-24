package controllers;

import javafx.scene.control.Alert;
import models.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

Stage stage;
Parent scene;


    //==============================Customer Tableview==============================\\

    @FXML
    private TableView<?> custTableView;


    //==============================Customer Tableview Buttons==============================\\
    @FXML
    private Button addCustButton;

    @FXML
    private Button editCustButton;

    @FXML
    private Button deleteCustButton;


    //==============================Appointment Tableview==============================\\
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



//==============================Appointment Buttons==============================\\

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
