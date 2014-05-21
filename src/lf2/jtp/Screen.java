
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
        //Player drugi = new Player();
        StaticData.addPlayer(pierwszy);
        //StaticData.addPlayer(drugi);
        
        
    }
    private void odbijOdSciany(int i) {
            if(StaticData.getPlayer(i).getXPosition() >= StaticData.screenWidth-70) {
                prawa = true;
                lewa = false;
            }
            if(StaticData.getPlayer(i).getXPosition() <= 0-20) {
                prawa = false;
                lewa = true;
            }
            if(StaticData.getPlayer(i).getYPosition() >= StaticData.screenHeight-70) {
                dol = true;
                gora = false;
            }
            if(StaticData.getPlayer(i).getYPosition() <= 0-20) {
                dol = false;
                gora = true;
            }
            
            if(lewa && gora) {
                StaticData.getPlayer(i).moveRight();
                StaticData.getPlayer(i).moveDown();  
            }
            if(lewa && dol) {
                StaticData.getPlayer(i).moveRight();
                StaticData.getPlayer(i).moveUp();
            }            
            if(prawa && gora) {
                StaticData.getPlayer(i).moveLeft();
                StaticData.getPlayer(i).moveDown();  
            }
            if(prawa && dol) {
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
            if(StaticData.odbijanie) odbijOdSciany(i);
            poruszanie(i);
            StaticData.getPlayer(i).rysuj();
        }
    }
    
}
