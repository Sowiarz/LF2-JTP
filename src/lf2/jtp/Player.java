package lf2.jtp;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Player {
    private int pozx;
    private int pozy;
    
    public ControlPlayer sterowanie;
    
    public boolean prawa = false;
    public boolean lewa = true;
    public boolean dol = false;
    public boolean gora = true;
    
    private int screenHeight = StaticData.screenHeight;
    private int screenWidth = StaticData.screenWidth; 
    
    public Player() {
        pozx = 30;
        pozy = 30;
        
        sterowanie = new ControlPlayer(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
    }
    public Player(int szer, int wys) {
            Random generator = new Random();
                   
            pozx = generator.nextInt() % szer;
            pozy = generator.nextInt() % wys;
  
//        pozx = (int)(Math.random() * rangex);
//        pozy = (int)(Math.random() * rangey);
    }
    
    public void rysuj() {
        Image img1 = Toolkit.getDefaultToolkit().getImage("mario.png");
        boolean drawImage = StaticData.ekran.drawImage(img1, pozx, pozy, null);
        StaticData.ekran.finalize();
        
       
    }
    public void moveRight() {
        if(pozx >= StaticData.screenWidth-70) 
                pozx = StaticData.screenWidth-70;
        else 
                pozx+=4;
        rysuj();
    } 
    public void moveLeft() {
        if(pozx <= -20) 
                pozx = -20;
        else
                pozx-=4;
        rysuj();
    }
    public void moveDown() {
        if(pozy >= StaticData.screenHeight-70)
                pozy = StaticData.screenHeight-70;
        else
                pozy+=4;
        rysuj();
    }
    public void moveUp() {
        if(pozy <= -20)
                pozy = -20;
        else 
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
    
    // Metody zwracające sterowanie
    
    public int getControlUp() {
        return sterowanie.getUp();
    }
    public int getControlDown() {
        return sterowanie.getDown();
    }
    public int getControlLeft() {
        return sterowanie.getLeft();
    }
    public int getControlRight() {
        return sterowanie.getRight();
    }
}
