package lifegame.pattern;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lifegame.Environment;
import utility.RandColor;

import java.util.Random;

/**
 * Created by numajiri on 17/01/04.
 */
public class ReproducePattern extends AbstractPattern {
    private static ReproducePattern pattern = new ReproducePattern();

    private ReproducePattern(){}

    @Override
    public void initialize(Environment[][] board, Random rand, int size) {
        Paint color;
        int meanX = board.length / 2 - 4;
        int meanY = board[0].length / 2 + 3;
        //1
        color = RandColor.calcRandomRGB(rand);
        board[meanX++][meanY] = new Environment(true, color);
        //2
        color = RandColor.calcRandomRGB(rand);
        board[++meanX][meanY--] = new Environment(true, color);
        board[meanX++][meanY--] = new Environment(true, color);
        //3
        color = RandColor.calcRandomRGB(rand);
        board[++meanX][meanY--] = new Environment(true, color);
        board[meanX][meanY--] = new Environment(true, color);
        board[meanX++][meanY--] = new Environment(true, color);
        //4
        color = RandColor.calcRandomRGB(rand);
        board[++meanX][meanY++] = new Environment(true, color);
        board[meanX][meanY++] = new Environment(true, color);
        board[meanX++][meanY--] = new Environment(true, color);
        board[meanX][meanY] = new Environment(true, color);
    }

    static public AbstractPattern getInstance() {
        return pattern;
    }
}
