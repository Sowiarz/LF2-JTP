
package lf2.jtp;

import java.awt.Dimension;
import java.awt.Graphics2D;


public class Screen {
    
    private int x;
    private int y;
    
    
    public Screen() {
        Player pierwszy = new Player();
        StaticData.addPlayer(pierwszy);
        
        
    }
    public void Odswiez() {
        
        for(int i=0; i<StaticData.getNumberOfPlayers(); i++) {
            StaticData.getPlayer(i).rysuj();
        }
    }
    public void pokaz() {
        
        StaticData.ekran.drawString("Test", 50, 50);
        
        
        
                
        
    }

    
}
