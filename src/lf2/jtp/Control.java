package lf2.jtp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control extends MouseAdapter implements KeyListener {
    
    // Blok klawiszy
    public static boolean down = false;
    public static boolean up = false;
    public static boolean right = false;
    public static boolean left = false;

       public void mousePressed(MouseEvent e) {
          
       }

    @Override
    public void keyTyped(KeyEvent e) {
              
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        switch(keyCode) {
            case 39: 
                right = true;
                break;
            case 37:
                left = true;
                break;
            case 38:
                up = true;
                break;
            case 40:
                down = true;
                break;
            case 32:
                StaticData.odbijanie = !StaticData.odbijanie; // włączanie i wyłączanie odbijania od ścian
                break;
            case 27:
                System.exit(1); // Zamknięcie na przycisk ESC
                break;
                   
        }

        // System.out.println(e.getKeyCode()); // pokazuje kod naciśniętego klawisza w konsoli
    }

    @Override
    public void keyReleased(KeyEvent e) {
          int keyCode = e.getKeyCode();
        
        switch(keyCode) {
            case 39: 
                right = false;
                break;
            case 37:
                left = false;
                break;
            case 38:
                up = false;
                break;
            case 40:
                down = false;
                break;
            
                   
        }
    }
       
     
}
