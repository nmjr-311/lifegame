package lifegame.pattern;

import lifegame.Environment;

import java.util.Random;

/**
 * Created by numajiri on 17/01/04.
 */
public abstract class AbstractPattern {
    abstract public void initialize(Environment[][] board, Random r, int canvasSize);
}
