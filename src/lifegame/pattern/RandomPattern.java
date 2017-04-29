package lifegame.pattern;

import javafx.scene.paint.Color;
import lifegame.Environment;
import utility.RandColor;

import java.util.Random;

/**
 * Created by numajiri on 17/01/04.
 */
public class RandomPattern extends AbstractPattern{
    private static RandomPattern pattern = new RandomPattern();
    private RandomPattern(){}

    @Override
    public void initialize(Environment[][] board, Random rand, int canvasSize) {
        int xSize = board.length;
        int ySize = board[0].length;
        for(int c = 0; c < canvasSize / 10; c++){
            int x = rand.nextInt(xSize);
            int y = rand.nextInt(ySize);
            board[x][y] = new Environment(true);
            board[x][y].setColor(RandColor.calcRandomRGB(rand));
        }
    }

    static public AbstractPattern getInstance() {
        return pattern;
    }
}
