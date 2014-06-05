package lf2.jtp;

import java.awt.Color;
import java.awt.Font;

public class Menu implements Obserwator {
    
    
    public Menu() {
        
    }
    
    public void pokazInfo() {
        StaticData.ekran.setColor(new Color(119, 89, 53));
        int wysokoscOkna = 200;
        int szerokoscOkna = 200;
        
        Point p1 = new Point(StaticData.obliczPolozenieSrodkowe(StaticData.screenWidth, szerokoscOkna), StaticData.obliczPolozenieSrodkowe(StaticData.screenHeight, wysokoscOkna));
        Point p2 = new Point(p1.getX()+szerokoscOkna, p1.getY()+wysokoscOkna);
        Border granica = new Border(p1, p2);
        StaticData.ekran.fillRect(granica.getP1X(), granica.getP1Y(), granica.podajSzerokosc(), granica.podajWysokosc());
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 20);
        StaticData.ekran.setFont(czcionkaMenu);
        StaticData.ekran.setColor(new Color(0, 0, 0));
        StaticData.ekran.drawString("Okno informacyjne", granica.getP1X()+10, granica.getP1Y()+20);
    }

    public void update(Object o) {
        System.out.println(o.getClass());
    }
    
}
