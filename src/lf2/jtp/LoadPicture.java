/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lf2.jtp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Seba
 */
public class LoadPicture {
int width=40;
int height=60;
int rows=1;
int columns=12;

public static BufferedImage[] wczytaj() throws IOException {
    
        final int charWidth = 64;
        final int charHeight = 64;
        final int charCols = 12;
        final int charRows = 1;
        
        BufferedImage[] sprites = new BufferedImage[15];
        BufferedImage imgs = null;
    
        try{
            imgs = ImageIO.read(new File("tester.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
   
        for (int i = 0; i < charCols; i++) {
           for (int j = 0; j < charRows; j++) {
              sprites[i * charRows + j] = imgs.getSubimage(i * charWidth, j * charHeight, charWidth, charHeight);
           }
        }
        
        return sprites;
    }

}
