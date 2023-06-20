module hughes.scheduleproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Application to javafx.fxml;
    opens controllers to javafx.fxml;
    opens models to javafx.fxml;
    opens dao to javafx.fxml;
    exports models;
    exports controllers;
    exports Application;
    exports dao;
}