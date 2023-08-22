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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Countries;
import models.Customers;
import models.FirstLvlDivisions;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

/**This Class contains the methods required for updating customer information withing the SQL database and updating local lists*/

public class ECustController {

    Stage stage;

    Parent scene;

    Customers eCustomer;

    public int listId;

    int countryID = 0;
    int divisionID = 0;


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

    /** This is the onActionBack method. This method returns you to the homescreen*/
    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This is the onActionSaveCust method. This method Saves the input data to the SQL database. Then the local list is refreshed*/
    @FXML
    void onActionSaveCust(ActionEvent event) throws IOException, SQLException {
            Customers cust = Customers.CustomerList.get(Customers.CustomerList.size() - 1);
            int lastId = cust.getCustomer_ID();

        try {
            java.sql.Timestamp now = new Timestamp(System.currentTimeMillis());


            if (custCountry.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a Country");
                alert.showAndWait();
                return;
            }

            if (custState.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a State/Providence");
                alert.showAndWait();
                return;
            }

            int id = Integer.parseInt(custID.getText());
            String name = custName.getText();
            String address = custAddress.getText();
            String post = custPostal.getText();
            String phone = custPhone.getText();
            java.sql.Timestamp time = now;
            String create = "Admin";
            int divisID = custState.getSelectionModel().getSelectedItem().getDivision_ID();

            if(id > lastId ){
                CustomerQs.insert(id, name, address, post, phone, now, create, now, create, divisID);
            }
            else{
                CustomerQs.update(id, name, address, post, phone, now, create, now, create, divisID);
            }

            HomeController.refreshCustomers();

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();


        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING!");
            alert.setContentText("Please Fill Out All Fields!");
            alert.showAndWait();
        }




    }
    /** This is the onCountrySel method. This method populates the second combo box with proper information based on the first selection*/
    @FXML
    void onCountrySel(ActionEvent event) throws SQLException {
        HomeController.refreshCLvLDs();
        int countryID = custCountry.getValue().getCountry_ID();
        LvLDivisionQs.selectByCountry(countryID);
        custState.setItems(FirstLvlDivisions.Divisions);
    }

    @FXML
    void onStateSel(ActionEvent event){

    }
    /** This is the sendCust method. This method shares data from the home tableview to be edited in the Edit Customers page*/
    public void sendCust(Customers eCust) throws SQLException{

        for(FirstLvlDivisions states : FirstLvlDivisions.States){
            if(eCust.getDivision_ID() == states.getDivision_ID()){
                countryID = states.getCountry_ID();
            }
        }
        HomeController.refreshCLvLDs();
        LvLDivisionQs.selectByCountry(countryID);
        custState.setItems(FirstLvlDivisions.Divisions);

        custID.setText(String.valueOf(eCust.getCustomer_ID()));
        custName.setText(String.valueOf(eCust.getCustomer_Name()));
        custAddress.setText(String.valueOf(eCust.getAddress()));
        custPostal.setText(String.valueOf(eCust.getPostal_Code()));
        custPhone.setText(String.valueOf(eCust.getPhone()));

       for(Countries country : custCountry.getItems()){
            if(country.getCountry_ID() == countryID ){
                custCountry.setValue(country);
            }
        }

       for(FirstLvlDivisions states : custState.getItems()){
           if(states.getDivision_ID() == eCust.getDivision_ID()){
               custState.setValue(states);
           }
       }
    }


    /** This is the initialize method. This method sets combo box values when the edit page is initialized*/
    @FXML
    void initialize() throws SQLException {
        Customers cust = Customers.CustomerList.get(Customers.CustomerList.size() - 1);
        listId = cust.getCustomer_ID();
        listId++;
        custID.setText(String.valueOf(listId));
        custCountry.setItems(Countries.Countries);



    }
}
