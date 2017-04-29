package lifegame;

import com.sun.javafx.collections.ImmutableObservableList;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lifegame.pattern.AbstractPattern;
import utility.RandColor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by numajiri on 17/01/03.
 */
public class Board {
    private int xSize;
    private int ySize;
    private Environment[][] board;//ring
    private Random rand;
    static private double MUATNT_RATE = 0.999;

   public Board(Random random, int xs, int ys){
       this.rand = random;
        xSize = xs;
        ySize = ys;
        board = new Environment[xSize][ySize];
        for (int i = 0; i < xSize; i++)
            for (int j = 0; j < ySize; j++)
                board[i][j] = new Environment(false);
    }

    public void doOneIteration(){
        updateEnvironments();
        updateDeadOrAlive();
    }

    private void updateDeadOrAlive(){
        Arrays.stream(board).forEach(es ->
                Arrays.stream(es).forEach(e -> e.updateSelf()));
    }

    private void updateEnvironments(){
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                board[x][y].setCells(calcEnvs(x, y));
            }
        }
    }

    private boolean[] calcEnvs(int col, int row){
        boolean[] env = new boolean[9];
        int c = 0;
        for(int dy = -1; dy <= 1; dy++){
            for(int dx = -1; dx <= 1; dx++){
                if(dx == 0 && dy == 0) {
                    env[c++] = false;
                    continue;
                }
                int nx = col + dx;
                int ny = row + dy;
                //補正
                nx = nx < 0 ? xSize-1 : nx == xSize ? 0 : nx;
                ny = ny < 0 ? ySize-1 : ny == ySize ? 0 : ny;
                Environment e = board[nx][ny];
                env[c++] = e.getIsAlive();
                if(e.getIsAlive()) {
                    if (rand.nextDouble() > MUATNT_RATE) {
                        board[col][row].setColor(RandColor.calcRandomRGB(rand));
                    } else {
                        board[col][row].setColor(e.getColor());
                    }
                }
            }
        }
        return env;
    }

    public void initialize(AbstractPattern p){
        p.initialize(this.board, rand, board.length*board[0].length);
        updateEnvironments();
    }

    public Environment[][] getBoard() {
        return board;
    }

    public void makeNewEnvironment(int x, int y, boolean isAlive, Color p){
        int nx = x < 0 ? 0 : x > board.length ? board.length - 1 : x;
        int ny = y < 0 ? 0 : y > board[0].length ? board[0].length - 1: y;
        board[nx][ny] = new Environment(isAlive, p);
    }

    public static void main(String[] args) {
        Board b = new Board(new Random(), 5, 5);
//        b.board[2][2] = new Environment(true);
        b.board[4][4] = new Environment(true);
        b.board[4][1] = new Environment(true);
        b.board[4][0] = new Environment(true);
        b.updateEnvironments();
        print(b);
        b.doOneIteration();
        System.out.println();
        print(b);
        System.out.println();
        b.doOneIteration();
        print(b);
        System.out.println();
    }

    private static void print(Board b){
        for(Environment[] es:b.board){
            for(Environment e:es)
                if(e.getIsAlive())
                    System.out.print("* ");
                else
                    System.out.print(". ");
            System.out.println();
        }
    }
}
