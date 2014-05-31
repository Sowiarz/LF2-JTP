import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.awt.event.*;
import java.applet.Applet;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;


public class Szachownica {
   JFrame frame;
   Canvas canvas; 
   BufferStrategy bufferStrategy;
   int width = 400;
   int height = 400;
   
   
   public Szachownica(){
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        int x = (dim.width-width)/2;
        int y = (dim.height-height)/2;
        
      frame = new JFrame("Szachownica");
      
      JPanel panel = (JPanel) frame.getContentPane();
      panel.setPreferredSize(new Dimension(width, height));
      panel.setLayout(null);
      canvas = new Canvas();
      canvas.setBounds(0, 0, width, height);
      canvas.setIgnoreRepaint(true);
      frame.setLocation(x, y);
      
      panel.add(canvas);      
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Dzięki temu poprawnie zamyka się apka
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
      
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();     
      render();
   }
   
   public void render() {
      Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
      g.clearRect(0, 0, width, height);
      render(g);
      g.dispose();
      bufferStrategy.show();
   }
 
   Font czcionkaMenu = new Font("Arial", Font.BOLD, 30);
   
   public void render(Graphics2D g){
      int pole = (int)(width/8);
      g.setColor(new Color(255, 255, 255));
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((j+i)%2 != 1)
                  g.setColor(new Color(255, 255, 255));
                else
                  g.setColor(new Color(0, 0, 0));

                  g.fillRect(pole*j, pole*i, pole, pole);
            }
        }     
        g.setColor(new Color(255,0,0));
        //g.fillOval(width/8, width/8, width/8, width/8);
        g.fillOval(Pionek.a, Pionek.b, width/8-1, width/8-1);
   }
   
   public static void main(String [] args){
       MouseApplet list = new MouseApplet();
        addMouseListener(list);
       
       new Szachownica();
   }

}
