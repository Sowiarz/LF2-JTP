
package lf2.jtp;

import java.awt.Dimension;
import java.awt.Graphics2D;

public class Screen {
    private Graphics2D ekran;
    private Dimension monitor;
    private int x;
    private int y;
    private int t1=0, t2=0;
    
    public Screen(Graphics2D g, Dimension m) {
        ekran = g;
        monitor = m;
        x=monitor.width; //Rozdzielczość w poziomie
        y=monitor.height; // Rozdzielczość w pionie
        
    }
    public void pokaz() {
        for(t1=0; t1<50; t1++) {
        ekran.drawString("Test", ((int)(50+t1)/1000), 50);
        }
    }
    
}
