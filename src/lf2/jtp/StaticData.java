package lf2.jtp;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;


public class StaticData {
   
    // pola startczne do użytku w całej aplikacji
    public static Graphics2D ekran; // trzyma obiekt "g" czyli uchwyt do rysowania
    public static int screenWidth; // szerokosc ekranu
    public static int screenHeight; // wysokość ekranu
    
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
    public static void removaPlayer(int id) {
        gracze.remove(id);
    }
}
