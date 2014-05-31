package lf2.jtp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Spring;

public class LoadPicture {
    
    private static int width=40;
    private static int height=60;
    private static int rows=1;
    private static int columns=11;
    

    public static BufferedImage[] wczytaj() throws IOException {

            final int charWidth = 60;
            final int charHeight = 85;
            final int charCols = 22;
            final int charRows = 1;

            BufferedImage[] sprites = new BufferedImage[40];
            BufferedImage imgs = null;

            try{
                imgs = ImageIO.read(new File("testerbackup.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < charCols; i++) {
               for (int j = 0; j < charRows; j++) {
                  sprites[i * charRows + j] = imgs.getSubimage(i * charWidth, j * charHeight, charWidth, charHeight);
               }
            }
            
            
            StaticData.playerHeight = charHeight; // Zmienne globalne z wymiarami gracza
            StaticData.playerWidth = charWidth;
            
            return sprites;
    }

}
