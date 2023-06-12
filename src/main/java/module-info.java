module hughes.scheduleproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens hughes.scheduleproject to javafx.fxml;
    exports hughes.scheduleproject;
    exports controller;
    opens controller to javafx.fxml;
}