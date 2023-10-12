package controllers;

import Interfaces.DeleteInterface;
import dao.*;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;


/**This Class contains the methods required for controlling both tableviews and directing you to the proper pages*/
public class HomeController {

    //public static ResourceBundle rb = ResourceBundle.getBundle("/Languages", Locale.getDefault());
Stage stage;
Parent scene;

    private boolean Flag = false;

    public void setFlag(){
        Flag = true;
    }

    public boolean getFlag(){
        return Flag;
    }

    public void aptDeleteCheck(int deleteID){
            /*for(Appointments apt : Appointments.allApts){
                if(deleteID == apt.getAppointment_ID()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + apt.getType() + " not Deleted!");
                    alert.showAndWait();
                    return;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + apt.getType() + " Deleted!");
                    alert.showAndWait();
                    return;
                }
            }*/
        }

    /** This is the refreshAllApt method. This method refreshes the allApts list*/
    public static void refreshAllApt() throws SQLException {
        Appointments.allApts.clear();
        AppointmentQs.select();
    }
    /** This is the refreshWeekApt method. This method refreshes the weekApts list*/
    public static void refreshWeekApt() throws SQLException {
        Appointments.weekApts.clear();
        AppointmentQs.selectByWeek();
    }
    /** This is the refreshMonthApt method. This method refreshes the monthApts list*/
    public static void refreshMonthApt() throws SQLException {
        Appointments.monthApts.clear();
        AppointmentQs.selectByMonth();
    }
    /** This is the refreshContacts method. This method refreshes the Contacts list*/
    public static void refreshContacts() throws SQLException {
        Contacts.Contacts.clear();
        ContactQs.select();
    }
    /** This is the refreshCountries method. This method refreshes the Countries list*/
    public static void refreshCountries() throws SQLException {
        Countries.Countries.clear();
        CountryQs.select();
    }
    /** This is the refreshCLvLDs method. This method refreshes the states list*/
    public static void refreshCLvLDs() throws SQLException {
        FirstLvlDivisions.States.clear();
        LvLDivisionQs.select();
    }
    /** This is the refreshUsers method. This method refreshes the Users list*/
    public static void refreshUsers() throws SQLException {
        Users.users.clear();
        UserQs.select();
    }
    /** This is the refreshCustomers method. This method refreshes the Customers list*/
    public static void refreshCustomers() throws SQLException{
        Customers.CustomerList.clear();
        CustomerQs.select();
    }
    /** This is A lambda for Deletion of customers. This Lambda Provides a clean execute for Customer data to be deleted and helps cut down on clutter when refreshing Lists*/
    DeleteInterface customers = toDelete -> {
        CustomerQs.delete(toDelete);
        refreshCustomers();
    };

    /** This is A lambda for Deletion of Appointments. This Lambda Provides a clean execute for Appointment data to be deleted and helps cut down on clutter when refreshing Lists
     *
     * This Lambda Allows for multiple calls of the delete method used on separate action buttons in a clean and efficient way.
     * */
    DeleteInterface Apts = toDelete -> {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this Appointment?");
        Optional<ButtonType> results = alert.showAndWait();
        if(results.isPresent() && results.get() == ButtonType.OK) {
            AppointmentQs.delete(toDelete);
            refreshAllApt();
            refreshMonthApt();
            refreshWeekApt();
        }
    };



    //==============================Customer Tableview==============================\\


    @FXML
    private TableView<Customers> custTableView;

    @FXML
    private TableColumn<Customers, String> CustAddressCol;

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
    private Button deleteAllAptButton;
    @FXML
    private Button deleteWeekAptButton;
    @FXML
    private Button deleteMonthAptButton;
    @FXML
    private Button AptReportsButton;

    //==============================Customer Buttons Actions==============================\\

    /** This is the onActionAddCust method. This method Connects you to the add customers page*/
    @FXML
    void onActionAddCust(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }



    /** This is the onActionDeleteCust method. This method uses a lambda to delete customers from the list*/
    @FXML
    void onActionDeleteCust(ActionEvent event) throws IOException, SQLException {

        try {

            int deleteID = custTableView.getSelectionModel().getSelectedItem().getCustomer_ID();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this customer? All Appointments with this customer will be deleted as well!");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                for(int i = 0; i < Appointments.allApts.size(); i++){
                    int custID = Appointments.allApts.get(i).getCustomer_ID();

                    if(custID == deleteID){
                        AppointmentQs.delete(Appointments.allApts.get(i).getAppointment_ID());
                        refreshAllApt();
                        refreshWeekApt();
                        refreshMonthApt();
                    }
                }
                /** This is A lambda for Deletion of customers. This Lambda Provides a clean execute for Customer data to be deleted and helps cut down on clutter when refreshing Lists*/
                CustomerQs.delete(custTableView.getSelectionModel().getSelectedItem().getCustomer_ID());
            }else{
                return;
            }

            refreshCustomers();
            for(Customers cust : Customers.CustomerList){
                if(deleteID == cust.getCustomer_ID()){
                    Alert alert2 = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Customer with ID of " + Integer.toString(deleteID) + " not Deleted!");
                    alert.showAndWait();
                    return;
                }
                else{
                    Alert alert2 = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Customer with ID of " + Integer.toString(deleteID) + " Deleted!");
                    alert.showAndWait();
                    return;
                }
            }

        }
        catch(NullPointerException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("Please select a Customer to delete!");
                alert.showAndWait();

            }
        }



    @FXML
    void onActionEditCust(ActionEvent event) throws IOException, SQLException {

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
    /** This is the onActionReports method. This method Connects you to the Reports page*/
    @FXML
    void onActionReports(ActionEvent event) throws SQLException, IOException{
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/aptReports.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    /** This is the onActionAddApt method. This method Connects you to the add appointments page*/
    @FXML
    void onActionAddApt(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/EditAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
    /** This is the onActionDeleteAllApt method. This method uses a lambda to delete Appointments from the list*/
    @FXML
    void onActionDeleteAllApt(ActionEvent event) throws SQLException, IOException{

        try {
            //aptDeleteCheck(allAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
            int deleteID = allAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID();
            String deleteType = allAptTableView.getSelectionModel().getSelectedItem().getType();
/** This is A lambda for Deletion of Appointments. This Lambda Provides a clean execute for Appointment data to be deleted and helps cut down on clutter when refreshing Lists*/
            Apts.delete(deleteID);
            if(Appointments.allApts.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType + " Deleted!");
                alert.showAndWait();
                return;
            }
            for(Appointments apt : Appointments.allApts){
                if(deleteID == apt.getAppointment_ID()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType + " not Deleted!");
                    alert.showAndWait();
                    return;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType  + " Deleted!");
                    alert.showAndWait();
                    return;
                }
            }

        }
        catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please select an Appointment from Proper Tab to delete!");
            alert.showAndWait();
            return;
        }
    }

    /** This is the onActionDeleteMonthApt method. This method uses a lambda to delete Appointments from the list*/
    @FXML
    void onActionDeleteMonthApt(ActionEvent event) throws SQLException, IOException{

        try {
            int deleteID = monthAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID();
            String deleteType = monthAptTableView.getSelectionModel().getSelectedItem().getType();

            //aptDeleteCheck(monthAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
            /** This is A lambda for Deletion of Appointments. This Lambda Provides a clean execute for Appointment data to be deleted and helps cut down on clutter when refreshing Lists*/
            Apts.delete(monthAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
            if(Appointments.allApts.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType + " Deleted!");
                alert.showAndWait();
                return;
            }
            for(Appointments apt : Appointments.allApts){
                if(deleteID == apt.getAppointment_ID()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType + " not Deleted!");
                    alert.showAndWait();
                    return;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType  + " Deleted!");
                    alert.showAndWait();
                    return;
                }
            }


    }
        catch (NullPointerException e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setContentText("Please select an Appointment from Proper Tab to delete!");
        alert.showAndWait();
        return;
    }
    }

    /** This is the onActionDeleteWeekApt method. This method uses a lambda to delete Appointments from the list*/
    @FXML
    void onActionDeleteWeekApt(ActionEvent event) throws SQLException, IOException{

        try {
            int deleteID = weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID();
            String deleteType = weekAptTableView.getSelectionModel().getSelectedItem().getType();

            //aptDeleteCheck(weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
            /** This is A lambda for Deletion of Appointments. This Lambda Provides a clean execute for Appointment data to be deleted and helps cut down on clutter when refreshing Lists*/
            Apts.delete(weekAptTableView.getSelectionModel().getSelectedItem().getAppointment_ID());
            if(Appointments.allApts.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType + " Deleted!");
                alert.showAndWait();
                return;
            }
            for(Appointments apt : Appointments.allApts){
                if(deleteID == apt.getAppointment_ID()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType + " not Deleted!");
                    alert.showAndWait();
                    return;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setContentText("Appointment with ID of: " + Integer.toString(deleteID) + " And of type: " + deleteType  + " Deleted!");
                    alert.showAndWait();
                    return;
                }
            }

    }
        catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setContentText("Please select an Appointment from Proper Tab to delete!");
                alert.showAndWait();
                return;
                }
    }

    /** This is the onActionEdirApt method. This method sends data to the edit appointment page and then switches to the right page*/
    @FXML
    void onActionEdirApt(ActionEvent event) throws IOException, SQLException {
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












    /** This is the initialize method. This method refreshes all the local lists with data from the SQL database and populates the table views with the appropriate data. This method also displays an alert for appointments within 15 minutes*/
    @FXML
    void initialize() throws SQLException {


        //======================= GETTING VALUES FOR COMBO BOXES =======================
        refreshContacts();
        if(Countries.Countries.isEmpty()){
            refreshCountries();
        }
        refreshUsers();
        if(FirstLvlDivisions.States.isEmpty()) {
            refreshCLvLDs();
        }
        //=========TEST VALUES FOR QUERIES=====================
        java.sql.Timestamp now = new Timestamp(System.currentTimeMillis());
        /*AppointmentQs.insert(3, "Title", "test", "home", "test", now, now, now, "me", now, "Me", 1, 1, 1);
        AppointmentQs.insert(4, "Title", "test", "home", "test", now, now, now, "me", now, "Me", 1, 1, 1);
        AppointmentQs.insert(5, "Title", "test", "home", "test", now, now, now, "me", now, "Me", 1, 1, 1);*/


        //======================= SETTING VALUES FOR CUSTOMERS TABLE =======================
            refreshCustomers();
            custTableView.setItems(Customers.CustomerList);
            CustIdCol.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
            CustNameCol.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
            CustAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
            CustPostCol.setCellValueFactory(new PropertyValueFactory<>("Postal_Code"));
            CustPhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            CustStateCol.setCellValueFactory(new PropertyValueFactory<>("Division_ID"));




        //======================= SETTING VALUES FOR APPOINTMENTS TABLE =======================
           refreshAllApt();
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


        //======================= SETTING VALUES FOR WEEK TABLE VIEW ==================================
            refreshWeekApt();
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

        //======================= SETTING VALUES FOR MONTH TABLE VIEW ==================================
            refreshMonthApt();
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

            //=================DETECTING UPCOMING APPOINTMENTS=======================

        int loopLength = 0;
        for(Appointments appointments : Appointments.allApts) {
            LocalDateTime listAptDT = appointments.getStartDateTime(appointments.getStart().toString());
            LocalTime listAptT = listAptDT.toLocalTime();
            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime nowoclockBF = LocalDateTime.now();
            LocalTime nowoclock= nowoclockBF.toLocalTime();


            if(listAptT.isAfter(nowoclock) && listAptT.isBefore(nowoclock.plusMinutes(15))){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                /*if(Locale.getDefault().getLanguage().equals("fr")){
                    alert.setContentText(rb.getString("minutes"));
                    alert.showAndWait();
                    return;
                }*/
                alert.setTitle("Upcoming Appointment!");
                alert.setContentText("Apointment ID: " + appointments.getAppointment_ID() + "   " + "Date: " + listAptDT.toLocalDate().toString() + "    " + "Time: " + listAptDT.toLocalTime().toString());
                alert.showAndWait();
                loopLength++;
                setFlag();


            }
            else{
                loopLength++;
            }

            if(loopLength == Appointments.allApts.size() && getFlag() == false){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                /*if(Locale.getDefault().getLanguage().equals("fr")){
                    alert.setContentText(rb.getString("appointments"));
                    alert.showAndWait();
                    return;
                }*/
                alert.setTitle("Appointment Info!");
                alert.setContentText("No Upcoming Appointments!");
                alert.showAndWait();
                setFlag();
            }

        }

    }

}



