package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.User;
import sample.animations.Shake;
import sample.database.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        idSignOutButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = pasword_field.getText().trim();

            if(!loginText.equals("")&&!loginPassword.equals("")){
                try {
                    loginUser(loginText,loginPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                //System.out.println("Login and password is empty");
                Shake userLoginAnim = new Shake(login_field);
                Shake userPassAnim = new Shake(pasword_field);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
            }
        });

        idSignUpButton.setOnAction(event -> {
    openNewScene("/sample/view/signUp.fxml");
        });

    }

    private void loginUser(String loginText, String loginPassword) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUasername(loginText);
        user.setPassword(loginPassword);
        ResultSet result =  dbHandler.getUser(user);

        int counter  = 0;

        while (result.next()){
            counter++;

        }

        if(counter >= 1){
            System.out.println("Success!");
            openNewScene("/sample/view/app.fxml");
        }else{
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(pasword_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();

        }

    }

    public void openNewScene(String window){
        idSignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}
