package lifegame.pattern;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lifegame.Environment;
import utility.RandColor;

import java.util.Random;

/**
 * Created by numajiri on 17/01/04.
 */
public class GliderPattern extends AbstractPattern {
    static private GliderPattern pattern = new GliderPattern();
    private GliderPattern(){}

    @Override
    public void initialize(Environment[][] board, Random r, int canvasSize) {
        for(int n = 0; n < canvasSize / (9 * 20); n++){
            int x = r.nextInt(board.length);
            int y = r.nextInt(board[0].length);
            setSubGlider(board, x, y, r);
        }
    }

    private void setSubGlider(Environment[][] board, int x, int y, Random r){
        Paint p = RandColor.calcRandomRGB(r);

        int ny = y == 0 ? board[0].length-1 : y - 1;
        int nx;
        for (int i = -1; i <= 1; i++) {
            nx = x + i;
            nx = nx < 0 ? board.length-1 : nx == board.length ? 0 : nx;
            board[nx][ny] = new Environment(true, p);
        }

        ny = y;
        nx = x == 0 ? board.length - 1 : x - 1;
        board[nx][ny] = new Environment(true, p);

        ny = y == board[0].length - 1 ? 0 : y + 1;
        nx = x;
        board[nx][ny] = new Environment(true, p);
    }

    static public GliderPattern getInstance(){
        return pattern;
    }

}
