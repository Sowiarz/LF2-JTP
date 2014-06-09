package lf2.jtp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Klasa odpowiedzialna za wyznaczanie celu dla każdego gracza
 * 
 */
public class Destination {
    private Queue<Point> cele = new LinkedList<Point>();
        
    /**
     * Konstruktor obiektu
     */
    public Destination() {
        
    }

    /**
     *  Konstruktor obiektu
     * @param x współrzędna X obiektu
     * @param y współrzędna Y obiektu
     */
    public Destination(int x, int y) {
        Point punkt = new Point(x, y);
        cele.add(punkt);
    }

    /**
     * Dodanie nowego celu
     * @param x współrzędna x celu
     * @param y współrzędna y celu
     */
    public void addDestination(int x, int y) {
        Point punkt = new Point(x, y);
        cele.add(punkt);
    }

    /**
     * Dodanie nowego celu
     * @param o podanie nowego celu jako Point 
     */
    public void addDestination(Point o) {
        cele.add(o);
    }

    /**
     * usunięcie obecnego celu
     */
    public void deleteDestination() {
        cele.remove();
    }

    /**
     * zwrócenie obecnego celu
     * @return obecny cel
     */
    public Point getDestination() {
        return cele.element();
    }

    /**
     * Usunięcie wszystkich zapisanych celów
     */
    public void deleteAllDestinations() {
        cele.removeAll(cele);
    }

    /**
     * Sprawdzanie czy lista celów jest pusta
     * @return jeśli jest pusta zwraca true, w przeciwnym razie false
     */
    public boolean isEmpty() {
        if(cele.size() == 0) {
            return true;
        }
        else
            return false;
    }

    /**
     * Zwraca liczbę celów w liście
     * @return liczba celów
     */
    public int getNumber() {
        return cele.size();
    }
    
    
}
