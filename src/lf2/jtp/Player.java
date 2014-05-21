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
    public void move_right() {
        pozx+=5;
        rysuj();
    } 
    public void move_left() {
        pozx-=5;
        rysuj();
    }
    public void move_down() {
        pozy+=5;
        rysuj();
    }
    public void move_up() {
        pozy-=5;
        rysuj();
    }
}
