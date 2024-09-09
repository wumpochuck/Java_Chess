package game;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Figure {

    private boolean wasFirstMove;

    public Pawn(int pos_x, int pos_y, String color) {
        super(pos_x, pos_y, color);
        
        this.wasFirstMove = false;
        ArrayList <String> possibleMoves = setPossibleMoves(color);
        super.setPossibleMoves(possibleMoves);
    }
    
    private ArrayList <String> setPossibleMoves(String color) {
        ArrayList <String> possibleMoves = new ArrayList <String>();
        
        // Moves for move
        if(color == "white") {
            possibleMoves.add("-1,0");
            possibleMoves.add("-2,0");
        }
        else {
            possibleMoves.add("1,0");
            possibleMoves.add("2,0");
        }

        // Moves for attack
        if(color == "white") {
            possibleMoves.add("-1,-1");
            possibleMoves.add("-1,1");
        }
        else {
            possibleMoves.add("1,-1");
            possibleMoves.add("1,1");
        }

        return possibleMoves;
    }
 
    public void createPawnImageView(){
        ImageView pawnNode = new ImageView();
        pawnNode.setId("pawn_" + getColor() + "_" + getPos_x() + "_" + getPos_y());
        
        // Add pawn coordinates
        pawnNode.setLayoutX(getPos_x() * 64);
        pawnNode.setLayoutY(getPos_y() * 64);

        // Add pawn image
        pawnNode.setImage(new Image("file:src/game/assets/pawn_" + getColor() + ".png"));
        pawnNode.setFitHeight(64);
        pawnNode.setFitWidth(64);

        // Add event on mouse click
        pawnNode.setOnMouseClicked(e -> {
            System.out.println("Clicked on pawn: " + pawnNode.getId());
        });


        this.figureNode = pawnNode;
    }

}