package controllers;

import dao.AppointmentQs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Appointments;
import models.Contacts;
import models.Customers;
import models.Users;

import java.io.IOException;
import java.time.LocalTime;

public class EAptController {

    Stage stage;
    Parent scene;

    Appointments eAppointment;

    @FXML
    private TextField appointmentIDTXT;

    @FXML
    private ComboBox<Contacts> contactCombo;

    @FXML
    private ComboBox<Users> userCombo;

    @FXML
    private TextField descriptionTXT;

    @FXML
    private TextField locationTXT;

    @FXML
    private DatePicker setAptDate;

    @FXML
    private ComboBox<LocalTime> setAptStartTime;

    @FXML
    private ComboBox<LocalTime> setAptEndTime;

    @FXML
    private TextField titleTXT;

    @FXML
    private TextField typeTXT;

    @FXML
    private ComboBox<Customers> custCombo;

    @FXML
    void onActionAptBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionContact(ActionEvent event) {

    }

    @FXML
    void onActionTimeEndSel(ActionEvent event) {

    }

    @FXML
    void onActionTimeStartSel(ActionEvent event) {
        setAptEndTime.getItems().clear();
        LocalTime selTime = setAptStartTime.getSelectionModel().getSelectedItem();
        LocalTime end = LocalTime.of(22, 0);
        while(selTime.isBefore(end.plusSeconds(1))){
            setAptEndTime.setDisable(false);
            setAptEndTime.getItems().add(selTime);
            selTime = selTime.plusMinutes(15);
        }
    }

    @FXML
    void onActionUserSel(ActionEvent event) {

    }

    @FXML
    void onActionCustSel(ActionEvent event) {

    }

    @FXML
    void onActionContactSel(ActionEvent event) {

    }

    @FXML
    void onActionSaveApt(ActionEvent event) throws IOException {



        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }


    public void sendApt(Appointments appointment) {
        appointmentIDTXT.setText(String.valueOf(appointment.getAppointment_ID()));
        descriptionTXT.setText(String.valueOf(appointment.getDescription()));
        locationTXT.setText(String.valueOf(appointment.getLocation()));
        titleTXT.setText(String.valueOf(appointment.getTitle()));
        typeTXT.setText(String.valueOf(appointment.getType()));
    }

    @FXML
    void initialize() {
        custCombo.setItems(Customers.CustomerList);
        contactCombo.setItems(Contacts.Contacts);
        userCombo.setItems(Users.users);


        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(22, 0);

        while (start.isBefore(end)) {
            setAptStartTime.getItems().add(start);
            start = start.plusMinutes(15);
        }
    }
}





