package game;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Pawn extends Figure {

    private boolean wasFirstMove;

    public Pawn(int pos_x, int pos_y, String color) {
        super(pos_x, pos_y, color);

        this.wasFirstMove = false;
        ArrayList<String> possibleMoves = createPossibleMoves(color);
        super.setPossibleMoves(possibleMoves);
    }

    private ArrayList<String> createPossibleMoves(String color) {
        ArrayList<String> possibleMoves = new ArrayList<String>();

        // Moves for move
        if (color == "white") {
            possibleMoves.add("0,-1");
            possibleMoves.add("0,-2");
        } else {
            possibleMoves.add("0,1");
            possibleMoves.add("0,2");
        }

        // Moves for attack
        if (color == "white") {
            possibleMoves.add("-1,-1");
            possibleMoves.add("1,-1");
        } else {
            possibleMoves.add("-1,1");
            possibleMoves.add("1,1");
        }

        return possibleMoves;
    }

    public void createPawnNode() {
        // Create Pawn Node & set name
        AnchorPane pawnNode = new AnchorPane();
        pawnNode.setId(getPos_x() + "_" + getPos_y() + "_pawn_" + getColor());

        // Set pawn coordinates
        pawnNode.setLayoutX(getPos_x() * 64);
        pawnNode.setLayoutY(getPos_y() * 64);

        // Add pawn img
        ImageView image = new ImageView();
        image.setImage(new Image("file:src/game/assets/pawn_" + getColor() +
                ".png"));
        image.setId("i"); // id for image
        image.setFitHeight(64);
        image.setFitWidth(64);
        pawnNode.getChildren().add(image);

        // Add point img for moves
        ArrayList<String> moves = getPossibleMoves();
        for (int i = 0; i < moves.size(); i++) {
            String[] movePos = moves.get(i).split(",");
            int movePosX = Integer.parseInt(movePos[0]);
            int movePosY = Integer.parseInt(movePos[1]);
            ImageView createdImage = createMoveImage(movePosX, movePosY);
            pawnNode.getChildren().add(createdImage);
        }

        // Set node to class
        this.figureNode = pawnNode;
    }

    public void setSwitchMovesVisible(String switcher) {
        ObservableList<Node> movesArray = figureNode.getChildren();

        for (int i = 0; i < movesArray.size(); i++) {
            if (switcher.equals("true")) {
                if(movesArray.get(i).getId().charAt(0) == 'm'){
                    movesArray.get(i).setVisible(true);
                }
            } else if (switcher.equals("false")) {
                if(movesArray.get(i).getId().charAt(0) == 'm'){
                    movesArray.get(i).setVisible(false);
                }
            } else {
                System.out.println("ERROR while setting visibility of figure. Check Pawn.java");
                break;
            }
        }

    }

    public void setFirstMove() {
        this.wasFirstMove = true;
    }

    public boolean getFirstMove() {
        return this.wasFirstMove;
    }

}