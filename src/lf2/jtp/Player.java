package lf2.jtp;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Player {
    private boolean samowola; // jesli true to steruje komputer;
    private int pozx;
    private int pozy;
    private int stan;
    private int animationdelay = 83;
    public long time;
   
    public ControlPlayer sterowanie;
    
    public boolean prawa = false;
    public boolean lewa = true;
    public boolean dol = false;
    public boolean gora = true;
    
    private int screenHeight = StaticData.screenHeight;
    private int screenWidth = StaticData.screenWidth; 
    
    public static BufferedImage[] obrazek;
    static{
        try {
            obrazek=LoadPicture.wczytaj();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    public Player() {
       
        samowola = false;
        pozx = 30;
        pozy = 30;
        stan = 0;
        sterowanie = new ControlPlayer(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
    }
    public Player(int szer, int wys) {
            samowola = true;
            Random generator = new Random();
                   
            pozx = Math.abs(generator.nextInt() % szer);
            pozy = Math.abs(generator.nextInt() % wys);
  
//        pozx = (int)(Math.random() * rangex);
//        pozy = (int)(Math.random() * rangey);
    }
    public Player(int szer, int wys, ControlPlayer keys) {
            samowola = true;
            sterowanie = keys;
            Random generator = new Random();
                   
            pozx = generator.nextInt() % szer;
            pozy = generator.nextInt() % wys;
  
//        pozx = (int)(Math.random() * rangex);
//        pozy = (int)(Math.random() * rangey);
    }
    public Player(ControlPlayer keys) {
            samowola = false;
            sterowanie = keys;
      
  
//        pozx = (int)(Math.random() * rangex);
//        pozy = (int)(Math.random() * rangey);
    }
    
    
    public void rysuj() { 
       boolean drawImage = StaticData.ekran.drawImage(obrazek[stan], pozx, pozy, null);
    }
    public void moveRight() {
        if(pozx >= StaticData.screenWidth-70) 
                pozx = StaticData.screenWidth-70;
        else 
                pozx+=4;
        rysuj();
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 1)
            stan=0;
            stan++;
        }
    }
   
    public void moveLeft() {
        if(pozx <= -20) 
                pozx = -20;
        else
                pozx-=4;
        rysuj();
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 4 || stan < 3)
            stan=3;
            stan++;
        }
    }
    public void moveDown() {
        if(pozy >= StaticData.screenHeight-70)
                pozy = StaticData.screenHeight-70;
        else
                pozy+=4;
        rysuj();
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 7 || stan < 6)
            stan=6;
            stan++;
        }
    }
    public void moveUp() {
        if(pozy <= -20)
                pozy = -20;
        else 
                pozy-=4;
        rysuj();
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 10 || stan < 9)
            stan=9;
            stan++;
        }
    }
    
    public void setPosition(int x, int y) {
        pozy = x;
        pozy = y;
    }
    
    public void setSamowola(boolean s) {
        samowola = s;
    }
    
    public int getXPosition() {
        return pozx;
    }
    public int getYPosition() {
        return pozy;
    }
    public boolean getSamowola() {
        return samowola;
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
