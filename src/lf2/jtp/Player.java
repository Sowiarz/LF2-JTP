package lf2.jtp;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player {
    private int pozx;
    private int pozy;
    
    public Player() {
        pozx = 30;
        pozy = 30;
    }
    public void rysuj() {
        Image img1 = Toolkit.getDefaultToolkit().getImage("mario.png");
        boolean drawImage = StaticData.ekran.drawImage(img1, pozx, pozy, null);
        StaticData.ekran.finalize();
       
    }
    public void moveRight() {
        pozx+=4;
        rysuj();
    } 
    public void moveLeft() {
        pozx-=4;
        rysuj();
    }
    public void moveDown() {
        pozy+=4;
        rysuj();
    }
    public void moveUp() {
        pozy-=4;
        rysuj();
    }
    public void setPosition(int x, int y) {
        pozy = x;
        pozy = y;
    }
    public int getXPosition() {
        return pozx;
    }
    public int getYPosition() {
        return pozy;
    }
}
