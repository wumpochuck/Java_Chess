package game.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import game.Pawn;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane field;

    @FXML
    private ImageView fieldImage;

    @FXML
    void initialize() {
        assert field != null : "fx:id=\"field\" was not injected: check your FXML file 'field.fxml'.";
        assert fieldImage != null : "fx:id=\"fieldImage\" was not injected: check your FXML file 'field.fxml'.";

        addFigures();

    }

    public void addFigures(){
        Pawn whitePawn = new Pawn(6, 6, "white");
        whitePawn.createPawnImageView();
        // Add this pawn as a child field
        field.getChildren().add(whitePawn.getFigureNode());

    }

}
