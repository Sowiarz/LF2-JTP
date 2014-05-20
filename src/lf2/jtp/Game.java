package lf2.jtp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Game implements Runnable {
   
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // Pobranie rozdzielczości ekranu
   
   JFrame frame; // Okno głowne
   Canvas canvas; // Obiekt potrzebny do rysowania
   BufferStrategy bufferStrategy;
   
   public Game(){
      frame = new JFrame("LF2");
      
      JPanel panel = (JPanel) frame.getContentPane();
      panel.setPreferredSize(new Dimension(d.width, d.height));
      panel.setLayout(null);
      frame.setUndecorated(true); // Brak górnej belki windows i basków bocznych
      canvas = new Canvas();
      canvas.setBounds(0, 0, d.width, d.height);
      canvas.setIgnoreRepaint(true);
      
      panel.add(canvas); //utworzenie okna + dodanie do niego canvas
      
      canvas.addMouseListener(new Control()); //dodanie obsługi myszki
     
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Dzięki temu poprawnie zamyka się apka
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
      
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      
      canvas.requestFocus();
   }
   
        
 
   
   long desiredFPS = 60;
   long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;
    
   boolean running = true;
   
   public void run(){
      
      long beginLoopTime;
      long endLoopTime;
      long currentUpdateTime = System.nanoTime();
      long lastUpdateTime;
      long deltaLoop;
      
      while(running){
         beginLoopTime = System.nanoTime();
         
         render();
         
         lastUpdateTime = currentUpdateTime;
         currentUpdateTime = System.nanoTime();
         update((int) ((currentUpdateTime - lastUpdateTime)/(1000*1000)));
         
         endLoopTime = System.nanoTime();
         deltaLoop = endLoopTime - beginLoopTime;
           
           if(deltaLoop > desiredDeltaLoop){
               //Do nothing. We are already late.
           }else{
               try{
                   Thread.sleep((desiredDeltaLoop - deltaLoop)/(1000*1000));
               }catch(InterruptedException e){
                   //Do nothing
               }
           }
      }
   }
   
   private void render() {
      Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
      g.clearRect(0, 0, d.width, d.height);
      render(g);
      g.dispose();
      bufferStrategy.show();
   }
   
   //TESTING
   private double x = 0;
   
   /**
    * Rewrite this method for your game
    */
   protected void update(int deltaTime){
      x += deltaTime * 0.2;
      while(x > 800){
         x -= 500;
      }
   }
   
   /**
    * Rewrite this method for your game
    */
   Font myFont = new Font("Arial", Font.BOLD, 30);
   
   protected void render(Graphics2D g){
      
      g.setColor(Color.GRAY);
      g.fillRect(0, 0, d.width, d.height);
      g.setFont(myFont);
      g.setColor(Color.red);
      g.drawString("Nowa Gra", 200, d.height-100);
      g.drawString("Opcje", 200, d.height-70);
   }
   
   public static void main(String [] args){
      Game ex = new Game();
      new Thread(ex).start();
   }

}
