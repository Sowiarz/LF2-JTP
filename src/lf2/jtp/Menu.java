package lf2.jtp;

import java.awt.event.MouseEvent;

/**
 * Klasa odpowiedzialna za tworzenie okienek w grze
 *
 */
public class Menu implements Obserwator {
    Window okno1;
    
    /**
     * Konstruktor klasy
     */
    public Menu() {
        
    }
    
    /**
     * Pokazuje okienko z napisem Pause
     */
    public void pokazPause() {
        okno1 = new Window(100, 50);
        okno1.oknoPause();
    }

    /**
     * Pokazuje okienko startowe z przyciskiem "Nowa Gra"
     */
    public void oknoStartowe() {
        okno1 = new Window(383, 58);
        okno1.oknoStart();
    }

    /**
     * Sprawdza czy okienko zostało kliknięte
     * @param p Punkt kliknięcia
     * @return jeśli zostało trafione okienko zwraca true, w przeciwnym razie false
     */
    public boolean ifWindowClicked(Point p) {
        return okno1.ifWindowClicked(p);
    }
    
    /**
     * Wyświetla logo gry
     */
    public void oknoZNazwa() {
        okno1 = new Window(10, 10, 150, 50);
        okno1.oknoZNazwa();
    }

    /**
     * Metoda pochodząca z wzorca Obserwator
     * @param o kliknięcia myszką
     */
    public void update(Object o) {
        if(o instanceof MouseEvent) {
            MouseEvent t = (MouseEvent)o;
            if(ifWindowClicked(new Point(t.getX(), t.getY()))) {
                if(StaticData.getReady() != 2)
                    StaticData.setReadyGame(1);
            }
        }
            
    }
    
}
