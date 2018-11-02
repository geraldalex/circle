package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.User;
import sample.database.DatabaseHandler;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox SignUpChekBoxMan;

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
        SignUpButton.setOnAction(event -> {
            signUpNewUsers();

        });
    }

    private void    signUpNewUsers(){
        DatabaseHandler dbHandler = new DatabaseHandler();

         String firstName = SignUpName.getText();
         String lasttName = SignUpLastName.getText();
         String username = SignUpLogin.getText();
         String password = SiignUpPassword.getText();
         String gender = "";

         if(SignUpChekBoxWooman.isSelected())
             gender = "Женский";
         else
             gender = "Мужской";

        User user = new User(firstName,lasttName,username,password,gender);

        dbHandler.signUpUser(user);

    }
}
