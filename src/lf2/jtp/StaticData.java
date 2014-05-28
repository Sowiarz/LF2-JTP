package lf2.jtp;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;


public class StaticData {
   
    // pola startczne do użytku w całej aplikacji
    public static Graphics2D ekran; // trzyma obiekt "g" czyli uchwyt do rysowania
    public static int screenWidth; // szerokosc ekranu
    public static int screenHeight; // wysokość ekranu
    
    // Wielkosc gracza
    
    public static int playerWidth;
    public static int playerHeight;
    
    // Zmienne pola rozgrywki gry
    public static int x1 = 10;
    public static int y1 = 100;
    public static int x2; // ustawiane w klasie Game
    public static int y2; // ustawiane w klasie Game
    
    
    
    // zmienne testowe
    public static boolean odbijanie = true;
    
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
        return Math.abs((new Random().nextInt((x2-x1)+1))+x1);
    }
    public static int losujWysokosc() {
        return Math.abs((new Random().nextInt((y2-y1)+1))+y1);        
    }
}
