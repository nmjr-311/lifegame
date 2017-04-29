package lifegame;

/**
 * Created by numajiri on 17/01/03.
 */
public class Cell {
    private boolean isDead;
    private int xCoor;//coordinate x
    private int yCoor;//coordinate y

    //default
    public Cell(){}

    public Cell(int x, int y){
        this(false, x, y);
    }

    public Cell(boolean isDead, int x, int y){
        this.isDead = isDead;
        this.xCoor = x;
        this.yCoor = y;
    }

    //copy constructor
    public Cell(Cell src){
        this.copyFrom(src);
    }

    /**
     * deep copy
     * @return new cell
     */
    @Override
    public Cell clone(){
        return new Cell(this);
    }

    public void copyFrom(Cell src){
        this.isDead = src.isDead;
        this.xCoor = src.xCoor;
        this.yCoor = src.yCoor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x="+xCoor);
        sb.append(", y="+yCoor);
        if (isDead)
            sb.append(", dead");
        else
            sb.append(", alive");
        return sb.toString();
    }

    public boolean isDead() {
        return isDead;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }
}
