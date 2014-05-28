
package lf2.jtp;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class ControlPlayer {
    private int Left;
    private int Right;
    private int Down;
    private int Up;
    
    
    public ControlPlayer(int r, int l, int u, int d) {
        Left = l;
        Down = d;
        Right = r;
        Up = u;
    }
    public ControlPlayer() {
        this(0, 0, 0, 0);
    }
    public void setUp(int i) {
        Up = i;
    }
    public void setDown(int i) {
        Down = i;
    }
    public void setRight(int i) {
        Right = i;
    }
    public void setLeft(int i) {
        Left = i;
    }
    public int getUp() {
        return Up;
    }
    public int getDown() {
        return Down;
    }
    public int getLeft() {
        return Left;
    }
    public int getRight() {
        return Right;
    }

    
}
