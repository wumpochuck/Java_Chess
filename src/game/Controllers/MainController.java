package game.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import game.Pawn;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    // Constants for processing choice
    private ArrayList<Pawn> figureList = new ArrayList<>();
    private String currentNodeName = "";
    private String currentMove = "first";

    @FXML
    void initialize() {
        assert field != null : "fx:id=\"field\" was not injected: check your FXML file 'field.fxml'.";
        assert fieldImage != null : "fx:id=\"fieldImage\" was not injected: check your FXML file 'field.fxml'.";

        addFigures();


        // On field clicked event
        field.setOnMouseClicked(e -> {
            System.out.println(e.getTarget()); // Норм метод 
            // Get click coordinates
            int mousePosX = (int) (e.getX() / 64);
            int mousePosY = (int) (e.getY() / 64);
            System.out.println("Нажал на поле!, координаты: " + mousePosX + "," + mousePosY);

            for(int i = 0; i < figureList.size(); i++){
                String nodeName = figureList.get(i).getName();
                int nodePosX = figureList.get(i).getPos_x();
                int nodePosY = figureList.get(i).getPos_y();

                // If first figure chosen
                if(nodePosX == mousePosX && nodePosY == mousePosY && currentNodeName.equals("")){
                    System.out.println("Нажал на ноду " + nodeName);
                    clearMoves();
                    figureList.get(i).setSwitchMovesVisible("true");
                    break;
                }
                // If click on empty path of field
                else{
                    clearMoves();
                }


            }

            /*
            ObservableList<Node> nodeArray = field.getChildren(); // Можно обойтись без этого (ПОДУМАТЬ)
            // Как нибудь заменить через figureList
            for (int i = 0; i < nodeArray.size(); i++) {
                String nodeName = nodeArray.get(i).getId();
                int nodePosX = Character.getNumericValue(nodeName.charAt(0));
                int nodePosY = Character.getNumericValue(nodeName.charAt(2));

                // If any figure chosen
                if (nodePosX == mousePosX && nodePosY == mousePosY && currentNodeName.equals("")) {

                    clearMoves();

                    System.out.println("Выбрана нода: " + nodeName);
                    for (int j = 0; j < figureList.size(); j++) {
                        if (figureList.get(j).getFigureNode().getId().equals(nodeName)) {
                            figureList.get(j).setSwitchMovesVisible("true");
                        }
                    }
                    break;
                }
                // If nothing chosen
                else {
                    clearMoves();
                }
            }
            */

        });

    }

    public void clearMoves() {
        for (int j = 0; j < figureList.size(); j++) {
            figureList.get(j).setSwitchMovesVisible("false");
        }
    }

    public void addFigures() {
        Pawn whitePawn = new Pawn(6, 6, "white");
        whitePawn.createPawnNode();
        // Add this pawn as a child field
        field.getChildren().add(whitePawn.getFigureNode());

        figureList.add(whitePawn);

        Pawn blackPawn = new Pawn(5, 1, "black");
        blackPawn.createPawnNode();
        // Add this pawn as a child field
        field.getChildren().add(blackPawn.getFigureNode());

        figureList.add(blackPawn);
    }

}
