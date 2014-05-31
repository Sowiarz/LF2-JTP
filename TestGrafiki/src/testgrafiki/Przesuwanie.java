import java.applet.Applet; import java.awt.Graphics;
import java.awt.Graphics2D; import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class Przesuwanie extends Applet {
private Rectangle box;
private static final int box_x = 100;
private static final int box_y = 100;
private static final int box_width = 20;
private static final int box_height = 30;
public Przesuwanie() {
box = new Rectangle(box_x, box_y,
box_width, box_height);
MouseListener listener = new MouseListener();
addMouseListener(listener);
class MousePressListener implements MouseListener {
public void mousePressed(MouseEvent event) {
int x = event.getX();
int y = event.getY();
box.setLocation(x, y);
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