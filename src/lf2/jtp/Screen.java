
package lf2.jtp;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;


public class Screen {
    Board plansza1;
    public Screen() {
          plansza1 = new Board(2);
          plansza1.addPlayer(new ControlPlayer(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_CONTROL));
          plansza1.addPlayer(new ControlPlayer(KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_SPACE));
        
    }
    
    
    public void odswiez() {
        plansza1.show();
        
    }
    
}

