package lf2.jtp;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * Klasa odpowiedzialna za tworzenie nowych okienek do komunikatów 
 */
public class Window {
    
    private Point p1;
    private Point p2;
    private int wysokoscOkna;
    private int szerokoscOkna;
    private Border granicaOkna;
    
    /**
     * Konstruktor nowego okienka
     * @param width szerokość nowego okienka
     * @param height wysokośc nowego okienka
     */
    public Window(int width, int height) {
        wysokoscOkna = height;
        szerokoscOkna = width;
        
        p1 = new Point(StaticData.obliczPolozenieSrodkowe(StaticData.screenWidth, szerokoscOkna), StaticData.obliczPolozenieSrodkowe(StaticData.screenHeight, wysokoscOkna));
        p2 = new Point(p1.getX()+szerokoscOkna, p1.getY()+wysokoscOkna);
        granicaOkna = new Border(p1, p2);
    }

    /**
     * Konstruktor nowego okienka
     * @param pozx pozycja lewego górnego rogu okienka - współrzędna X
     * @param pozy pozycja lewego górnego rogu okienka - współrzędna Y
     * @param width szerokość nowego okienka
     * @param height wysokośc nowego okienka
     */
    public Window(int pozx, int pozy, int width, int height) {
        wysokoscOkna = height;
        szerokoscOkna = width;
        
        p1 = new Point(pozx, pozy);
        p2 = new Point(p1.getX()+szerokoscOkna, p1.getY()+wysokoscOkna);
        granicaOkna = new Border(p1, p2);
    }
    
    /**
     * Dodaje obramowanie do okienka o zadanym kolorze
     * @param c kolor
     */
    public void zrobObramowanie(Color c) {
        StaticData.ekran.setColor(c);       
        StaticData.ekran.drawRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
        StaticData.ekran.drawRect(granicaOkna.getP1X()+1, granicaOkna.getP1Y()+1, granicaOkna.podajSzerokosc()-2, granicaOkna.podajWysokosc()-2);
        StaticData.ekran.drawRect(granicaOkna.getP1X()+2, granicaOkna.getP1Y()+2, granicaOkna.podajSzerokosc()-3, granicaOkna.podajWysokosc()-3);
    }

    /**
     * Dodaje obramowanie do okienka
     */
    public void zrobObramowanie() {
        StaticData.ekran.setColor(new Color(0, 0, 255));       
        StaticData.ekran.drawRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
        StaticData.ekran.drawRect(granicaOkna.getP1X()+1, granicaOkna.getP1Y()+1, granicaOkna.podajSzerokosc()-2, granicaOkna.podajWysokosc()-2);
        StaticData.ekran.drawRect(granicaOkna.getP1X()+2, granicaOkna.getP1Y()+2, granicaOkna.podajSzerokosc()-3, granicaOkna.podajWysokosc()-3);
    }

    /**
     * Wypełnia tło okienka
     */
    public void wypelijTlo() {
        StaticData.ekran.setColor(new Color(255, 255, 255));       
        StaticData.ekran.fillRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
    }

    /**
     * Wypełnia tło okienka wybranym kolorem
     * @param c kolor
     */
    public void wypelijTlo(Color c) {
        StaticData.ekran.setColor(c);       
        StaticData.ekran.fillRect(granicaOkna.getP1X(), granicaOkna.getP1Y(), granicaOkna.podajSzerokosc(), granicaOkna.podajWysokosc());
    }

    /**
     * Ustawia czcionkę do okienka
     */
    public void ustawCzcionke() {
        Font czcionkaMenu = new Font("Arial", Font.BOLD, 20);
        StaticData.ekran.setFont(czcionkaMenu);
        StaticData.ekran.setColor(new Color(0, 0, 0));
    }
    
    /**
     * Gotowe okienko Pauzy
     */
    public void oknoPause() {
        wypelijTlo();
        zrobObramowanie();  
        ustawCzcionke();

        StaticData.ekran.drawString("Pause", granicaOkna.getP1X()+20, granicaOkna.getP1Y()+30);
        
    }
    
    /**
     * Przycisk "nowa gra" 
     */
    public void oknoStart() {
        StaticData.ekran.drawImage(LoadImage.newGame, granicaOkna.getP1X(), granicaOkna.getP1Y(), null);
        
        //StaticData.ekran.drawString("Nowa Gra", granicaOkna.getP1X()+20, granicaOkna.getP1Y()+30);
        //StaticData.ekran.drawString("Ustawienia", granicaOkna.getP1X()+20, granicaOkna.getP1Y()+60);
        
        
    }
    
    /**
     * Okienko z logiem gry
     */
    public void oknoZNazwa() {
//        wypelijTlo();
//        zrobObramowanie();
//        ustawCzcionke();
//        StaticData.ekran.drawString("Little Fighter", granicaOkna.getP1X()+10, granicaOkna.getP1Y()+30);
        StaticData.ekran.drawImage(LoadImage.nazwa, granicaOkna.getP1X(), granicaOkna.getP1Y(), 360, 50, null);
    }
    
    /**
     * Sprawdza czy okienko zostało klikniętę
     * @param p punkt kliknięcie
     * @return jeśli użytkownik trafił w okienko zwraca true, false w pozostałym przypadku 
     */
    public boolean ifWindowClicked(Point p) {
        return granicaOkna.czyNalezy(p);
    }

    /**
     * Zwraca obramowanie okna
     * @return obiekt reprezentujący obramowanie okna
     */
    public Border getWindowBorder() {
        return granicaOkna;
    }
    
}
