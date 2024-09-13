package game;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Figure {

    private String name;

    private int pos_x;
    private int pos_y;

    private String color;
    private ArrayList<String> possibleMoves;

    AnchorPane figureNode;

    public Figure(int pos_x, int pos_y, String color) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.color = color;
        this.possibleMoves = new ArrayList<String>();
    }

    // Getters, Setters

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<String> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(ArrayList<String> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public AnchorPane getFigureNode() {
        return figureNode;
    }

    public void setFigureNode(AnchorPane figureNode) {
        this.figureNode = figureNode;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ImageView createMoveImage(int posX, int posY) {
        ImageView image = new ImageView();
        image.setImage(new Image("file:src/game/assets/move.png"));
        image.setFitHeight(64);
        image.setFitWidth(64);

        image.setId("m_" + posX + "_" + posY); // move

        image.setLayoutX(posX * 64);
        image.setLayoutY(posY * 64);

        image.setVisible(false);

        return image;
    }

}