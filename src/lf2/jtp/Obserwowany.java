package lf2.jtp;

/**
 * Wzorzec projektowy obserwator
 * @author Krzysiek
 */
public interface Obserwowany {

    /**
     * Dodanie nowego obserwatora
     * @param o Klasa która będzie obserwowała
     */
    public void dodajObserwatora(Obserwator o);

    /**
     * Usunięcie obserwatora
     * @param o Klasa która obserwowała
     */
    public void usunObserwatora(Obserwator o);

    /**
     * Powiadamianie wszystkich dodanych obserwatorów o zmianach na obecnym obiekcie
     * @param o Zaistniałe zmiany
     */
    public void powiadamiajObserwatorow(Object o);
}