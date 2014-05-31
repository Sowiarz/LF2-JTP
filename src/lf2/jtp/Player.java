    package lf2.jtp;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Player {
    Destination cele = new Destination();
    private int celeDelay = 0; // Stworzone aby gracz miał jakieś szanse z komputerem
    
    private boolean samowola; // jesli true to steruje komputer;
    private int pozx;
    private int pozy;
    private int stan = 0;
    public long time;
    
    // Dane gracza
    private int HP;
    private String imie;
   
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
        while(czyKolizja()) {
            this.setPosition(StaticData.losujSzerokosc(), StaticData.losujWysokosc());
        }
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
        HP = 100;
    }
    
    public Player(ControlPlayer keys) {
        this(StaticData.losujSzerokosc(), StaticData.losujWysokosc(), keys);
        while(czyKolizja()) {
            this.setPosition(StaticData.losujSzerokosc(), StaticData.losujWysokosc());
        }
        samowola = false;
    }
      
    
    public void rysuj() {
       pokazHP();
       boolean drawImage = StaticData.ekran.drawImage(obrazek[stan], pozx, pozy, null);
       
    }
    
    public void pokazHP() {
        String temp = String.valueOf(HP);
        temp = "HP:" + temp;
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 12);
        StaticData.ekran.setFont(czcionkaMenu);
        StaticData.ekran.drawString(temp, pozx+15, (pozy-10));
    }
    
    // Ruchy
    public void moveRight() {
        if(pozx >= StaticData.screenWidth-StaticData.x2-StaticData.playerWidth) 
                pozx = StaticData.screenWidth-StaticData.x2-StaticData.playerWidth;
        else 
                pozx+=4;
        if(czyKolizja())
            pozx-=4;

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
        if(czyKolizja())
            pozx+=4;

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
        if(czyKolizja())
            pozy-=4;

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
        if(czyKolizja())
            pozy+=4;
        rysuj();
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 10 || stan < 9)
            stan=9;
            stan++;
        }
    }
    
    // Walka
    
    public void uderz() {
        int me = StaticData.IndexOf(this);
        for(int i = 0; i < StaticData.getNumberOfPlayers(); i++) {
            if(i != me) {
                Point przeciwnik = StaticData.getPlayer(i).getPosition();
                Point ja = new Point(pozx, pozy);
                if(StaticData.odlegloscOdPunktow(ja, przeciwnik) < StaticData.playerWidth + 20) {
                    StaticData.getPlayer(i).decreaseHP();
                }
            }
        }
    }
    
    private void uderzLewo() {
           
    }
    
    private void uderzPrawo() {
        
    }
    
    // Dojście do wyznaczonego celu
    public void doCelu() {
        try {
        if(StaticData.odlegloscOdPunktow(new Point(pozx, pozy), cele.getDestination()) < StaticData.playerWidth+5)
            cele.deleteAllDestinations();
        }
        catch (Exception x) {
            // nic nie rób
        }
        
        if(!cele.isEmpty()) {

            if(celeDelay < 3) {
                celeDelay++;
            }
            else {
                               
                int x = cele.getDestination().getX();
                int y = cele.getDestination().getY();
                
                if(pozx > x)
                    moveLeft();
                if(pozx < x) 
                    moveRight();
                if(pozy > y)
                    moveUp();
                if(pozy < y)
                    moveDown();

                if(cele.getNumber() > 16)
                    cele.deleteAllDestinations();
                celeDelay = 0;
            }
        }
    }

    
    // Dodanie nowego celu
    public void dodajCel(Point p) {
        cele.addDestination(p);
    }
        
    // Sprawdzanie kolizji
    private boolean czyKolizja() {
        int me = StaticData.IndexOf(this);
        for(int i = 0; i < StaticData.getNumberOfPlayers(); i++) {
            if(i != me) {                
                int x1 = StaticData.getPlayer(i).getXPosition();
                int y1 = StaticData.getPlayer(i).getYPosition();
                if((pozx < x1+StaticData.playerWidth) && (pozx > x1-StaticData.playerWidth) && (pozy < y1+StaticData.playerHeight) && (pozy > y1-StaticData.playerHeight))
                    return true;
            }
        }
        return false;
    }
    
    // Życie
    
    public void decreaseHP() {
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            HP = HP - 1;
        }       
    }
    
    // Ustawienia
    public void setPosition(int x, int y) {
        pozy = x;
        pozy = y;
    }
    
    public void setName(String i) {
        imie = i;
    }
    
    public void setSamowola(boolean s) {
        samowola = s;
    }
    public void setHP(int i) {
        HP = i;
    }
    
    // Sprawdzanie informacji
    
    public int getXPosition() {
        return pozx;
    }
    public int getYPosition() {
        return pozy;
    }
    public Point getPosition() {
        return new Point(pozx, pozy);
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
    public int getControlHit() {
        return sterowanie.getHit();
    }
    
    // Metody zwracające dane playera 
    
    public String getName() {
        return imie;
    }
    
    public int getHP() {
        return HP;
    }
}
