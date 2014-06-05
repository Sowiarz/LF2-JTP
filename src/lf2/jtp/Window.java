package lf2.jtp;

import java.awt.Color;
import java.awt.Font;


public class Window {
    
    private Point p1;
    private Point p2;
    private int wysokoscOkna;
    private int szerokoscOkna;
    private Border granicaOkna;
    
    public Window(int width, int height) {
        wysokoscOkna = height;
        szerokoscOkna = width;
        
        p1 = new Point(StaticData.obliczPolozenieSrodkowe(StaticData.screenWidth, szerokoscOkna), StaticData.obliczPolozenieSrodkowe(StaticData.screenHeight, wysokoscOkna));
        p2 = new Point(p1.getX()+szerokoscOkna, p1.getY()+wysokoscOkna);
        granicaOkna = new Border(p1, p2);
    }
    
    public void pokazOkno() {
        
        StaticData.ekran.setColor(new Color(255, 255, 255));       
        StaticData.ekran.fillRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
        StaticData.ekran.setColor(new Color(0, 0, 255));       
        StaticData.ekran.drawRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
        StaticData.ekran.drawRect(granicaOkna.getP1X()+1, granicaOkna.getP1Y()+1, granicaOkna.podajSzerokosc()-2, granicaOkna.podajWysokosc()-2);
        StaticData.ekran.drawRect(granicaOkna.getP1X()+2, granicaOkna.getP1Y()+2, granicaOkna.podajSzerokosc()-3, granicaOkna.podajWysokosc()-3);
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 20);
        StaticData.ekran.setFont(czcionkaMenu);
        StaticData.ekran.setColor(new Color(0, 0, 0));
        StaticData.ekran.drawString("Pause", granicaOkna.getP1X()+20, granicaOkna.getP1Y()+30);
        
    }
    
    public Border getWindowBorder() {
        return granicaOkna;
    }
    
}
