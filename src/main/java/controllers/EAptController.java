package controllers;

import dao.AppointmentQs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Appointments;

import java.io.IOException;

public class EAptController {

    Stage stage;
    Parent scene;

    Appointments eAppointment;

    @FXML
    private TextField appointmentIDTXT;

    @FXML
    private ComboBox<?> contactCombo;

    @FXML
    private TextField custIDTXT;

    @FXML
    private TextField descriptionTXT;

    @FXML
    private TextField locationTXT;

    @FXML
    private DatePicker setAptDate;

    @FXML
    private ComboBox<?> setAptTime;

    @FXML
    private TextField titleTXT;

    @FXML
    private TextField typeTXT;

    @FXML
    private TextField userIDTXT;

    @FXML
    void onActionAptBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionContact(ActionEvent event) {

    }

    @FXML
    void onActionSaveApt(ActionEvent event) throws IOException{

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }


}
