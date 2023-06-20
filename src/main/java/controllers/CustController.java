package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.Customers;

public class CustController {

    @FXML
    private TextField custAddress;

    @FXML
    private ComboBox<?> custCountry;

    @FXML
    private TextField custID;

    @FXML
    private TextField custName;

    @FXML
    private TextField custPhone;

    @FXML
    private TextField custPostal;

    @FXML
    private ComboBox<?> custState;

    @FXML
    private Button backHome;

    @FXML
    private Button saveCust;

    @FXML
    void onActionBack(ActionEvent event) {

    }

    @FXML
    void onActionSaveCust(ActionEvent event) {

    }


    public void sendCust(Customers eCust){
        custID.setText(String.valueOf(eCust.getCustomer_ID()));
        custName.setText(String.valueOf(eCust.getCustomer_Name()));
        custAddress.setText(String.valueOf(eCust.getAddress()));
        custPostal.setText(String.valueOf(eCust.getPostal_Code()));
        custPhone.setText(String.valueOf(eCust.getPhone()));
    }
}
