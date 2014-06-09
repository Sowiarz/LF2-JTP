package lf2.jtp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Metoda odpowiedzialna za wczytywanie obrazków w grze
 * 
 */
public class LoadImage {
    private static LoadImage unikalnaInstancja;
    
    /**
     * Obrazek tła
     */
    public static Image background;

    /** 
     * Obrazek tła menu głownego
     */
    public static Image mainMenu;

    /**
     * Obrazek z logo gry
     */
    public static Image nazwa;

    /**
     * Obrazek z przyciskiem nowej gry
     */
    public static Image newGame;

    /**
     * Obrazek bomby
     */
    public static Image bomb;

    /**
     * Obrazek apteczki
     */
    public static Image medkit;
    
    private LoadImage() {

            background = background();
            mainMenu = mainMenu();
            nazwa = logo();
            newGame = newGame();
    //        bomb = bomb();
            medkit = medkit();
    }
    
    /**
     * Tworzenie Singletonu
     * @return zwraca utworzony Singleton
     */
    public static LoadImage getSingleton() {
        if(unikalnaInstancja == null) {
            unikalnaInstancja = new LoadImage();
        }
        return unikalnaInstancja;
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
    
    private Image mainMenu() {
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

    private Image medkit(){
            Image imgs = null;
            try{
                imgs = ImageIO.read(new File("medkit.png"));
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
}
