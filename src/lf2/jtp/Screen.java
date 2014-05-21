
package lf2.jtp;

import java.awt.Dimension;
import java.awt.Graphics2D;

public class Screen {
    private Graphics2D ekran;
    private Dimension monitor;
    private static int licznik;
    private int x;
    private int y;
    
    
    public Screen(Graphics2D g, Dimension m) {
        ekran = g;
        if(licznik>100) licznik = 0;
        else licznik++;
        monitor = m;
        x=monitor.width; //Rozdzielczość w poziomie
        y=monitor.height; // Rozdzielczość w pionie
        
    }
    public void pokaz() {
        
        ekran.drawString("Test", 50+licznik, 50);
        Player pierwszy = new Player();
        pierwszy.prawo();
        
    }
    
}
