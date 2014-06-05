package lf2.jtp;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;


public class StaticData {
   
    // pola startczne do użytku w całej aplikacji
    public static Graphics2D ekran; // trzyma obiekt "g" czyli uchwyt do rysowania
    public static int screenWidth; // szerokosc ekranu
    public static int screenHeight; // wysokość ekranu
    
    // Obiekty odpowiedzialne za obsługę myszy i klawiatury
    
    public static Control klawiatura;
    public static MouseControl mysz;
    
    // Obiekt menu
    public static Menu menu;
    
    // Wielkosc gracza
    
    public static int playerWidth;
    public static int playerHeight;
    
    // Zmienne pola rozgrywki gry - oznaczają marginesy
    public static int x1 = 10;
    public static int y1 = 100;
    public static int x2 = 10;
    public static int y2 = 10;
    
    // listy z używanymi obiektami
    private static ArrayList<Player> gracze = new ArrayList<Player>();
    
    
    private StaticData() {
        
    }
    public static int addPlayer(Player gracz) {
        gracze.add(gracz);
        return gracze.indexOf(gracz);
    }
    public static Player getPlayer(int id) {
        return gracze.get(id);
    }
    public static int getPlayerID(int Player) {
        return gracze.indexOf(Player);
    }
    public static int getNumberOfPlayers() {
        return gracze.size();
    }
    public static void removePlayer(int id) {
        gracze.remove(id);
    }
    public static int IndexOf(Player o) {
        return gracze.indexOf(o);
    }
    // Losowanie danych
    
    public static int losujSzerokosc() {
        return Math.abs((new Random().nextInt(screenWidth-x1-x2-playerWidth))+x1);
    }
    public static int losujWysokosc() {
        return Math.abs((new Random().nextInt(screenHeight-y1-y2-playerHeight))+y1);        
    }
    public static int odlegloscOdPunktow(Point p1, Point p2) {
        
        return (int) Math.sqrt((double)(((p2.getX()-p1.getX())*(p2.getX()-p1.getX()))+((p2.getY()-p1.getY())*(p2.getY()-p1.getY()))));
         
    }
    public static int obliczPolozenieSrodkowe(int all, int length) {
        int e,temp;
        e=(int)all/2;
        temp=(int)length/2;
        return e-temp;
    }
}
