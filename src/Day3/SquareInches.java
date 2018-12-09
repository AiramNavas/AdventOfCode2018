package Day3;

import java.util.ArrayList;

public class SquareInches {

    private String[][] square;

    public SquareInches(Integer size){
        setSquare(new String[size][size]);
        InitializeSquare();
    }

    private void InitializeSquare(){
        for (int i = 0; i < getSquare().length; i++){

        }
    }

    public void setPosition(Integer i, Integer j, String c){
        getSquare()[i][j] = c;
    }

    public String getPosition(Integer i, Integer j){
        return getSquare()[i][j];
    }

    public String[][] getSquare() {
        return square;
    }

    public void setSquare(String[][] square) {
        this.square = square;
    }
}
