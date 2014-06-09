package lf2.jtp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Klasa odpowiedzialna za kliknięcia myszką
 * 
 */
public class MouseControl implements Obserwowany, MouseListener {
    private static ArrayList<Obserwator> obserwatorzy = new ArrayList<Obserwator>();

    /**
     * Dodanie nowego obserwatora kliknięć
     * @param o Klasa obserwująca
     */
    public void dodajObserwatora(Obserwator o) {
        try {
            obserwatorzy.add(o);
        } 
        catch (Exception e) {
            System.out.println("Nie można dodać!");
        }
    }

    /**
     * Usunięcie obserwatora
     * @param o Obserwator
     */
    public void usunObserwatora(Obserwator o) {
        int i = obserwatorzy.indexOf(o);
        obserwatorzy.remove(i);
    }

    /**
     * powiadamianie obserwatorów o kliknięciu
     * @param press Naciśnięcie klawisza myszki
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
    public void mouseClicked(MouseEvent e) {
        powiadamiajObserwatorow(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
