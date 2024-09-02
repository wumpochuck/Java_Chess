package game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Main_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView field;

    @FXML
    void initialize() {
        assert field != null : "fx:id=\"field\" was not injected: check your FXML file 'game.fxml'.";

    }

}
