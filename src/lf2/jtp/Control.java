package lf2.jtp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Control extends MouseAdapter implements KeyListener {
    
    // Trzymanie HashMapy naciśniętych klawiszy 
    private static HashMap<Integer, Boolean> nacisnieteKlawisze = new HashMap<Integer, Boolean>();
    

    public void mousePressed(MouseEvent e) {
          
    }

    @Override
    public void keyTyped(KeyEvent e) {
              
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        nacisnieteKlawisze.put(keyCode, true);
        
        if(ifSpace())
            StaticData.odbijanie = !StaticData.odbijanie; // włączanie i wyłączanie odbijania od ścian
        if(ifESC())
            System.exit(1); // Zamknięcie na przycisk ESC

        // System.out.println(e.getKeyCode()); // pokazuje kod naciśniętego klawisza w konsoli
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(nacisnieteKlawisze.containsKey(keyCode))
                    nacisnieteKlawisze.remove(keyCode);

    }
    
    public static boolean ifSpace() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_SPACE))
            return true;
        else
            return false;
    }
    public static boolean ifRight() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_RIGHT))
            return true;
        else
            return false;
    }
    public static boolean ifLeft() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_LEFT))
            return true;
        else
            return false;
    }
    public static boolean ifUp() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_UP))
            return true;
        else
            return false;
    }
    public static boolean ifDown() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_DOWN))
            return true;
        else
            return false;
    }
    public static boolean ifESC() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_ESCAPE))
            return true;
        else
            return false;
    }       
     
}
