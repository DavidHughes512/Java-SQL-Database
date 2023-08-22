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
import models.Reports;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

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
    private TableView<Appointments> anikeTableView;
    @FXML
    private TableView<Appointments> danielTableView;
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
    private TabPane contactTabPane;
    @FXML
    private Label aptNumberLabel;
    @FXML
    private Button getReportButton;
    @FXML
    private ListView<String> monthListView;

    @FXML
    private ListView<Integer> totalListView;

    @FXML
    private ListView<String> typreListView;

    @FXML
    void onActionGetReport(ActionEvent event) throws IOException {
        int total = 0;
        java.sql.Date today = java.sql.Date.valueOf(LocalDate.now());
        for(Appointments appointments : Appointments.allApts){
            if(appointments.getCreate_Date().equals(today) ){
             total++;
                aptNumberLabel.setText(Integer.toString(total));
            }
        }

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
    Reports.refreshReportsList();
    Reports.refreshTypeList();
    Reports.refreshMonthList();
        anikeTableView.setItems(Appointments.anikaApts);
        colAnicolAniAptId.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        colAniTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colAniType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colAniDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colAniStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        colAniEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        colAniCustId.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));

        danielTableView.setItems(Appointments.danielApts);
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


        for(Appointments appointments : Appointments.allApts){
            int total = 0;
            System.out.println("This is appointment month:" + appointments.getStartDateTime(appointments.getStart()).toLocalDate().getMonth().toString());
            System.out.println("================================");
            String type = appointments.getType();
            String month = appointments.getStartDateTime(appointments.getStart().toString()).toLocalDate().getMonth().toString();
            for(Reports reports : Reports.reportsList){
                String type2 = reports.getType();
                String month2 = reports.getMonth();
                if(type.equals(type2) && month.equals(month2)){
                    total++;
                    Reports.totalList.add(total);
                }
            }
        }
        totalListView.setItems(Reports.totalList);
        monthListView.setItems(Reports.monthList);
        typreListView.setItems(Reports.typeList);


    }




}
