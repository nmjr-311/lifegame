package lifegame.pattern;

import javafx.scene.paint.Paint;
import lifegame.Environment;
import utility.RandColor;

import java.util.Random;

/**
 * Created by numajiri on 17/01/04.
 */
public class GliderGunPattern extends AbstractPattern {
    private static GliderGunPattern pattern = new GliderGunPattern();
    private GliderGunPattern(){}

    @Override
    public void initialize(Environment[][] board, Random r, int canvasSize) {
        int leftX = board.length / 3;
        int midY = board[0].length / 2;
        parts1(board, leftX, midY, RandColor.calcRandomRGB(r));
        parts2(board, leftX, midY, RandColor.calcRandomRGB(r));
        parts3(board, leftX+12, midY+1, RandColor.calcRandomRGB(r));
        parts4(board, leftX+22, midY-1, RandColor.calcRandomRGB(r));
        parts1(board, leftX+34, midY-2, RandColor.calcRandomRGB(r));
    }

    static public GliderGunPattern getInstance(){
        return pattern;
    }

    private void parts1(Environment[][] board, int x, int y, Paint color){
        board[x][y+1] = new Environment(true, color);
        board[x+1][y+1] = new Environment(true, color);
        board[x][y+2] = new Environment(true, color);
        board[x+1][y+2] = new Environment(true, color);
    }

    private void parts2(Environment[][] board, int x, int y, Paint color){
        board[x+5][y] = new Environment(true, color);
        board[x+5][y-1] = new Environment(true, color);
    }

    private void parts3(Environment[][] board, int x, int y, Paint color){
        board[x-1][y] = new Environment(true, color);
        board[x+2][y] = new Environment(true, color);
        for(int j = -1; j <= 1; j += 2) {
            for (int i = -1; i <= 2; i++) {
                board[x+i][y+j] = new Environment(true, color);
            }
        }
        for(int j= -2; j <= 2; j += 4){
            for(int i = -2; i<= 1; i++){
                board[x+i][y+j] = new Environment(true, color);
            }
        }
        int _x = x - 2;
        board[_x][y-3] = new Environment(true, color);
        board[_x][y+3] = new Environment(true, color);
    }

    private void parts4(Environment[][] board, int x, int y, Paint color){
        for (int i = -3; i <= -2; i++){
            for (int j = -1; j <=1; j++){
                board[x+i][y+j] = new Environment(true, color);
            }
        }
        for (int i = -1; i <= 1; i += 2){
            for (int j = -2; j <= 2; j += 4)
                board[x+i][y+j] = new Environment(true, color);
        }
        board[x][y-3] = new Environment(true, color);
        board[x][y+3] = new Environment(true, color);
        for (int j = -1; j <= 1; j++){
            board[x+2][y+j] = new Environment(true, color);
        }
    }
}
