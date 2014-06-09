package lf2.jtp;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 * Klasa odpowiedzialna za sterowanie graczem
 * 
 */
public class Control implements KeyListener, Obserwowany {
    
    // Trzymanie HashMapy naciśniętych klawiszy 
    private static HashMap<Integer, Boolean> nacisnieteKlawisze = new HashMap<Integer, Boolean>();
    // Lista obserwatorów tej klasy
    private static ArrayList<Obserwator> obserwatorzy = new ArrayList<Obserwator>();

    /**
     *  Dodaje nowego obserwatora - wzorzec projektory Obserwator
     * @param o obserwator
     */
    public void dodajObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    /**
     *  Usuwa obserwatora klasy
     * @param o obserwator do usunięcia
     */
    public void usunObserwatora(Obserwator o) {
        int i = obserwatorzy.indexOf(o);
        obserwatorzy.remove(i);
    }

    /**
     *  Powiadamia wszystkich obserwatorów o zmianach w tej klasie
     * @param press naciśnięty przycisk
     */
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
    
    /**
     *  Sprawdza czy została naciśnięta spacja
     * @return jeśli została naciśnięta spacja zwraca true, w przeciwnym wypadku zwraca false
     */
    public static boolean ifSpace() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_SPACE))
            return true;
        else
            return false;
    }

    /**
     *  Sprawdza czy został naciśnięty przycisk w prawo
     * @return jeśli została naciśnięty przycisk w prawo zwraca true, w przeciwnym wypadku zwraca false
     */
    public static boolean ifRight() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_RIGHT))
            return true;
        else
            return false;
    }

    /**
     *  Sprawdza czy został naciśnięty przycisk w lewo
     * @return jeśli została naciśnięty przycisk w lewo zwraca true, w przeciwnym wypadku zwraca false
     */
    public static boolean ifLeft() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_LEFT))
            return true;
        else
            return false;
    }

    /**
     *  Sprawdza czy został naciśnięty przycisk w górę
     * @return jeśli został naciśnięty przycisk w górę zwraca true, w przeciwnym wypadku zwraca false
     */
    public static boolean ifUp() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_UP))
            return true;
        else
            return false;
    }

    /**
     *  Sprawdza czy został naciśnięty przycisk w dół
     * @return jeśli został naciśnięty przycisk w dół zwraca true, w przeciwnym wypadku zwraca false
     */
    public static boolean ifDown() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_DOWN))
            return true;
        else
            return false;
    }

    /**
     *  Sprawdza czy został naciśnięty przycisk w ESC
     * @return jeśli został naciśnięty przycisk ESC zwraca true, w przeciwnym wypadku zwraca false
     */
    public static boolean ifESC() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_ESCAPE))
            return true;
        else
            return false;
    }   

    /**
     *  Sprawdza czy został naciśnięty przycisk P
     * @return jeśli został naciśnięty przycisk P zwraca true, w przeciwnym wypadku zwraca false
     */
    public static boolean ifP() {
        if(nacisnieteKlawisze.containsKey(KeyEvent.VK_P))
            return true;
        else
            return false;
    }

    /**
     * Zwraca HashMapę naciśniętych klawiszy
     * @return HashMap wszystkich naciśniętych klawiszy w danej chwili
     */
    public static HashMap<Integer, Boolean> getControl() {
        return nacisnieteKlawisze;
    }
     
}
