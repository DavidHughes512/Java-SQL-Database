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

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController {


    Stage stage;
    Parent scene;
    ResourceBundle rb = ResourceBundle.getBundle("/Languages", Locale.getDefault());
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

    @FXML
    void onActionLogin(ActionEvent event) throws IOException {

        String username = usernameTXT.getText();
        String password = passwordTXT.getText();
        String login = "test";
        java.sql.Timestamp now = new Timestamp(System.currentTimeMillis());

        if(username.equals(login) && password.equals(login)){
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please enter correct Username and Password!");
            alert.showAndWait();
            return;
        }


        //for log file, get username and password from text fields. Get now TimeStamp. Save all in log file
        //if file exists add new line and append previous file.

        if (usernameTXT.getText().isEmpty() || passwordTXT.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please enter correct Username and Password!");
            alert.showAndWait();
            return;
        }

    }
    @FXML
    public void initialize() throws SQLException {

        currentRegion.setText(String.valueOf(Locale.getDefault()));
        LocalDateTime nowBF = LocalDateTime.now().plusMinutes(15);
        String now = nowBF.toString();
        java.sql.Timestamp now2 = new Timestamp(System.currentTimeMillis());
        //AppointmentQs.insert(4, "Title", "test", "home", "test", now, now, now2, "me", now2, "Me", 1, 1, 1);




    }
}



