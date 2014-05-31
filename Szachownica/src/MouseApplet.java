import java.applet.Applet; import java.awt.Graphics;
import java.awt.Graphics2D; import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;


public class MouseApplet extends Applet {
private Rectangle box;
private static final int box_x = 100;
private static final int box_y = 100;
private static final int box_width = 20;
private static final int box_height = 30;
public MouseApplet() {
box = new Rectangle(box_x, box_y, box_width, box_height);
MouseListener listener = new MouseListener() {

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
};
addMouseListener(listener);
class MousePressListener implements MouseListener {
public void mousePressed(MouseEvent event) {
int x = event.getX();
int y = event.getY();
Pionek.SetLocation(x, y);
repaint();
}
public void mouseReleased(MouseEvent event) {}
public void mouseClicked(MouseEvent event) {}
public void mouseEntered(MouseEvent event) {}
public void mouseExited(MouseEvent event) {}
}
}
public void paint(Graphics g) {
Graphics2D g2 = (Graphics2D)g;
g2.draw(box);
}
}