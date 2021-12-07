package com.example.login_latest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField user_name_text_field;

    @FXML
    private PasswordField password_text_field;

    @FXML
    private Button login_button;

    @FXML
    private PasswordField pf;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void loginValidation(ActionEvent loginActionEvent) {
        String name, pwd;
        name = user_name_text_field.getText();
        pwd = password_text_field.getText();
        alert.setTitle("Login Confirmation");
        alert.setHeaderText(null);
        if (!(name.isEmpty()) && !(pwd.isEmpty())) {
            if (name.equals("admin") && pwd.equals("password")) {
                alert.setContentText("Login Success");
                alert.show();
            } else {
                System.out.println("Login Failure");
                alert.setContentText("Invalid User Name or Password");
                alert.show();
            }
        } else {
            alert.setContentText("Field should not be empty");
            alert.show();
        }

    }
}
