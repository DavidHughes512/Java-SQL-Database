package controllers;

import dao.AppointmentQs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Appointments;

import java.io.IOException;
import java.sql.SQLException;

public class ReportsController {
    Stage stage;
    Parent scene;

    public static void refreshAnikaTable() throws SQLException {
        Appointments.anikaApts.clear();
        AppointmentQs.selectForAnika();
    }

    public static void refreshDanielTable() throws SQLException {
        Appointments.danielApts.clear();
        AppointmentQs.selectForDaniel();
    }

    public static void refreshLiTable() throws SQLException {
        Appointments.liApts.clear();
        AppointmentQs.selectForLi();
    }

    @FXML
    private Button homeButton;
    @FXML
    private Label CountLbl1;

    @FXML
    private Label CountLbl2;

    @FXML
    private Label CountLbl3;

    @FXML
    private Label CountLbl4;

    @FXML
    private Label CountLbl5;
    @FXML
    private TableView<Appointments> anikeTableView;
    @FXML
    private TableView<Appointments> danileTableView;
    @FXML
    private TableView<Appointments> leeTableView;

    @FXML
    private TableColumn<Appointments, Integer> colAniCustId;

    @FXML
    private TableColumn<Appointments, String> colAniDesc;

    @FXML
    private TableColumn<Appointments, java.sql.Date> colAniEnd;

    @FXML
    private TableColumn<Appointments, java.sql.Date> colAniStart;

    @FXML
    private TableColumn<Appointments, String> colAniTitle;

    @FXML
    private TableColumn<Appointments, String> colAniType;

    @FXML
    private TableColumn<Appointments, Integer> colAnicolAniAptId;

    @FXML
    private TableColumn<Appointments, Integer> colDanAptId;

    @FXML
    private TableColumn<Appointments, Integer> colDanCustId;

    @FXML
    private TableColumn<Appointments, String> colDanDesc;

    @FXML
    private TableColumn<Appointments, java.sql.Date> colDanEnd;

    @FXML
    private TableColumn<Appointments, java.sql.Date> colDanStart;

    @FXML
    private TableColumn<Appointments, String> colDanTitle;

    @FXML
    private TableColumn<Appointments, String> colDanType;

    @FXML
    private TableColumn<Appointments, Integer> colLiAptId;

    @FXML
    private TableColumn<Appointments, Integer> colLiCustId;

    @FXML
    private TableColumn<Appointments, String> colLiDesc;

    @FXML
    private TableColumn<Appointments, java.sql.Date> colLiEnd;

    @FXML
    private TableColumn<Appointments, java.sql.Date> colLiStart;

    @FXML
    private TableColumn<Appointments, String> colLiTitle;

    @FXML
    private TableColumn<Appointments, String> colLiType;

    @FXML
    private Label monthLbl1;

    @FXML
    private Label monthLbl2;

    @FXML
    private Label monthLbl3;

    @FXML
    private Label monthLbl4;

    @FXML
    private Label monthLbl5;

    @FXML
    private Label typeLbl1;

    @FXML
    private Label typeLbl2;

    @FXML
    private Label typeLbl3;

    @FXML
    private Label typeLbl4;

    @FXML
    private Label typeLbl5;

    @FXML
    private Tab tabAnika;

    @FXML
    private Tab tabContactSchedule;

    @FXML
    private Tab tabDaniel;

    @FXML
    private Tab tabLiLee;
    @FXML
    private TabPane contactTabPane;


    @FXML
    void onActionAnikaSwitch(ActionEvent event) throws SQLException {

    }


    @FXML
    void onActionDanielSwitch(ActionEvent event) throws SQLException {



    }

    @FXML
    void onActionLiSwitch(ActionEvent event) throws SQLException {


    }

    @FXML
    void onActionHome(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }










    @FXML
    void initialize() throws SQLException {
    refreshAnikaTable();
    refreshLiTable();
    refreshDanielTable();
        anikeTableView.setItems(Appointments.anikaApts);
        colAnicolAniAptId.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        colAniTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colAniType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colAniDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colAniStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        colAniEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        colAniCustId.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));


        danileTableView.setItems(Appointments.danielApts);
        colDanAptId.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        colDanTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colDanType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colDanDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colDanStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        colDanEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        colDanCustId.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));

        leeTableView.setItems(Appointments.liApts);
        colLiAptId.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        colLiTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colLiType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colLiDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colLiStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        colLiEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        colLiCustId.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
    }

}
