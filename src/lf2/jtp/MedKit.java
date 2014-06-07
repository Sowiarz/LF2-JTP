
package lf2.jtp;

public class MedKit {
    
    int pozx;
    int pozy;
    long timeCreate;
    
    public MedKit() {
        pozx = StaticData.losujSzerokosc();
        pozy = StaticData.losujWysokosc();
        timeCreate =  System.currentTimeMillis();
    }
    
        // Sprawdzanie kolizji
    public boolean czyKolizja() {
        for(int i = 0; i < StaticData.getNumberOfPlayers(); i++) {
                            
                int x1 = StaticData.getPlayer(i).getXPosition();
                int y1 = StaticData.getPlayer(i).getYPosition();
                
                if((pozx < x1+StaticData.playerWidth) && (pozx > x1-StaticData.playerWidth) && (pozy < y1+StaticData.playerHeight) && (pozy > y1-StaticData.playerHeight)) {
                    if(StaticData.getPlayer(i).getHP() != 100) {
                        StaticData.getPlayer(i).setHP(100);
                        StaticData.removeMedKit(this);
                        return true;
                    }
                }                
            }
        
        return false;
    }
    
    public void show() {
        StaticData.ekran.drawImage(LoadImage.medkit, pozx, pozy, null);
    }
}
