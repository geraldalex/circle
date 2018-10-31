package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class CircleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageButtonCircle;

    @FXML
    void initialize() {
        assert imageButtonCircle != null : "fx:id=\"imageButtonCircle\" was not injected: check your FXML file 'app.fxml'.";

    }
}
