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
    private int stan = 0;
    public long time;
   
    public ControlPlayer sterowanie;
    
    public boolean prawa = false;
    public boolean lewa = true;
    public boolean dol = false;
    public boolean gora = true;
    
    
    public static BufferedImage[] obrazek;
    static {
        try {
            obrazek=LoadPicture.wczytaj();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    public Player() { 
        this(StaticData.losujSzerokosc(),StaticData.losujWysokosc(), new ControlPlayer());
        samowola = true;
    }
    
    public Player(int x, int y) {
        this(x, y, new ControlPlayer());
        samowola = true;
    }
    
    public Player(int x, int y, ControlPlayer keys) {
        samowola = true;
        sterowanie = keys;
        pozx = x;
        pozy = y;
    }
    
    public Player(ControlPlayer keys) {
        this(StaticData.losujSzerokosc(), StaticData.losujWysokosc(), keys);
        samowola = false;
    }
    

    
    
    public void rysuj() { 
       boolean drawImage = StaticData.ekran.drawImage(obrazek[stan], pozx, pozy, null);
       
       // TESTY
       if(czyKolizja())
           StaticData.ekran.drawString("Kolizja!", 60, 60);
    }
    
    // Ruchy
    public void moveRight() {
        if(pozx >= StaticData.screenWidth-StaticData.x2-StaticData.playerWidth) 
                pozx = StaticData.screenWidth-StaticData.x2-StaticData.playerWidth;
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
        if(pozx <= StaticData.x1) 
                pozx = StaticData.x1;
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
        if(pozy >= StaticData.screenHeight-StaticData.y2-StaticData.playerHeight)
                pozy = StaticData.screenHeight-StaticData.y2-StaticData.playerHeight;
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
        if(pozy <= StaticData.y1)
                pozy = StaticData.y1;
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
    
    private boolean czyKolizja() {
        int me = StaticData.IndexOf(this);
        for(int i = 0; i < StaticData.getNumberOfPlayers(); i++) {
            if(i != me) {                
                int x1 = StaticData.getPlayer(i).getXPosition();
                int y1 = StaticData.getPlayer(i).getYPosition();
                if((pozx < x1+StaticData.playerWidth) && (pozx > x1)&& (pozy < y1+StaticData.playerHeight) && (pozy > y1))
                    return true;
            }
        }
        return false;
    }
    
    // Ustawienia
    public void setPosition(int x, int y) {
        pozy = x;
        pozy = y;
    }
    
    public void setSamowola(boolean s) {
        samowola = s;
    }
    
    // Sprawdzanie informacji
    
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
