package codewars;

import java.util.Arrays;
import java.util.LinkedList;

// https://www.codewars.com/kata/534e01fbbb17187c7e0000c6/train/java

/*

Your task, is to create a NxN spiral with a given size.

For example, spiral with size 5 should look like this:

00000
....0
000.0
0...0
00000
and with the size 10:

0000000000
.........0
00000000.0
0......0.0
0.0000.0.0
0.0..0.0.0
0.0....0.0
0.000000.0
0........0
0000000000
Return value should contain array of arrays, of 0 and 1, for example for given size 5 result should be:

[[1,1,1,1,1],[0,0,0,0,1],[1,1,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Because of the edge-cases for tiny spirals, the size will be at least 5.

General rule-of-a-thumb is, that the snake made with '1' cannot touch to itself.

 */
public class Spiralizor {

    public static int[][] spiralize(int size) {
        Spiral spiral = new Spiral(size);
        return spiral.getCells();
    }
}

class Spiral {

    private int[][] cells;
    private int size;

    private int x;
    private int y;
    private LimitedQueue<Coord> lastTwo = createQueue(2);
    private LimitedQueue<Coord> lastTurningPoint = createQueue(1);
    private Moving moving;

    public Spiral(int size) {
        this.size = size;
        cells = new int[size][size];
        draw3InitialMoves();
        moving.move();
    }

    public void draw3InitialMoves() {
        Arrays.fill(cells[0], 1);

        for (int i = 0; i < cells.length; i++) {
            int[] row = cells[i];
            row[size - 1] = 1;
        }

        Arrays.fill(cells[size - 1], 1);
        x = 0;
        y = size - 1;
        moving = new MovingUp(this);
    }

    public boolean rollOneBack() {
        Coord last = lastTwo.getLast();

        cells[y][x] = 0;
        x = last.getX();
        y = last.getY();
        lastTwo.removeLast();

        Coord lastTP = null;
        if (lastTurningPoint.size() > 0) {
            lastTP = lastTurningPoint.getFirst();

            if (isSameAsLastTP(lastTP)) {
                return true;
            }
        }

        lastTurningPoint.add(new Coord(x, y));
        return false;
    }

    public boolean isSameAsLastTP(Coord lastTP) {
        return lastTP.getX() == x && lastTP.getY() == y;
    }

    public LimitedQueue<Coord> createQueue(int limit) {
        return new LimitedQueue<>(limit);
    }

    public int[][] getCells() {
        return cells;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeXY(int deltaX, int deltaY) {
        this.x = x + deltaX;
        this.y = y + deltaY;
    }

    public boolean checkNext(int deltaX, int deltaY) {
        return cells[y + deltaY][x + deltaX] == 1;
    }

    public void saveStep() {
        lastTwo.add(new Coord(x, y));
    }

    public void doStep() {
        cells[y][x] = 1;
    }

    public Moving getMoving() {
        return moving;
    }

    public void setMoving(Moving moving) {
        this.moving = moving;
    }

    public int getSize() {
        return size;
    }

    public void doMove(int deltaX, int deltaY) {
        saveStep();
        changeXY(deltaX, deltaY);
        doStep();
    }
}

class LimitedQueue<E> extends LinkedList<E> {
    private int limit;

    public LimitedQueue(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean add(E o) {
        super.add(o);
        while (size() > limit) { super.remove(); }
        return true;
    }

    @Override
    public E removeLast() {
        super.removeLast();
        return null;
    }

}

class Coord {
    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

abstract class Moving {

    protected Spiral spiral;
    protected boolean condition;
    protected int deltaX;
    protected int deltaY;

    public Moving(Spiral spiral) {
        this.spiral = spiral;
    }

    abstract void setNext();

    public boolean move() {
        boolean didTouch = false;
        while (!didTouch && condition) {
            didTouch = moveOneStep();
        }
        if (didTouch) {
            setNext();
            boolean rollOneBack = spiral.rollOneBack();
            if (rollOneBack) {
                return true;
            }
            spiral.getMoving().move();
        }
        return false;
    }

    public boolean moveOneStep() {
        if (spiral.checkNext(deltaX, deltaY)) {
            return true;
        }
        spiral.doMove(deltaX, deltaY);
        return false;
    }
}

class MovingUp extends Moving {

    public MovingUp(Spiral spiral) {
        super(spiral);
        condition = spiral.getY() > 0;
        deltaX =  0;
        deltaY = -1;
    }

    @Override
    void setNext() {
        spiral.setMoving(new MovingRight(spiral));
    }
}

class MovingRight extends Moving {

    public MovingRight(Spiral spiral) {
        super(spiral);
        condition = spiral.getX() < spiral.getSize() - 1;
        deltaX =  1;
        deltaY =  0;
    }

    @Override
    void setNext() {
        spiral.setMoving(new MovingDown(spiral));
    }
}

class MovingDown extends Moving {

    public MovingDown(Spiral spiral) {
        super(spiral);
        condition = spiral.getY() < spiral.getSize() - 1;
        deltaX =  0;
        deltaY =  1;
    }

    @Override
    void setNext() {
        spiral.setMoving(new MovingLeft(spiral));
    }
}

class MovingLeft extends Moving {

    public MovingLeft(Spiral spiral) {
        super(spiral);
        condition = spiral.getX() > 0;
        deltaX = -1;
        deltaY =  0;
    }

    @Override
    void setNext() {
        spiral.setMoving(new MovingUp(spiral));
    }
}