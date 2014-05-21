
package lf2.jtp;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;


public class Screen {
    
    boolean prawa = false;
    boolean lewa = true;
    boolean dol = false;
    boolean gora = true;
    
    public Screen() {
        Player pierwszy = new Player();
        StaticData.addPlayer(pierwszy); // tworzenie gracza głownego
        
        for(int i=0; i<10; i++) { //tworzenie graczy dodatkowych      
            StaticData.addPlayer(new Player(1366,768)); // liczby to rozdzielczość ekranu
        }
        
    }
    private void odbijOdSciany(int i) {
            if(StaticData.getPlayer(i).getXPosition() >= StaticData.screenWidth-70) {
                StaticData.getPlayer(i).prawa = true;
                StaticData.getPlayer(i).lewa = false;
            }
            if(StaticData.getPlayer(i).getXPosition() <= 0-20) {
                StaticData.getPlayer(i).prawa = false;
                StaticData.getPlayer(i).lewa = true;
            }
            if(StaticData.getPlayer(i).getYPosition() >= StaticData.screenHeight-70) {
                StaticData.getPlayer(i).dol = true;
                StaticData.getPlayer(i).gora = false;
            }
            if(StaticData.getPlayer(i).getYPosition() <= 0-20) {
                StaticData.getPlayer(i).dol = false;
                StaticData.getPlayer(i).gora = true;
            }
            
            if(StaticData.getPlayer(i).lewa && StaticData.getPlayer(i).gora) {
                StaticData.getPlayer(i).moveRight();
                StaticData.getPlayer(i).moveDown();  
            }
            if(StaticData.getPlayer(i).lewa && StaticData.getPlayer(i).dol) {
                StaticData.getPlayer(i).moveRight();
                StaticData.getPlayer(i).moveUp();
            }            
            if(StaticData.getPlayer(i).prawa && StaticData.getPlayer(i).gora) {
                StaticData.getPlayer(i).moveLeft();
                StaticData.getPlayer(i).moveDown();  
            }
            if(StaticData.getPlayer(i).prawa && StaticData.getPlayer(i).dol) {
                StaticData.getPlayer(i).moveLeft();
                StaticData.getPlayer(i).moveUp();
            }
    }
    
    private void poruszanie(int i) {
        if(Control.left)
            StaticData.getPlayer(i).moveLeft();
        if(Control.down)
            StaticData.getPlayer(i).moveDown();
        if(Control.up)
            StaticData.getPlayer(i).moveUp();
        if(Control.right)
            StaticData.getPlayer(i).moveRight();
    
    }
    
    public void odswiez() {
       
        for(int i=0; i<StaticData.getNumberOfPlayers(); i++) {
            if(StaticData.odbijanie) {
                if(i != 0)
                    odbijOdSciany(i);
            }
            if(i == 0) poruszanie(i);
            StaticData.getPlayer(i).rysuj();
        }
    }
    
}
