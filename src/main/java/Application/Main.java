package Application;

import dao.CustomerQs;
import dao.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader (Main.class.getResource("/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        JDBC.openConnection();
        launch();

        int rowsAffected = CustomerQs.insert("John","Texas","a123",5555555, null, "Tester", null, "Tester", 24);

        if(rowsAffected > 0)
        {
            System.out.println("Insert Successful!");
        }
        else
        {
            System.out.println("Insert Failed!");
        }

        JDBC.closeConnection();
    }

    //Github testing blah blah blah
    //Locale.setDefault(new Locale("fr"));
}