package lf2.jtp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Control extends MouseAdapter {
     
        public void mouseClicked(MouseEvent e) {
            System.exit(0); // Zamknięcie programu na kliknięcie
        }
     
}
