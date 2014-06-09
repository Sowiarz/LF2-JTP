package lf2.jtp;

/**
 * Wzorzec projektory Obserwator
 * 
 */
public interface Obserwator {

    /**
     * Odbieranie informacji od obserwowanego obiektu
     * @param o przesłane zdarzenie
     */
    public void update(Object o);
}