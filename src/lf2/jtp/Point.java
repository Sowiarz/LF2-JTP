package lf2.jtp;

/**
 * Klasa odpowiedzialna za implementacje punktu
 * 
 */
public class Point {
    private int x;
    private int y;
    
    /**
     * Tworzenie nowego punktu
     * @param px współrzędna X
     * @param py współrzędna Y
     */
    public Point(int px, int py) {
        x = px;
        y = py;
    }
    
    /**
     * Ustawienie punktu
     * @param px współrzędna X
     * @param py współrzędna Y
     */
    public void setPoint(int px, int py) {
        x = px;
        y = py;  
    }

    /**
     * Zwraca współrzędną X punktu
     * @return współrzędna X
     */
    public int getX() {
        return x;
    }

    /**
     * Zwraca współrzędną Y punktu
     * @return współrzędna Y
     */
    public int getY() {
        return y;
    }
    
}
