    package lf2.jtp;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa gracza
 * 
 */
public class Player {
    Destination cele = new Destination();
    private ControlPlayer sterowanie;
    
    LoadPicture picture = new LoadPicture();
    
    
    private int celeDelay = 0; // Stworzone aby gracz miał jakieś szanse z komputerem
    
    private boolean samowola; // jesli true to steruje komputer;
    private int pozx;
    private int pozy;

    private long time;
    private long lastTimeHit;
    
    // Dane gracza
    private int HP;
    private String imie;
  
    // Konstruktory
 
    /**
     * Konstruktor nowego gracza
     */
        public Player() { 
        this(StaticData.losujSzerokosc(),StaticData.losujWysokosc(), new ControlPlayer());
        while(czyKolizja()) {
            this.setPosition(StaticData.losujSzerokosc(), StaticData.losujWysokosc());
        }
        samowola = true;
    }
    
    /**
     * Konstruktor nowego gracza
     * @param x położenie gracza - x
     * @param y położenie gracza - y
     */
    public Player(int x, int y) {
        this(x, y, new ControlPlayer());
        samowola = true;
    }
    
    /**
     * Konstruktor nowego gracza
     * @param x położenie gracza - x
     * @param y położenie gracza - y
     * @param keys sterowanie gracza
     */
    public Player(int x, int y, ControlPlayer keys) {
        samowola = true;
        sterowanie = keys;
        pozx = x;
        pozy = y;
        HP = 100;
    }
    
    /**
     * Konstruktor nowego gracza
     * @param keys sterowanie gracza
     */
    public Player(ControlPlayer keys) {
        this(StaticData.losujSzerokosc(), StaticData.losujWysokosc(), keys);
        while(czyKolizja()) {
            this.setPosition(StaticData.losujSzerokosc(), StaticData.losujWysokosc());
        }
        samowola = false;
    }
      
    /**
     * Rysowanie gracza w polu gry
     */
    public void rysuj() {
       pokazHP();
       picture.setState(); // jeśli gracz wykonał uderzenie to przywraca jego stan sprzed niego
       boolean drawImage = StaticData.ekran.drawImage(picture.getImage(), pozx, pozy, null);
       
    }
    
    /**
     * Pokazanie napisu z ilością życia gracza (HP)
     */
    public void pokazHP() {
        String temp = String.valueOf(HP);
        temp = "HP:" + temp;
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 12);
        StaticData.ekran.setColor(new Color(255, 0, 0));
        StaticData.ekran.setFont(czcionkaMenu);
        StaticData.ekran.drawString(temp, pozx+15, (pozy-10));
    }
    
    // Ruchy

    /**
     * Przesunięcie gracza w prawo
     */
        public void moveRight() {
        if(pozx >= StaticData.screenWidth-StaticData.x2-StaticData.playerWidth) 
                pozx = StaticData.screenWidth-StaticData.x2-StaticData.playerWidth;
        else 
                pozx+=3;
        if(czyKolizja())
            pozx-=4;
        
        picture.moveRight();
        rysuj();

    }
   
    /**
     * Przesunięcie gracza w lewo
     */
    public void moveLeft() {
        if(pozx <= StaticData.x1) 
                pozx = StaticData.x1;
        else
                pozx-=3;
        if(czyKolizja())
            pozx+=4;
        
        picture.moveLeft();
        
        rysuj();
    }

    /**
     * Przesunięcie gracza w dół
     */
    public void moveDown() {
        if(pozy >= StaticData.screenHeight-StaticData.y2-StaticData.playerHeight)
                pozy = StaticData.screenHeight-StaticData.y2-StaticData.playerHeight;
        else
                pozy+=3;
        if(czyKolizja())
            pozy-=4;
        
        picture.moveDown();

        rysuj();
        
    }

    /**
     * Przesunięcie gracza w górę
     */
    public void moveUp() {
        if(pozy <= StaticData.y1)
                pozy = StaticData.y1;
        else 
                pozy-=3;
        if(czyKolizja())
            pozy+=4;
        
        picture.moveUp();
      
        rysuj();
        
    }
    
    // Walka
    
    /**
     * Pokazanie uderzenia gracza
     */
        
    public void showHit() {
        picture.uderz();
    }
    
    /**
     * Schowanie ręki po uderzeniu gracza
     */
    public void hideHit() {
        picture.setState();
    }
    
    /**
     * Uderzenie gracza będącego w zasięgu
     */
    public void uderz() {
        
        int me = StaticData.IndexOf(this);
        time = System.currentTimeMillis();
        for(int i = 0; i < StaticData.getNumberOfPlayers(); i++) {
            if(i != me) {
                Point przeciwnik = StaticData.getPlayer(i).getPosition();
                Point ja = new Point(pozx, pozy);
                if(picture.getStrona() == 1)
                if(StaticData.odlegloscOdPunktow(ja, przeciwnik) < StaticData.playerWidth + 20 && StaticData.getPlayer(i).pozx-StaticData.getPlayer(me).pozx > 0) {
                    if (lastTimeHit + 300 < System.currentTimeMillis()) {
                        lastTimeHit = System.currentTimeMillis();
                            showHit();
                            StaticData.getPlayer(i).decreaseHP();
                            Sound.play();
                            rysuj();
                            picture.setState();
                    } 
                    
                }
                if(picture.getStrona() == -1)
                if(StaticData.odlegloscOdPunktow(ja, przeciwnik) < StaticData.playerWidth + 20 && StaticData.getPlayer(i).pozx-StaticData.getPlayer(me).pozx < 0) {
                    if (lastTimeHit + 300 < System.currentTimeMillis()) {
                        lastTimeHit = System.currentTimeMillis();
                            showHit();
                            StaticData.getPlayer(i).decreaseHP();
                            Sound.play();
                            rysuj();
                            picture.setState();
                    } 
                }
            }
        }
    }
    
    /**
     * Schowanie ręki po uderzeniu gracza
     */
    public void getBackHand() { // cofa cios
        picture.setState();
    }

    
    // Dojście do wyznaczonego celu

    /**
     * Poruszanie się gracza do wyznaczonego celu
     */
        public void doCelu() {
        try {
        int me = StaticData.IndexOf(this);
        if(StaticData.odlegloscOdPunktow(new Point(pozx, pozy), cele.getDestination()) < StaticData.playerHeight + 4)
            if(Math.abs(StaticData.getPlayer(me).pozx - cele.getDestination().getX()) < StaticData.playerWidth + 4)
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

    /**
     * Dodanie nowego celu do ruchów gracza
     * @param p punkt celu
     */
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
    
    /**
     * Zmiejszenie ilości życia gracza (HP)
     */
        
    public void decreaseHP() {
        HP = HP - 1;      
    }
    
    // Ustawienia

    /**
     * Ustawia nową pozycje gracza
     * @param x współrzędna X  
     * @param y współrzędna Y
     */
        public void setPosition(int x, int y) {
        pozy = x;
        pozy = y;
    }
    
    /**
     * Ustawia nowe imię gracza
     * @param i imię
     */
    public void setName(String i) {
        imie = i;
    }
    
    /**
     * Ustawia nowe sterowanie gracza
     * @param o sterowanie
     */
    public void setControl(ControlPlayer o) {
        sterowanie = o;
    }
    
    /**
     * Zmienia ustawienia gracza 
     * @param s jeśli true to graczem gra komputer, jeśli false to graczem gra użytkownik
     */
    public void setSamowola(boolean s) {
        samowola = s;
    }

    /**
     * Ustawia nową wartość HP dla gracza
     * @param i HP
     */
    public void setHP(int i) {
        HP = i;
    }
    
    // Sprawdzanie informacji
    
    /**
     * Zwraca współrzędna X pozycji gracza
     * @return pozycja X na mapie
     */
        
    public int getXPosition() {
        return pozx;
    }

    /**
     * Zwraca współrzędna Y pozycji gracza
     * @return pozycja Y na mapie
     */
    public int getYPosition() {
        return pozy;
    }

    /**
     * Zwraca Punkt oddający pozycje gracza w danym momencie
     * @return pozycja gracza
     */
    public Point getPosition() {
        return new Point(pozx, pozy);
    }

    /**
     * Sprawdza czy gracz jest komputerem czy użytkownikiem
     * @return jeśli true to graczem gra komputer, jeśli false to graczem gra użytkownik
     */
    public boolean getSamowola() {
        return samowola;
    }
    
    // Metody zwracające sterowanie
    
    /**
     * Zwraca jaki klawisz jest używany do poruszania się w górę
     * @return klawisz
     */
        
    public int getControlUp() {
        return sterowanie.getUp();
    }

    /**
     * Zwraca jaki klawisz jest używany do poruszania się w dół
     * @return klawisz
     */
    public int getControlDown() {
        return sterowanie.getDown();
    }

    /**
     * Zwraca jaki klawisz jest używany do poruszania się w lewo
     * @return klawisz
     */
    public int getControlLeft() {
        return sterowanie.getLeft();
    }

    /**
     * Zwraca jaki klawisz jest używany do poruszania się w prawo
     * @return klawisz
     */
    public int getControlRight() {
        return sterowanie.getRight();
    }

    /**
     * Zwraca jaki klawisz jest używany do uderzenia
     * @return klawisz
     */
    public int getControlHit() {
        return sterowanie.getHit();
    }
    
    // Metody zwracające dane playera 
    
    /**
     * Zwraca imię gracza
     * @return imię
     */
        
    public String getName() {
        return imie;
    }
    
    /**
     * Zwraca pozostałą ilość życia gracza
     * @return ilośc życia (HP)
     */
    public int getHP() {
        return HP;
    }
    
    /**
     * Zwraca w jakim stanie jest gracz - obrazek
     * @return numer obrazka który jest wyświetlany na ekranie
     */
    public int getPictureState() {
        return picture.getState();
    }

    /**
     * Zwraca czas ostatniego wykonanego uderzenia gracza
     * @return czas
     */
    public long getLastTimeHit() {
        return time;
    }
}
