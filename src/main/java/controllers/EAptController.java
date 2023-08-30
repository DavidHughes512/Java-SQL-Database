package controllers;

import dao.AppointmentQs;
import dao.CustomerQs;
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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.*;

/**This Class contains the methods and items used to edit appointment data and sync properly with the SQL Database*/

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

    /** This is the onActionAptBack method. This method returns you to the home screen of the application*/
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
            selTime = selTime.plusMinutes(30);
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

    /** This is the onActionSaveApt method. This method takes all the input data of the user and saves and syncs to the database. The local list is then refreshed*/
    @FXML
    void onActionSaveApt(ActionEvent event) throws IOException, SQLException {

        Appointments apt = Appointments.allApts.get(Appointments.allApts.size() - 1);
        int lastId = apt.getAppointment_ID();
        java.sql.Timestamp now = new Timestamp(System.currentTimeMillis());


        try {


            if (setAptStartTime.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a Start Time");
                alert.showAndWait();
                return;
            }
            if (setAptEndTime.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a End Time");
                alert.showAndWait();
                return;
            }
            if (setAptDate.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a Date");
                alert.showAndWait();
                return;
            }

            if (contactCombo.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a Contact");
                alert.showAndWait();
                return;
            }
            if (custCombo.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a Customer");
                alert.showAndWait();
                return;
            }
            if (userCombo.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING!");
                alert.setContentText("Please select a User");
                alert.showAndWait();
                return;
            }
//======================Getting Date and Times ========================================
            LocalDate aptDate = setAptDate.getValue();
            LocalTime start = setAptStartTime.getValue();
            LocalTime end = setAptEndTime.getValue();
            LocalDateTime ldtS = LocalDateTime.of(aptDate, start);
            LocalDateTime ldtE = LocalDateTime.of(aptDate, end);
            ZoneId zID = ZoneId.systemDefault();
            ZonedDateTime zLdtS = ZonedDateTime.of(ldtS, zID);
            ZonedDateTime zLdtE = ZonedDateTime.of(ldtE, zID);
            ZoneId utcID = ZoneId.of("UTC");
            ZonedDateTime SutcZDT = ZonedDateTime.ofInstant(zLdtS.toInstant(), utcID);
            ZonedDateTime EutcZDT = ZonedDateTime.ofInstant(zLdtE.toInstant(), utcID);



//=================================Setting Values ============================================
            int id = Integer.parseInt(appointmentIDTXT.getText());
            String title = titleTXT.getText();
            String location = locationTXT.getText();
            String type = typeTXT.getText();
            String description = descriptionTXT.getText();
            java.sql.Timestamp time = now;
            String create = "Admin";
            String aptstart = SutcZDT.toLocalDateTime().toString();
            String aptend = EutcZDT.toLocalDateTime().toString();
            int cust = custCombo.getSelectionModel().getSelectedItem().getCustomer_ID();
            int contact = contactCombo.getSelectionModel().getSelectedItem().getContact_ID();
            int user = userCombo.getSelectionModel().getSelectedItem().getUser_ID();

//==================Checking overlap==============================================================

            for(Appointments appointments : Appointments.allApts) {
               LocalDateTime listAptDT = appointments.getStartDateTime(appointments.getStart().toString());
               if(listAptDT.isEqual(ldtS) && appointments.getAppointment_ID() != id){
                   Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("Warning!");
                   alert.setContentText("Appointments Can't be Overlapping!");
                   alert.showAndWait();
                   return;
               }

            }

            if(id > lastId ){
                AppointmentQs.insert(id,title,description,location, type, aptstart, aptend, now, create, now, create, cust, user, contact);
            }
            else{
                AppointmentQs.update(id, title, description, location, type, aptstart, aptend, now, create, now, create, cust, user, contact);
            }

            HomeController.refreshAllApt();
            HomeController.refreshMonthApt();
            HomeController.refreshWeekApt();

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

    /** This is the sendApt method. This method takes all the data from the home screen table and shares it with the edit page*/
    public void sendApt(Appointments appointment) throws SQLException {
        HomeController.refreshUsers();
        HomeController.refreshContacts();
        HomeController.refreshCustomers();

        appointmentIDTXT.setText(String.valueOf(appointment.getAppointment_ID()));
        descriptionTXT.setText(String.valueOf(appointment.getDescription()));
        locationTXT.setText(String.valueOf(appointment.getLocation()));
        titleTXT.setText(String.valueOf(appointment.getTitle()));
        typeTXT.setText(String.valueOf(appointment.getType()));

        //contactCombo.setValue(Contacts.Contacts.get(appointment.getContact_ID()));
        for(Contacts contact : contactCombo.getItems()){
            if(appointment.getContact_ID() == contact.getContact_ID()){
                contactCombo.setValue(contact);
                break;
            }
        }
        //custCombo.setValue(Customers.CustomerList.get(appointment.getCustomer_ID()));
        for(Customers cust : custCombo.getItems()){
            if(appointment.getCustomer_ID() == cust.getCustomer_ID()){
                custCombo.setValue(cust);
                break;
            }
        }
        //userCombo.setValue(Users.users.get(appointment.getUser_ID()));
        for(Users user : userCombo.getItems()){
            if(appointment.getUser_ID() == user.getUser_ID()){
               userCombo.setValue(user);
                break;
            }
        }

        setAptDate.setValue(appointment.getStartDateTime(appointment.getStart()).toLocalDate());
        setAptStartTime.setValue(appointment.getStartDateTime(appointment.getStart()).toLocalTime());
        setAptEndTime.setValue(appointment.getEndDateTime(appointment.getEnd()).toLocalTime());

    }

    /** This is the initialize method. This method sets local times and combo box values when the edit page is initialized*/
    @FXML
    void initialize() {
        custCombo.setItems(Customers.CustomerList);
        contactCombo.setItems(Contacts.Contacts);
        userCombo.setItems(Users.users);
        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(22, 0);

        while (start.isBefore(end)) {
            setAptStartTime.getItems().add(start);
            start = start.plusMinutes(30);
        }

        Appointments apts = Appointments.allApts.get(Appointments.allApts.size() - 1);
        int aptId = apts.getAppointment_ID();
        aptId++;
        appointmentIDTXT.setText(String.valueOf(aptId));


    }
}





