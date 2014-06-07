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
    public Window(int pozx, int pozy, int width, int height) {
        wysokoscOkna = height;
        szerokoscOkna = width;
        
        p1 = new Point(pozx, pozy);
        p2 = new Point(p1.getX()+szerokoscOkna, p1.getY()+wysokoscOkna);
        granicaOkna = new Border(p1, p2);
    }
    
    public void zrobObramowanie(Color c) {
        StaticData.ekran.setColor(c);       
        StaticData.ekran.drawRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
        StaticData.ekran.drawRect(granicaOkna.getP1X()+1, granicaOkna.getP1Y()+1, granicaOkna.podajSzerokosc()-2, granicaOkna.podajWysokosc()-2);
        StaticData.ekran.drawRect(granicaOkna.getP1X()+2, granicaOkna.getP1Y()+2, granicaOkna.podajSzerokosc()-3, granicaOkna.podajWysokosc()-3);
    }
    public void zrobObramowanie() {
        StaticData.ekran.setColor(new Color(0, 0, 255));       
        StaticData.ekran.drawRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
        StaticData.ekran.drawRect(granicaOkna.getP1X()+1, granicaOkna.getP1Y()+1, granicaOkna.podajSzerokosc()-2, granicaOkna.podajWysokosc()-2);
        StaticData.ekran.drawRect(granicaOkna.getP1X()+2, granicaOkna.getP1Y()+2, granicaOkna.podajSzerokosc()-3, granicaOkna.podajWysokosc()-3);
    }
    public void wypelijTlo() {
        StaticData.ekran.setColor(new Color(255, 255, 255));       
        StaticData.ekran.fillRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
    }
    public void wypelijTlo(Color c) {
        StaticData.ekran.setColor(c);       
        StaticData.ekran.fillRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
    }
    public void ustawCzcionke() {
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 20);
        StaticData.ekran.setFont(czcionkaMenu);
        StaticData.ekran.setColor(new Color(0, 0, 0));
    }
    
    
    public void oknoPause() {
        wypelijTlo();
        zrobObramowanie();  
        ustawCzcionke();

        StaticData.ekran.drawString("Pause", granicaOkna.getP1X()+20, granicaOkna.getP1Y()+30);
        
    }
    
    public void oknoStart() {
        StaticData.ekran.drawImage(LoadImage.newGame, granicaOkna.getP1X(), granicaOkna.getP1Y(), null);
        
        //StaticData.ekran.drawString("Nowa Gra", granicaOkna.getP1X()+20, granicaOkna.getP1Y()+30);
        //StaticData.ekran.drawString("Ustawienia", granicaOkna.getP1X()+20, granicaOkna.getP1Y()+60);
        
        
    }
    
    public void oknoZNazwa() {
//        wypelijTlo();
//        zrobObramowanie();
//        ustawCzcionke();
//        StaticData.ekran.drawString("Little Fighter", granicaOkna.getP1X()+10, granicaOkna.getP1Y()+30);
        StaticData.ekran.drawImage(LoadImage.nazwa, granicaOkna.getP1X(), granicaOkna.getP1Y(), 360, 50, null);
    }
    
    public boolean ifWindowClicked(Point p) {
        return granicaOkna.czyNalezy(p);
    }
    public Border getWindowBorder() {
        return granicaOkna;
    }
    
}
