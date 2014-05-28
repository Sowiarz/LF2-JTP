package lf2.jtp;

import java.awt.Color;
import java.awt.Font;

public class Ui {
    public static void rysujPlansze() {
        StaticData.ekran.setColor(new Color(119, 89, 53));
        StaticData.ekran.fillRect(0, 0, StaticData.screenWidth, StaticData.screenHeight);
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 20);
        StaticData.ekran.setFont(czcionkaMenu);
        StaticData.ekran.setColor(new Color(0, 0, 0));
        StaticData.ekran.fillRect(StaticData.x1, StaticData.y1, StaticData.x2, StaticData.y2);
        StaticData.ekran.setColor(new Color(255, 0, 0));
        StaticData.ekran.drawString("Little Fighter", 10, 20);
        
    }
}
