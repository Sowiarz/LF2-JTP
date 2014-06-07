
package lf2.jtp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bomb {
    // obrazek
    private static BufferedImage[] bomba;
    private int charCols;
    private int charWidth;
    private int charHeight;
    private int stan = 0;
    
    // właściwości bomby
    private int pozx;
    private int pozy;
    private long timeCreate =  System.currentTimeMillis();
    private long time;
    private boolean czyWybuchla = false;
    
    public Bomb(int x, int y) {
        if(bomba == null) {
            try {
                bomba = wczytaj();
            } catch (IOException ex) {
                // nic nie rób
            }
        }
        pozx = x;
        pozy = y;
    }
    
    private BufferedImage[] wczytaj() throws IOException {
        // całość do poprawy
        BufferedImage[] bomba = new BufferedImage[40];
        BufferedImage imgs = null;

        try{
            imgs = ImageIO.read(new File("testerbackup.png"));
        }catch (IOException e) {
            System.out.println("Wystąpił błąd z wczytaniem obrazka!");
        }

        for (int i = 0; i < charCols; i++) {

              bomba[i] = imgs.getSubimage(i * charWidth, 0, charWidth, charHeight);

        }

        return bomba;
    }
    
    private void wybuch() {
        if(!czyWybuchla) {
            for(int i = 0; i < StaticData.getNumberOfPlayers(); i++) {

                int x1 = StaticData.getPlayer(i).getXPosition();
                int y1 = StaticData.getPlayer(i).getYPosition();

                Point odleglosc = new Point(x1, y1);
                if(StaticData.odlegloscOdPunktow(odleglosc, new Point(pozx, pozy)) < 100) {
                    StaticData.getPlayer(i).setHP(StaticData.getPlayer(i).getHP()-25);
                }                       
            }
            czyWybuchla = true;
        }
        else {
            // stan++ - tak aby dokończyć animacje wybuchu i generować kolejne klatki za każdym wywołaniem wybuch();
            if(stan == charCols) {
                StaticData.removeBomb(this); // usunięcie bomby z gry po wybuchu
            }
                
        }
    }
    
    public void show() {
        if(!czyWybuchla) {
            if (time + 10 < System.currentTimeMillis()) {
                time = System.currentTimeMillis();
                stan++;
                // tutaj warunek żeby się paliła, ale jeszcze nie wybuchała
            }
//            if((System.currentTimeMillis()-timeCreate) > ?) {
                   wybuch();
//            }
        }
        StaticData.ekran.drawImage(bomba[stan], pozx, pozy, null);
    }
    
    
}
