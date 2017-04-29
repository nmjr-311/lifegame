package lifegame;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

/**
 * Created by numajiri on 17/01/03.
 *
 *   0 1 2
 *   3 4 5
 *   6 7 8
 *
 */
public class Environment {
    //自分(5番目の要素)と周りのcellを保持
    private boolean[] cells;
    private static int INVALID = 4;
    private boolean self;
    private Paint color;

    public Environment(boolean isAlive){
        cells = new boolean[9];
        self = isAlive;
        color = Color.WHITE;
    }

    public Environment(boolean isAlive, Paint color){
        cells = new boolean[9];
        self = isAlive;
        this.color = color;
    }

    public void updateSelf(){
        int aliveCellNum = 0;
        for(boolean b:cells)
            if (b) {
                aliveCellNum++;
            }
        if (aliveCellNum == 3) {
            self = true;
        }
        else if (aliveCellNum == 2 && self) {
            self = true;
        }
        else
            self = false;
    }

    public void setCells(boolean[] cells){
        assert cells.length == 9 : "cell length =" + cells.length;
        {
            int i = 0;
            for(boolean b:cells)
                this.cells[i++] = b;
        }
    }

    public boolean getIsAlive(){
        return self;
    }

    public Paint getColor(){
        return color;
    }

    public void setColor(Paint p){
        this.color = p;
    }
}
