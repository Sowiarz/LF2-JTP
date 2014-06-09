
package lf2.jtp;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

/**
 *  Klasa trzymająca sterowanie dla każdego gracza indywidualnie
 * 
 */
public class ControlPlayer {
    private int Left;
    private int Right;
    private int Down;
    private int Up;
    private int Hit;
    
    /**
     * Konstruktor nowego sterowania
     * @param r przycisk w prawo
     * @param l przycisk w lewo
     * @param u przycisk w górę
     * @param d przycisk w dół
     * @param h przycisk odpowiedzialny za uderzenia
     */
    public ControlPlayer(int r, int l, int u, int d, int h) {
        Left = l;
        Down = d;
        Right = r;
        Up = u;
        Hit = h;
    }

    /**
     * Konstruktor
     */
    public ControlPlayer() {
        this(0, 0, 0, 0, 0);
    }

    /**
     * Ustawienie poruszania się do góry
     * @param i klawisz
     */
    public void setUp(int i) {
        Up = i;
    }

    /**
     * Ustawienie poruszania się na doł
     * @param i klawisz
     */
    public void setDown(int i) {
        Down = i;
    }

    /**
     * Ustawienie poruszania się w prawo
     * @param i klawisz
     */
    public void setRight(int i) {
        Right = i;
    }

    /**
     * Ustawienie poruszania się w lewo
     * @param i klawisz
     */
    public void setLeft(int i) {
        Left = i;
    }

    /**
     * Ustawienie uderzenia
     * @param i klawisz
     */
    public void setHit(int i) {
        Hit = i;
    }

    /**
     *  Zwraca klawisz odpowiedzialny za poruszanie się do góry
     * @return klawisz
     */
    public int getUp() {
        return Up;
    }

    /**
     *  Zwraca klawisz odpowiedzialny za poruszanie się w dół
     * @return klawisz
     */
    public int getDown() {
        return Down;
    }

    /**
     *  Zwraca klawisz odpowiedzialny za poruszanie się w lewo
     * @return klawisz
     */
    public int getLeft() {
        return Left;
    }

    /**
     *  Zwraca klawisz odpowiedzialny za poruszanie się w prawo
     * @return klawisz
     */
    public int getRight() {
        return Right;
    }

    /**
     *  Zwraca klawisz odpowiedzialny za uderzenia
     * @return klawisz
     */
    public int getHit() {
        return Hit;
    }
    
}
