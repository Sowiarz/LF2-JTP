package lf2.jtp;

import java.awt.event.MouseEvent;

public class Menu implements Obserwator {
    Window okno1;
    
    public Menu() {
        
    }
    
    public void pokazPause() {
        okno1 = new Window(100, 50);
        okno1.oknoPause();
    }
    public void oknoStartowe() {
        okno1 = new Window(130, 50);
        okno1.oknoStart();
    }
    public boolean ifWindowClicked(Point p) {
        return okno1.ifWindowClicked(p);
    }

    public void update(Object o) {
        if(o instanceof MouseEvent) {
            MouseEvent t = (MouseEvent)o;
            if(ifWindowClicked(new Point(t.getX(), t.getY()))) {
                StaticData.setReadyGame(1);
            }
        }
            
    }
    
}
