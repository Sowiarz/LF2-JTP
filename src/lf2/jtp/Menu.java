package lf2.jtp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

public class Menu implements Obserwator {
    Window okno1;
    
    public Menu() {
        
    }
    
    public void pokazInfo() {
        okno1 = new Window(200, 200);
        okno1.pokazOkno();
    }

    public void update(Object o) {
        if(o instanceof MouseEvent) {
            MouseEvent t = (MouseEvent)o;
            
        }
            
    }
    
}
