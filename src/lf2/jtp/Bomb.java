
package lf2.jtp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *  Klasa odpowiedzialna za tworzenie nowej Bomby
 * 
 */
public class Bomb {
    // obrazek
    private static BufferedImage[] bomba;
    private int charCols=41;
    private int bombWidth=32;
    private int bombHeight=32;
    private int stan = 0;
    private int stan2 = 0;
    
    // właściwości bomby
    private int pozx;
    private int pozy;
    private long timeCreate =  System.currentTimeMillis();
    private long time;
    private boolean czyWybuchla;
    
    /**
     * Konstrutor
     */
    public Bomb() {
        pozx = StaticData.losujSzerokosc();
        pozy = StaticData.losujWysokosc();
        timeCreate =  System.currentTimeMillis();
        czyWybuchla = false;
        try{
        bomba=wczytaj();    
        }catch(IOException e){
            System.out.println("IOEXCEPTION");
        }
    }

    private BufferedImage[] wczytaj() throws IOException {
        // całość do poprawy
        BufferedImage[] bomba = new BufferedImage[45];
        BufferedImage imgs = null;

        try{
            imgs = ImageIO.read(new File("bomb.png"));
        }catch (IOException e) {
            System.out.println("Wystąpił błąd z wczytaniem obrazka!");
        }

        for (int i = 0; i < charCols; i++) {

              bomba[i] = imgs.getSubimage(i * bombWidth, 0, bombWidth, bombHeight);

        }

        return bomba;
    }
    
    private void wybuch() {
            for(int i = 0; i < StaticData.getNumberOfPlayers(); i++) {

                int x1 = StaticData.getPlayer(i).getXPosition();
                int y1 = StaticData.getPlayer(i).getYPosition();

                Point odleglosc = new Point(x1, y1);
                if(StaticData.odlegloscOdPunktow(odleglosc, new Point(pozx, pozy)) < 150) {
                    StaticData.getPlayer(i).setHP(StaticData.getPlayer(i).getHP()-25);
                }    
                if(StaticData.odlegloscOdPunktow(odleglosc, new Point(pozx, pozy)) < 100) {
                    StaticData.getPlayer(i).setHP(StaticData.getPlayer(i).getHP()-25);
                }    
                if(StaticData.odlegloscOdPunktow(odleglosc, new Point(pozx, pozy)) < 50) {
                    StaticData.getPlayer(i).setHP(StaticData.getPlayer(i).getHP()-25);
                }                
            }
    }
 
    /**
     * Pokazanie nowej bomby na ekranie
     */
    public void show() {
        if(!StaticData.getPause()) {
            if(stan == 26){
                if(stan2 == 2){
                    wybuch();
                    stan++;
                }
                else
                {
                    stan = 0;
                    stan2++;
                }
            }

            if (time + 50 < System.currentTimeMillis()) {
                time = System.currentTimeMillis();
                if(stan < 42)
                stan++;
            }
        }
        StaticData.ekran.drawImage(bomba[stan], pozx, pozy, null);
        if(stan == 41) 
        StaticData.removeBomb(this);
        
    }
}

    
   
    
