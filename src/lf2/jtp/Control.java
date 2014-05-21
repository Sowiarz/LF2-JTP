package lf2.jtp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control extends MouseAdapter implements KeyListener {

       public void mousePressed(MouseEvent e) {
          
          
            
           
        }

    @Override
    public void keyTyped(KeyEvent e) {
              
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 27)
             System.exit(0); // Zamyka apkę na ESC
        if(e.getKeyCode() == 39)
             StaticData.getPlayer(0).move_right();
        if(e.getKeyCode() == 37)
             StaticData.getPlayer(0).move_left();
        if(e.getKeyCode() == 38)
             StaticData.getPlayer(0).move_up();
        if(e.getKeyCode() == 40)
             StaticData.getPlayer(0).move_down();
        // System.out.println(e.getKeyCode()); // pokazuje kod naciśniętego klawisza w konsoli
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
       
     
}
