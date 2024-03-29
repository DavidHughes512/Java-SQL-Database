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
import java.util.*;

public class ReportsController {
    Stage stage;
    Parent scene;

    //HashMap<String, Integer> tracking = new HashMap<>();


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
    /*Reports.refreshTypeList();
    Reports.refreshMonthList();*/
    //Reports.refreshReportsMap();

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



        Reports.totalMap.clear();
        Reports.reportsList.forEach((r) -> Reports.incrementMap(r));

        Reports.monthList.clear();
        Reports.typeList.clear();
        Reports.totalList.clear();
            Reports.totalMap.forEach((k,v)->{
                String[] arr = k.split(",", 0);
            String month = arr[0];
            String type = arr[1];
            Integer num = v;
            Reports.monthList.add(month);
            Reports.typeList.add(type);
            Reports.totalList.add(num);
        });
        totalListView.setItems(Reports.totalList);
        monthListView.setItems(Reports.monthList);
        typreListView.setItems(Reports.typeList);





    }


 /*for(Appointments appointments : Appointments.allApts){
            int total = 0;
            String month = appointments.getStartDateTime(appointments.getStart()).getMonth().toString();
            String type = appointments.getType();

                Reports.totalList.add(total);
           }


        }*/
        /*for(Appointments appointments : Appointments.allApts){
            List<Integer> countList = new ArrayList<Integer>();
            for(Reports reports : Reports.reportsList){
                if(appointments.getType().equals(reports.getType()) && appointments.getStartDateTime(appointments.getStart()).getMonth().toString().equals(reports.getMonth())){
                    for(int i = 0; i <= countList.size(); i++){
                        if(appointments.getAppointment_ID() == countList.get(i)){

                        }else{
                            countList.add(appointments.getAppointment_ID());
                        }
                    }
                }
            }
            Reports.totalList.add(appointments.getAppointment_ID());
        }*/

}
