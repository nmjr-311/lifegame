package lifegame.pattern;

import javafx.scene.paint.Paint;
import lifegame.Environment;
import utility.RandColor;

import java.util.Random;

/**
 * Created by numajiri on 17/01/04.
 */
public class ColumnPattern extends AbstractPattern {
    private static ColumnPattern pattern = new ColumnPattern();

    private ColumnPattern(){}

    @Override
    public void initialize(Environment[][] board, Random random, int size) {
        Paint p = RandColor.calcRandomRGB(random);
        for(int i = 0; i < board.length; i++){
            board[i][0] = new Environment(true, p);
        }
    }

    static public AbstractPattern getInstance() {
        return pattern;
    }
}
