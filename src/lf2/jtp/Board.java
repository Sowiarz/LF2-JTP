
package lf2.jtp;

import java.awt.event.KeyEvent;

public class Board implements InterfaceWindow, Obserwator {
    private static Board unikalnaInstancja;
    private int numberEnemy = 0;
    
    private Board() {
        
    }
    public static Board getSingleton() {
        if(unikalnaInstancja == null) {
            unikalnaInstancja = new Board();
        }
        return unikalnaInstancja;
    }
    
    public static void resetBoard() {
        unikalnaInstancja = new Board();        
    }
    
    public void addEnemy(int numberOfEnemy) {
        numberEnemy = numberOfEnemy;
        for(int i = 0; i < numberOfEnemy; i++) {
            StaticData.addPlayer(new Player()); 
        }        
    }
    
    public void addPlayer(ControlPlayer c) {
        Player gracz = new Player(c);
                
        StaticData.addPlayer(gracz);
        
    }
    
    private void randomEnemy() {
        
    }
    
    private void sterowanie(int i) {
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

                if(StaticData.getPlayer(i).getControlHit()== key) {// Do uderzeń
                   StaticData.getPlayer(i).showHit();
                   StaticData.getPlayer(i).uderz();
                }

                // Metoda ma ukryć uderzenie po jego wykonaniu
                if(StaticData.getPlayer(i).getPictureState() >= 21 && StaticData.getPlayer(i).getPictureState() <= 24) {
                    StaticData.getPlayer(i).hideHit();
                }
            }
        }
        catch (Exception e) {
           // Gdyby tego nie było wywalał by błąd raz na 5 przypadków :D
        }
    }
    private void zarzadzajApteczkami() {
        
        if(StaticData.getNumberOfMedKit() == 0) {
            int i = StaticData.addMedKit(new MedKit());
            StaticData.getMedKit(i).show();
        }
        for(int i=0; i<StaticData.getNumberOfMedKit(); i++) {
            StaticData.getMedKit(i).show();
            StaticData.getMedKit(i).czyKolizja();
        }
    }

    private void zarzadzajBombami() {
        if(StaticData.getNumberOfBomb() == 0) {
            int i = StaticData.addBomb(new Bomb());
            StaticData.getBomb(i).show();
        }
        for(int i=0; i<StaticData.getNumberOfBomb(); i++) {
            StaticData.getBomb(i).show();
//            StaticData.getBomb(i).czyKolizja();
        }
        
    }

    
    
    public void show() {
        Ui.rysujPlansze();
        zarzadzajApteczkami();
        zarzadzajBombami();
        for(int i=0; i<StaticData.getNumberOfPlayers(); i++) {
            
            if(StaticData.getPlayer(i).getSamowola()) {
                StaticData.getPlayer(i).dodajCel(StaticData.getPlayer(numberEnemy).getPosition());
                if (StaticData.getPlayer(i).getLastTimeHit() + 1000 < System.currentTimeMillis()) // Gracz ma większe szanse z komputerem
                StaticData.getPlayer(i).uderz();
            }
            
            if(StaticData.getPlayer(i).getHP() <= 0) {
                StaticData.removePlayer(i); // usunięcie gracza jeśli zginął
                StaticData.addPlayer(new Player()); // Stworzenie nowego przeciwnika w miejsce gracza który zginął
            }
            if(!StaticData.getPause()) {
                StaticData.getPlayer(i).doCelu();
                sterowanie(i); // odpowiada za sterowanie danym graczem
            }
            else {
                StaticData.menu.pokazPause();
            }
            StaticData.getPlayer(i).rysuj(); // na koniec pokazuje gracza po wszystkich przesunięciach
            //System.out.println("X:" + StaticData.getPlayer(0).getXPosition()+ " Y:" + StaticData.getPlayer(0).getYPosition());
            
        }
    }

    public void update(Object o) {
        
        if(o instanceof KeyEvent) {
            KeyEvent key = (KeyEvent)o;
           // sterowanie(key.getKeyCode());
        }
        
    }
    
}
