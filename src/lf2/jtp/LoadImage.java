package lf2.jtp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadImage {
    private static LoadImage unikalnaInstancja;
    
    public static Image background;
    public static Image mainMenu;
    public static Image nazwa;
    public static Image newGame;
    public static Image bomb;
    public static Image medkit;
    
    private LoadImage() {

            background = background();
            mainMenu = mainMenu();
            nazwa = logo();
            newGame = newGame();
            bomb = bomb();
            medkit = medkit();
    }
    
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
    private Image bomb(){
            Image imgs = null;
            try{
                imgs = ImageIO.read(new File("bomb.png"));
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
