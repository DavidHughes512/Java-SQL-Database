package controllers;

import dao.AppointmentQs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Home;

import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**This Class contains the methods required for verifying login information, creating log files and establishing default locale*/
public class LoginController {


    Stage stage;
    Parent scene;
    public static ResourceBundle rb = ResourceBundle.getBundle("/Languages", Locale.getDefault());
    @FXML
    private Label currentRegion;
    @FXML
    private Label Region;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordTXT;

    @FXML
    private TextField usernameTXT;

    String login = "test";

    String date = LocalDate.now().toString();

    java.sql.Timestamp now = new Timestamp(System.currentTimeMillis());

    boolean loginValue = false;
    /** This is the onActionLogin method. This method verifies login information and saves data to a log file. The scene is then changed to the home screen*/
    @FXML
    void onActionLogin(ActionEvent event) throws IOException {

        //check for if login is empty
        if (usernameTXT.getText().isEmpty() || passwordTXT.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if(Locale.getDefault().getLanguage().equals("fr")){
              alert.setContentText(rb.getString("isEmpty"));
                alert.showAndWait();
                return;
            }
            else{
            alert.setTitle("Warning!");
            alert.setContentText("Please enter a Username and Password!");
            alert.showAndWait();
            return;
        }
        }
        String username = usernameTXT.getText();
        String password = passwordTXT.getText();


        //======================= LOG FILE CREATION AND READING =============================
        //File Name
        String filename = "src/Log_Activity.txt";

        //Creating file to read from
        File file = new File(filename);

        //Checking for file
        if(!file.exists()){
            PrintWriter firstFIle = new PrintWriter(filename);
        }

        //Create File Writer
        FileWriter logFileUpdated = new FileWriter(filename, true);

        //Create and Open FIle
        PrintWriter logFile = new PrintWriter(logFileUpdated);


        //=============== LOGIN VALIDATION ==============================

        if(username.equals(login) && password.equals(login)){
            //update log file
            logFile.println("Login attempt");
            logFile.println("On: " + date);
            logFile.println("Timestamp: " + now);
            logFile.println("Successful");
            logFile.println("=========");
            logFile.close();

            //Load next screen
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        }else{
            //show warning alert for login info
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if(Locale.getDefault().getLanguage().equals("fr")){
                alert.setContentText(rb.getString("error"));
                alert.showAndWait();
                return;
            }
            else{
            alert.setTitle("Warning!");
            alert.setContentText("Please enter correct Username and Password!");
            alert.showAndWait();

            //update log file
            logFile.println("Login attempt");
            logFile.println("On: " + date);
            logFile.println("Timestamp: " + now);
            logFile.println("Failed");
            logFile.println("=========");
            logFile.close();
            return;
        }
        }

    }
    /** This is the initialize method. This method Sets the default locale*/
    @FXML
    public void initialize() throws SQLException, IOException {

        currentRegion.setText(String.valueOf(Home.getMyZID()));
        /*LocalDateTime nowBF = LocalDateTime.now().plusMinutes(15);
        String now = nowBF.toString();
        java.sql.Timestamp now2 = new Timestamp(System.currentTimeMillis());
        //AppointmentQs.insert(4, "Title", "test", "home", "test", now, now, now2, "me", now2, "Me", 1, 1, 1);*/


    }
}



