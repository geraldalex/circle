package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pasword_field;

    @FXML
    private Button idSignOutButton;

    @FXML
    private Button idSignUpButton;

    @FXML
    void initialize() {
        idSignUpButton.setOnAction(event -> {
    System.out.println("Мудак!!!!" +
            "");
});

    }
}
