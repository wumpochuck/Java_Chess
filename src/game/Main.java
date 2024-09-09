package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("Templates/field.fxml"));
        primaryStage.setTitle("game");
        primaryStage.setScene(new Scene(root, 512, 512));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        addFigures();
    }

    public static void addFigures(){
        Pawn whitePawn = new Pawn(0, 0, "white");
        whitePawn.createPawnImageView();
        // Add this pawn as a child of the scene
        ((Parent) root).getChildrenUnmodifiable().add(whitePawn.getFigureNode());


    }

    
}