package lf2.jtp;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player  implements KeyListener {
    private int pozx;
    private int pozy;
    public Player() {
        pozx = 30;
        pozy = 30;
    }
    public void rysuj(Graphics2D g) {
        g.drawRect(pozx, pozy, 10, 10);
    }
    public void prawo() {
        pozx++;
    } 

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        prawo();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
