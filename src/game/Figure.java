package game;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Figure {

    private int pos_x;
    private int pos_y;

    private String color;
    private ArrayList <String> possibleMoves;

    ImageView figureNode;

    public Figure(int pos_x, int pos_y, String color) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.color = color;
        this.possibleMoves = new ArrayList <String>();
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

    public ArrayList <String> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(ArrayList <String> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public ImageView getFigureNode() {
        return figureNode;
    }

    public void setFigureNode(ImageView figureNode) {
        this.figureNode = figureNode;
    }

}