package lf2.jtp;

/**
 * Klasa odpowiedzialna za obramowania okienek
 * 
 */
public class Border {
    private Point punkt1;
    private Point punkt2;

    /**
     * Konstruktor klasy
     * @param p1 punkt pierwszy
     * @param p2 punkt drugi
     */
    public Border(Point p1, Point p2) {
        punkt1 = p1;
        punkt2 = p2;
    }
    
    /**
     * Oblicza szerokość okienka okienka
     * @return szerokość 
     */
    public int podajSzerokosc() {
        return punkt2.getX()-punkt1.getX();
    }
    
    /**
     * Oblicza wysokość okienka
     * @return wysokość
     */
    public int podajWysokosc() {
        return punkt2.getY()-punkt1.getY();
    }

    /**
     *  Podaje współrzędną X początku okienka - lewy górny róg
     * @return współrzędna X
     */
    public int getP1X() {
        return punkt1.getX();
    }

    /**
     *  Podaje współrzędną Y początku okienka - lewy górny róg
     * @return współrzędna Y
     */
    public int getP1Y() {
        return punkt1.getY();
    }

    /**
     *  Sprawdza czy podany punkt lezy wewnątrz obramowania
     * @param p punkt do sprawdzenia
     * @return jeśli należy zwraca true
     */
    public boolean czyNalezy(Point p) {
        if(p.getX() >= punkt1.getX() && p.getX() <= punkt2.getX() && p.getY() >= punkt1.getY() && p.getY() <= punkt2.getY())
            return true;
        else
            return false;
    }
    
    
    
}
