module com.example.login_latest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.login_latest to javafx.fxml;
    exports com.example.login_latest;
}
