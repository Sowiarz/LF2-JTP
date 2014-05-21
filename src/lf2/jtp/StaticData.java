package lf2.jtp;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class StaticData {
    
    // pola startczne do użytku w całej aplikacji
    public static Graphics2D ekran; // trzyma obiekt "g" czyli uchwyt do rysowania
    public static Dimension rozdzielczosc; // można z niego odczytać rozdzielczość
    
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
}
