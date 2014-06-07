package lf2.jtp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game implements Runnable {
   
    Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize(); // Pobranie rozdzielczości ekranu
   
   JFrame frame; // Okno głowne
   Canvas canvas; // Obiekt potrzebny do rysowania
   BufferStrategy bufferStrategy;
   Screen obiektScreen;
   
   
   public Game(){
      StaticData.screenWidth = monitor.width;
      StaticData.screenHeight = monitor.height;
      
      obiektScreen = new Screen();
      Menu obiektMenu = new Menu();
      StaticData.menu = obiektMenu;
      frame = new JFrame("LF2");
      
      JPanel panel = (JPanel) frame.getContentPane();
      panel.setPreferredSize(new Dimension(monitor.width, monitor.height));
      panel.setLayout(null);
      frame.setUndecorated(true); // Brak górnej belki windows i basków bocznych
      canvas = new Canvas();
      canvas.setBounds(0, 0, monitor.width, monitor.height);
      canvas.setIgnoreRepaint(true);
      
      panel.add(canvas); //utworzenie okna + dodanie do niego canvas
      
      Control klawisze = new Control();
      MouseControl mysz = new MouseControl();
      mysz.dodajObserwatora(obiektMenu);
      
      // Zapisanie obiektów w StaticData
      
      StaticData.klawiatura = klawisze;
      StaticData.mysz = mysz;
      
      
      // Dodanie obsługi klawiatury i myszy
      
      canvas.addKeyListener(klawisze);
      canvas.addMouseListener(mysz);
     
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Dzięki temu poprawnie zamyka się apka
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
      
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      System.out.println("Rozdzielczość: " + monitor.width + "x" +  monitor.height);
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
                  
         endLoopTime = System.nanoTime();
         deltaLoop = endLoopTime - beginLoopTime;
           
           if(deltaLoop > desiredDeltaLoop){
               //Do nothing. We are already late.
           }else{
               try{
                   Thread.sleep((desiredDeltaLoop - deltaLoop)/(1000*1000));
               }catch(InterruptedException e){
                   //Nic nie rób
               }
           }
      }
   }
   
   private void render() {
      Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
      StaticData.ekran = g;
      StaticData.ekran.clearRect(0, 0, monitor.width, monitor.height);
      StaticData.ekran.setColor(new Color(28, 32, 87)); // Odpowiedzialne za ustawienie tła na początku
      StaticData.ekran.fillRect(0, 0, monitor.width, monitor.height);
      LoadImage.getSingleton();
    // Wywołanie Klas wyświetlających
      obiektScreen.odswiez();
      
      
      StaticData.ekran.dispose();
      bufferStrategy.show();
   }

   
   public static void main(String [] args){
      Game ex = new Game();
      new Thread(ex).start();
   }

}
