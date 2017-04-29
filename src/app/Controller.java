package app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import lifegame.Board;
import lifegame.Environment;
import lifegame.pattern.*;

import java.util.Random;

/**
 * Created by numajiri on 17/01/03.
 */
public class Controller {
    @FXML private Canvas mainCanvas;
    @FXML private Button randomButton;
    @FXML private Button reproduceButton;
    @FXML private Button colButton;
    private Timeline timeLine;
    private Board board;
    private static int CELL_SIZE = 10;
    private static int WAIT_TIME = 150;
    private Random random = new Random();
//    private static Paint BACK_COLOR = Color.rgb(100, 65, 30);
    private static Paint BACK_COLOR = Color.BLACK;

    public Canvas getMainCanvas() {
        return mainCanvas;
    }

    public void clear(){
        clear(false);
    }

    public void clearOnClick(){
        init();
        clear();
    }

    public void clear(Paint color){
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        double width = mainCanvas.getWidth();
        double height = mainCanvas.getHeight();
        gc.setFill(color);
        gc.fillRect(0, 0, width, height);
    }

    public void strokeLine(){
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        double width = mainCanvas.getWidth();
        double height = mainCanvas.getHeight();
        gc.setStroke(Color.GREY);
        for (int row = CELL_SIZE; row < height; row += CELL_SIZE){
            gc.strokeLine(0, row, width, row);
        }
        for (int col = CELL_SIZE; col < width; col += CELL_SIZE){
            gc.strokeLine(col, 0, col, height);
        }
    }

    public void clear(boolean withLine){
        clear(BACK_COLOR);
        if(withLine) strokeLine();
    }

    private void drawCells(){
        clear();

        Environment[][] es = board.getBoard();
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();

        for (int x = 0; x < es.length; x++){
            for (int y = 0; y < es[0].length; y++){
                if (es[x][y].getIsAlive()){
                    gc.setFill(es[x][y].getColor());
                    gc.fillRect(x* CELL_SIZE, y* CELL_SIZE, CELL_SIZE-0.5, CELL_SIZE-0.5);
                }
            }
        }
    }

    public void clickCanvas(MouseEvent e){
        int x = (int)e.getX() / CELL_SIZE;
        int y = (int)e.getY() / CELL_SIZE;
        board.makeNewEnvironment(x, y, true, Color.WHITE);
        drawCells();
    }

    private void doOneIteration(){
        board.doOneIteration();
        drawCells();
    }


    public void init(){
        board = new Board(random, (int)mainCanvas.getWidth() / CELL_SIZE,
                (int)mainCanvas.getHeight() / CELL_SIZE);
    }

    public void start(){
        if(timeLine == null) {
            timeLine = new Timeline(new KeyFrame(Duration.millis(WAIT_TIME),
                    e -> doOneIteration()));
            timeLine.setCycleCount(Timeline.INDEFINITE);
        }
        if(timeLine.getStatus() != Animation.Status.RUNNING) {
//            timeLine = new Timeline(new KeyFrame(Duration.millis(WAIT_TIME),
//                    e -> doOneIteration()));
//            timeLine.setCycleCount(Timeline.INDEFINITE);
            timeLine.play();
        }
    }

    public void stop(){
        if(timeLine != null){
            timeLine.stop();
        }
    }



    public void random(){
        init();
        board.initialize(RandomPattern.getInstance());
        drawCells();
    }

    public void reproduce(){
        init();
        board.initialize(ReproducePattern.getInstance());
        drawCells();
    }

    public void column(){
        init();
        board.initialize(ColumnPattern.getInstance());
        drawCells();
    }

    public void glider(){
        init();
        board.initialize(GliderPattern.getInstance());
        drawCells();
    }

    public void gliderGun(){
        init();
        board.initialize(GliderGunPattern.getInstance());
        drawCells();
    }



}
