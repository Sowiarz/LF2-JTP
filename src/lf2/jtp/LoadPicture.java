package lf2.jtp;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Klasa odpowiedzialna za wczytywanie postaci gracza
 * 
 */
public class LoadPicture {
    
    
    private int charWidth = 60;
    private int charHeight = 85;
    private int charFightWidth = 92;
    private int charCols = 22;
    private int charRows = 1;
    
    private int stan = 0;
    private int strona = 1;
    private long time;
        
    /**
     * Obrazek przedstawiający wszystkie ruchy postaci
     */
    public static BufferedImage[] obrazek; //tablica przechowywująca obrazki przedstawiajace gracza
   
    /**
     * Ładowanie obrazka
     */
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
                
                  sprites[i] = imgs.getSubimage(i * charWidth, 0, charWidth, charHeight);
               
            }
            int j = 0;
            for ( int i = 22; i < 26 ; i++,j++){
                
                sprites[i] = imgs.getSubimage(1320 + j * charFightWidth, 0, charFightWidth, charHeight);
                
            }
            
            StaticData.playerHeight = charHeight; // Zmienne globalne z wymiarami gracza
            StaticData.playerWidth = charWidth;
            
            return sprites;
    }
    
    private Image background(){
            Image imgs = null;
            try{
                imgs = ImageIO.read(new File("background.png"));
                imgs = imgs.getScaledInstance((int)StaticData.screenWidth, (int)StaticData.screenHeight, ImageIO.read(new File("background.png")).SCALE_SMOOTH);
            }catch (IOException e) {
                System.out.println("Wystąpił błąd z wczytaniem obrazka!");
            }  
            return imgs;
            
    }
    
    private Image mainMenu(){
            Image imgs = null;
            try{
                imgs = ImageIO.read(new File("menu.png"));
                imgs = imgs.getScaledInstance((int)StaticData.screenWidth, (int)StaticData.screenHeight, ImageIO.read(new File("background.png")).SCALE_SMOOTH);
            }catch (IOException e) {
                System.out.println("Wystąpił błąd z wczytaniem obrazka!");
            }  
            return imgs;
            
    }
    private Image logo(){
            Image imgs = null;
            try{
                imgs = ImageIO.read(new File("logo.png"));
                //imgs = imgs.getScaledInstance((int)StaticData.screenWidth, (int)StaticData.screenHeight, ImageIO.read(new File("background.png")).SCALE_SMOOTH);
            }catch (IOException e) {
                System.out.println("Wystąpił błąd z wczytaniem obrazka!");
            }  
            return imgs;
            
    }
    private Image newGame(){
            Image imgs = null;
            try{
                imgs = ImageIO.read(new File("newgame.png"));
                //imgs = imgs.getScaledInstance((int)StaticData.screenWidth, (int)StaticData.screenHeight, ImageIO.read(new File("background.png")).SCALE_SMOOTH);
            }catch (IOException e) {
                System.out.println("Wystąpił błąd z wczytaniem obrazka!");
            }  
            return imgs;
            
    }
    
    /**
     * Metoda zwraca obrazek dla danego stanu gracza
     * @return obrazek
     */
    public BufferedImage getImage() {
        return obrazek[stan];
    }
    
    /**
     * Zmiana stanu gracza jak będzie poruszał się w prawo
     */
    public void moveRight() {
            strona = 1;
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 9)
            stan=0;
            stan++;
        }
    }
    
    /**
     * Zmiana stanu gracza jak będzie poruszał się w lewo
     */
    public void moveLeft() {
        strona = -1;
        
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(stan > 20 || stan < 10)
            stan=10;
            stan++;
        }
    }
    
    /**
     * Zmiana stanu gracza jak będzie poruszał się w dół
     */
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
    
    /**
     * Zmiana stanu gracza jak będzie poruszał się w górę
     */
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
    
    /**
     * Zmiana stanu gracza jak będzie uderzał przeciwnika
     */
    public void uderz(){
        if (time + 100 < System.currentTimeMillis()) {
            time = System.currentTimeMillis();
            if(strona==-1){
                if(stan > 24 || stan < 23)
                    stan=23;
                    
            }
            
            if(strona==1){
                if(stan > 22 || stan<21)
                    stan=21;
                    
            }             
            
           stan++;          
        }
        
    }
    
    /**
     * Zmiana stanu gracza jak będzie cofał dłoń po uderzeniu
     */
    public void setState() { // metoda cofa rękę podczas walki
        if(getStrona() == 1) { // skierowany w prawo
            if (time + 500 < System.currentTimeMillis()) {
                time = System.currentTimeMillis();
                stan=0;
            
            }
        }
        if(getStrona() == -1) { // skierowany w lewo
            if (time + 500 < System.currentTimeMillis()) {
                time = System.currentTimeMillis();
                stan=11;
            
            }
        
        }
    }
    
    /**
     * Zwraca stan gracza w jaim się znajduje
     * @return stan
     */
    public int getState() {
        return stan;
    }
    
    /**
     * Zwraca stronę w którą obrócony jest gracz
     * @return jeśli 1 to odwrócony w prawo, jeśli -1 to w lewo
     */
    public int getStrona() {
        return strona;
    }

}
