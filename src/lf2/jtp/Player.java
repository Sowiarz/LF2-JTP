package lf2.jtp;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;


public class Player {
    private boolean samowola; // jesli true to steruje komputer;
    private int pozx;
    private int pozy;
    private int stan;
    
    private Image img1;
    private BufferedImage bigImg;
            
    private int textheight;
    private int textwidth;
    private int rows;
    private int cols;
    BufferedImage tekstury[]= new BufferedImage[rows*cols];
    
    public ControlPlayer sterowanie;
    
    public boolean prawa = false;
    public boolean lewa = true;
    public boolean dol = false;
    public boolean gora = true;
    
    private int screenHeight = StaticData.screenHeight;
    private int screenWidth = StaticData.screenWidth; 
    
    public Player() {
       
        samowola = false;
        pozx = 30;
        pozy = 30;
        stan = 0;
        sterowanie = new ControlPlayer(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
    }
    public Player(int szer, int wys) {
            samowola = true;
            Random generator = new Random();
                   
            pozx = generator.nextInt() % szer;
            pozy = generator.nextInt() % wys;
  
//        pozx = (int)(Math.random() * rangex);
//        pozy = (int)(Math.random() * rangey);
    }
    public Player(int szer, int wys, ControlPlayer keys) {
            samowola = true;
            sterowanie = keys;
            Random generator = new Random();
                   
            pozx = generator.nextInt() % szer;
            pozy = generator.nextInt() % wys;
  
//        pozx = (int)(Math.random() * rangex);
//        pozy = (int)(Math.random() * rangey);
    }
    public Player(ControlPlayer keys) {
            samowola = false;
            sterowanie = keys;
      
  
//        pozx = (int)(Math.random() * rangex);
//        pozy = (int)(Math.random() * rangey);
    }
    
    
    public void rysuj() {
        /*Image imgs[] = new Image[3];
        imgs[0] = Toolkit.getDefaultToolkit().getImage("mar21.png");
        imgs[1] = Toolkit.getDefaultToolkit().getImage("mar22.png");
        imgs[2] = Toolkit.getDefaultToolkit().getImage("mar23.png");
        */
               
        bigImg = ImageIO.read("mario.png");
        
        
        for (int i = 0; i < rows; i++)
            {
            for (int j = 0; j < cols; j++)
                 {
                    tekstury[(i * cols) + j] = bigImg.getSubimage(j * textwidth,i * textheight,textwidth,textheight);
                 }
            }
        boolean drawImage = StaticData.ekran.drawImage(imgs[stan], pozx, pozy, null);
        StaticData.ekran.finalize();
        
       
    }
    public Image getImage(){
        return img1;
    }
    public void moveRight() {
        if(pozx >= StaticData.screenWidth-70) 
                pozx = StaticData.screenWidth-70;
        else 
                pozx+=4;
        stan=1;
        rysuj();
    } 
    public void moveLeft() {
        if(pozx <= -20) 
                pozx = -20;
        else
                pozx-=4;
        stan=2;
        rysuj();
    }
    public void moveDown() {
        if(pozy >= StaticData.screenHeight-70)
                pozy = StaticData.screenHeight-70;
        else
                pozy+=4;
        stan = 0;
        rysuj();
    }
    public void moveUp() {
        if(pozy <= -20)
                pozy = -20;
        else 
                pozy-=4;
        stan = 1;
        rysuj();
    }
    
    public void setPosition(int x, int y) {
        pozy = x;
        pozy = y;
    }
    
    public void setSamowola(boolean s) {
        samowola = s;
    }
    
    public int getXPosition() {
        return pozx;
    }
    public int getYPosition() {
        return pozy;
    }
    public boolean getSamowola() {
        return samowola;
    }
    
    // Metody zwracające sterowanie
    
    public int getControlUp() {
        return sterowanie.getUp();
    }
    public int getControlDown() {
        return sterowanie.getDown();
    }
    public int getControlLeft() {
        return sterowanie.getLeft();
    }
    public int getControlRight() {
        return sterowanie.getRight();
    }
}
