
package lf2.jtp;

import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Klasa odpowiedzialna za wyświetlanie gry na ekranie
 * 
 */
public class Screen {
    Board plansza1;
    
    Deque<InterfaceWindow> okienka = new ArrayDeque<InterfaceWindow>();
    
    /**
     * Konstruktor
     */
    public Screen() {
                   
    }
    
    /**
     * Metoda odpowiedzialna za ustawienia parametrów gry - dodanie graczy
     */
    public void ustawGre() {
        
        plansza1.addPlayer(new ControlPlayer(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_CONTROL));
        plansza1.addPlayer(new ControlPlayer(KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_SPACE));
    }
    
    /**
     * Metoda odpowiedzialna za wyświetlenie gry na ekranie
     */
    public void odswiez() {
        
        switch (StaticData.getReady()) {
            case 0:
                Ui.rysujMenuGlowne();
                StaticData.menu.oknoStartowe();
                break; 
            case 1:
                Ui.rysujMenuGlowne();
                plansza1 = Board.getSingleton();
                plansza1.addEnemy(1);
                ustawGre();
                StaticData.setReadyGame(2);
                break;
            case 2:
                plansza1.show();
                StaticData.menu.oknoZNazwa();
                             
                break;               
        }

        
    }
    
}

