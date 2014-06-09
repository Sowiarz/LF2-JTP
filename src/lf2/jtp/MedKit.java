
package lf2.jtp;

/**
 * Klasa tworząca apteczki na planszy
 * 
 */
public class MedKit {
    
    int pozx;
    int pozy;
    long timeCreate;
    
    /**
     * Konstruktor klasy
     */
    public MedKit() {
        pozx = StaticData.losujSzerokosc();
        pozy = StaticData.losujWysokosc();
        timeCreate =  System.currentTimeMillis();
    }
    
        // Sprawdzanie kolizji

    /**
     * Sprawdzanie czy gracz jest w zasięgu apteczki
     * @return zwraca true jeśli gracz jest w zasięgu apteczki
     */
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
    
    /**
     * Metoda pokazuje apteczkę na mapie
     */
    public void show() {
        StaticData.ekran.drawImage(LoadImage.medkit, pozx, pozy, null);
    }
}
