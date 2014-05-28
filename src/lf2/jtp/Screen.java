
package lf2.jtp;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;


public class Screen {
    private int ScreenW = StaticData.screenWidth;
    private int ScreenH = StaticData.screenHeight;
    
    public Screen() {
        Player pierwszy = new Player(new ControlPlayer(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN));
        StaticData.addPlayer(pierwszy); // tworzenie gracza głownego
        
        ControlPlayer klawisze = new ControlPlayer(KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_S);
        Player drugi = new Player(klawisze);
        StaticData.addPlayer(drugi); // tworzenie gracza głownego
        
        for(int i=0; i<1; i++) { //tworzenie graczy dodatkowych      

            StaticData.addPlayer(new Player()); // liczby to rozdzielczość ekranu
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
        try {
            for(Integer key : Control.getControl().keySet()) { // pętla for-each - iteracja po każdym elemencie naciśniętego klawisza

                if(StaticData.getPlayer(i).getControlRight() == key) //Sprawdzanie czy naciśnięty przycisk pasuje do sterowania danego gracza
                   StaticData.getPlayer(i).moveRight();

                if(StaticData.getPlayer(i).getControlLeft() == key) 
                   StaticData.getPlayer(i).moveLeft();

                if(StaticData.getPlayer(i).getControlDown() == key) 
                   StaticData.getPlayer(i).moveDown();

                if(StaticData.getPlayer(i).getControlUp() == key) 
                   StaticData.getPlayer(i).moveUp();
            }
        }
        catch (Exception e) {
           // Gdyby tego nie było wywalał by błąd raz na 5 przypadków :D
        }
    
    }
    
    public void odswiez() {
        Ui.rysujPlansze();
        for(int i=0; i<StaticData.getNumberOfPlayers(); i++) {
            if(StaticData.odbijanie) {
            if(StaticData.getPlayer(i).getSamowola()) // sprawdza czy dany gracz ma włączoną samowole
                    odbijOdSciany(i); // jesli tak to odbija go od ściany
            }
            poruszanie(i); // odpowiada za sterowanie danym graczem
            StaticData.getPlayer(i).rysuj(); // na koniec pokazuje gracza po wszystkich przesunięciach
            System.out.println("X:" + StaticData.getPlayer(0).getXPosition()+ " Y:" + StaticData.getPlayer(0).getYPosition());
        }
    }
    
}
