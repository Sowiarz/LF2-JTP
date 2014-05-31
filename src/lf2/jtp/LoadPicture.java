package lf2.jtp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadPicture {
    
    private int charWidth = 60;
    private int charHeight = 85;
    private int charCols = 22;
    private int charRows = 1;
    
    private int stan = 0;
    private int strona = 0;
    public long time;
        
    public static BufferedImage[] obrazek; //tablica przechowywująca obrazki

    public LoadPicture() {
        
        try {
            obrazek = wczytaj();
        } catch (IOException ex) {
            System.out.println("Wystąpił błąd z wczytaniem obrazka");
        }
        
    }
    

    private BufferedImage[] wczytaj() throws IOException {

            BufferedImage[] sprites = new BufferedImage[40];
            BufferedImage imgs = null;

            try{
                imgs = ImageIO.read(new File("testerbackup.png"));
            }catch (IOException e) {
                System.out.println("Wystąpił błąd z wczytaniem obrazka!");
            }

            for (int i = 0; i < charCols; i++) {
               for (int j = 0; j < charRows; j++) {
                  sprites[i * charRows + j] = imgs.getSubimage(i * charWidth, j * charHeight, charWidth, charHeight);
               }
            }
            
            
            StaticData.playerHeight = charHeight; // Zmienne globalne z wymiarami gracza
            StaticData.playerWidth = charWidth;
            
            return sprites;
    }
    
    public BufferedImage getImage() {
        return obrazek[stan];
    }
    
    public void moveRight() {
            strona = 1;
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 9)
            stan=0;
            stan++;
        }
    }
    
    public void moveLeft() {
        strona = -1;
        
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 20 || stan < 10)
            stan=10;
            stan++;
        }
    }
    
    public void moveDown() {
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();      
            if(strona==-1){
                if(stan > 20 || stan < 10)
                    stan=10;
            }
            
            if(strona==1){
                if(stan>9)
                    stan=0;
            }
        stan++;
        }
    }
    
    public void moveUp() {
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            
            if(strona==-1){
                if(stan > 20 || stan < 10)
                    stan=10;
            }
            
            if(strona==1){
                if(stan>9)
                    stan=0;
            }             
            
           stan++;          
        }
    }
    
    public int getState() {
        return stan;
    }

}
