package lf2.jtp;

import java.awt.Color;
import java.awt.Font;

public class Ui {
    public static void rysujPlansze() {
        StaticData.ekran.setColor(new Color(10, 10, 53));
        StaticData.ekran.fillRect(0, 0, StaticData.screenWidth, StaticData.screenHeight);
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 20);
        StaticData.ekran.setFont(czcionkaMenu);
        rysujPole();

        
    }
    public static void rysujPole() {
          
        StaticData.ekran.drawImage(LoadPicture.background, 0, StaticData.y1, null);
            
    }
    /*public static void rysujPole() {
        StaticData.ekran.setColor(new Color(100, 0, 0));
        StaticData.ekran.fillRect(StaticData.x1, StaticData.y1, StaticData.screenWidth-StaticData.x1-StaticData.x2, StaticData.screenHeight-StaticData.y1-StaticData.y2);  
    }*/
}
