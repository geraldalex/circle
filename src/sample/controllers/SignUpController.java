package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane SignUpChekBoxMan;

    @FXML
    private TextField SignUpName;

    @FXML
    private PasswordField SiignUpPassword;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField SignUpLogin;

    @FXML
    private CheckBox SignUpChekBoxWooman;

    @FXML
    void initialize() {

    }
}
