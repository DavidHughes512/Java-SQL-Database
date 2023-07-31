package controllers;

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

        //Temp validation box. Replace with Credentials Check below

        if (usernameTXT.getText().isEmpty() || passwordTXT.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setContentText("Please enter correct Username and Password!");
            alert.showAndWait();
            return;
        }
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/Views/Home.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    @FXML
    public void initialize(){
        currentRegion.setText(String.valueOf(Locale.getDefault()));
    }
}



