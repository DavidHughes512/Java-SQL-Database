module hughes.scheduleproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens hughes.scheduleproject to javafx.fxml;
    exports hughes.scheduleproject;
}