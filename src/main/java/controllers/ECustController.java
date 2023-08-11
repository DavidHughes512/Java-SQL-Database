package controllers;

import dao.CustomerQs;
import dao.LvLDivisionQs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Countries;
import models.Customers;
import models.FirstLvlDivisions;

import java.io.IOException;
import java.sql.SQLException;

public class ECustController {

    Stage stage;

    Parent scene;

    Customers eCustomer;

    @FXML
    private TextField custAddress;

    @FXML
    private ComboBox<Countries> custCountry;

    @FXML
    private TextField custID;

    @FXML
    private TextField custName;

    @FXML
    private TextField custPhone;

    @FXML
    private TextField custPostal;

    @FXML
    private ComboBox<FirstLvlDivisions> custState;

    @FXML
    private Button backHome;

    @FXML
    private Button saveCust;

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSaveCust(ActionEvent event) throws IOException {

       //Set Values

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onCountrySel(ActionEvent event) throws SQLException {
        custState.getItems().clear();
        int divisionID = custCountry.getSelectionModel().getSelectedItem().getCountry_ID();
        LvLDivisionQs.selectByCountry(divisionID);
        custState.setItems(FirstLvlDivisions.Divisions);
    }

    @FXML
    void onStateSel(ActionEvent event){

    }

    public void sendCust(Customers eCust){
        custID.setText(String.valueOf(eCust.getCustomer_ID()));
        custName.setText(String.valueOf(eCust.getCustomer_Name()));
        custAddress.setText(String.valueOf(eCust.getAddress()));
        custPostal.setText(String.valueOf(eCust.getPostal_Code()));
        custPhone.setText(String.valueOf(eCust.getPhone()));
    }



    @FXML
    void initialize(){
        custCountry.setItems(Countries.Countries);
    }
}