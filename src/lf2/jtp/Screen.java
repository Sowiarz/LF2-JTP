
package lf2.jtp;

import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;


public class Screen {
    Board plansza1;
    
    Deque<InterfaceWindow> okienka = new ArrayDeque<InterfaceWindow>();
    
    public Screen() {
                   
    }
    
    public void ustawGre() {
        
        plansza1.addPlayer(new ControlPlayer(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_CONTROL));
        plansza1.addPlayer(new ControlPlayer(KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_SPACE));
    }
    
     
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

