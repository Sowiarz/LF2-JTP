package lf2.jtp;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Control implements KeyListener, Obserwowany {
    
    // Trzymanie HashMapy naciśniętych klawiszy 
    private static HashMap<Integer, Boolean> nacisnieteKlawisze = new HashMap<Integer, Boolean>();
    // Lista obserwatorów tej klasy
    private static ArrayList<Obserwator> obserwatorzy = new ArrayList<Obserwator>();

    public void dodajObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    public void usunObserwatora(Obserwator o) {
        int i = obserwatorzy.indexOf(o);
        obserwatorzy.remove(i);
    }

    public void powiadamiajObserwatorow(Object press) {
        try {
            for(Obserwator o : obserwatorzy) {
                o.update(press);
            }
        }
        catch (Exception e) {
           //System.out.println("Wystąpił problem z powiadomieniem obserwatorów!");
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
              
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        nacisnieteKlawisze.put(keyCode, true);
        powiadamiajObserwatorow(e);
        
        if(ifESC())
            System.exit(1); // Zamknięcie na przycisk ESC
        if(ifP()) 
            StaticData.setPause();

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
    public static boolean ifP() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_P))
            return true;
        else
            return false;
    }
    public static HashMap<Integer, Boolean> getControl() {
        return nacisnieteKlawisze;
    }
     
}
