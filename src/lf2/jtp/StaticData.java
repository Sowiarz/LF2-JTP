package lf2.jtp;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa trzymająca wszystkie ustawienia gry
 *
 */
public class StaticData {
   
    // pola startczne do użytku w całej aplikacji

    /**
     * Zmienana trzymająca obiekt renderowania ekranu
     */
        public static Graphics2D ekran; // trzyma obiekt "g" czyli uchwyt do rysowania

    /**
     * Szerokość ekranu gracza
     */
    public static int screenWidth; // szerokosc ekranu

    /**
     * Wysokość ekranu gracza
     */
    public static int screenHeight; // wysokość ekranu
    
    // Obiekty odpowiedzialne za obsługę myszy i klawiatury
    
    /** 
     * zmienna trzymjąca obsługę klawiatury
     */
        
    public static Control klawiatura;

    /**
     * zmienna trzymająca obsługę myszy
     */
    public static MouseControl mysz;
    
    // Obiekt menu

    /**
     * Zmienna trzymające wyświetlane w trakcie gry menu
     */
        public static Menu menu;
    
    // Wielkosc gracza
    
    /**
     * Zmienna trzymajace szerokość gracza
     */
        
    public static int playerWidth;

    /**
     * Zmienna trzymajace wysokość gracza
     */
    public static int playerHeight;
    
    // Zmienne pola rozgrywki gry - oznaczają marginesy

    /**
     * Lewy margines rozgrywki na ekranie
     */
        public static int x1 = 10;

    /**
     * Górny margines rozgrywki na ekranie
     */
    public static int y1 = 180;

    /**
     * Prawy margines rozgrywki na ekranie
     */
    public static int x2 = 10;

    /**
     * Dolny margines rozgrywki na ekranie
     */
    public static int y2 = 10;
    
    // listy z używanymi obiektami
    private static ArrayList<Player> gracze = new ArrayList<Player>();

    private static ArrayList<MedKit> apteczki = new ArrayList<MedKit>();
    
    private static ArrayList<Bomb> bomby = new ArrayList<Bomb>();
    
    // pola odpowiedzialne za ustawienia gry
    private static boolean pause = false;
    private static int readyGame = 0;
    
    
    private StaticData() {
        
    }
    
    //Zarządzenie graczami

    /**
     * Dodawanie nowego gracza
     * @param gracz nowy gracz
     * @return id gracza na liście
     */
        public static int addPlayer(Player gracz) {
        gracze.add(gracz);
        return gracze.indexOf(gracz);
    }

    /**
     * Zwraca obiekt gracza
     * @param id id na liście graczy
     * @return gracz
     */
    public static Player getPlayer(int id) {
        return gracze.get(id);
    }

    /**
     * Zwraca numer gracza na liście
     * @param Player gracz
     * @return id na liście
     */
    public static int getPlayerID(int Player) {
        return gracze.indexOf(Player);
    }

    /**
     * Zwraca ilośc graczy
     * @return ilość graczy
     */
    public static int getNumberOfPlayers() {
        return gracze.size();
    }
    // Zarządzanie apteczkami
    
    /**
     * Dodaje nową apteczkę do gry
     * @param o apteczka
     * @return id apteczki na liście
     */
    public static int addMedKit(MedKit o) {
        apteczki.add(o);
        return apteczki.indexOf(o);
    }

    /**
     * Zwraca obiekt apteczki
     * @param id id apteczki na liście
     * @return apteczka
     */
    public static MedKit getMedKit(int id) {
        return apteczki.get(id);
    }

    /**
     * Zwraca id apteczki na liście
     * @param MedKit apteczka
     * @return id apteczki
     */
    public static int getMedKitID(int MedKit) {
        return apteczki.indexOf(MedKit);
    }

    /**
     * Zwraca liczbę apteczek w grze
     * @return ilość apteczek
     */
    public static int getNumberOfMedKit() {
        return apteczki.size();
    }

    /**
     * Usuwa podaną apteczkę
     * @param o apteczka
     */
    public static void removeMedKit(MedKit o) {
        apteczki.remove(apteczki.indexOf(o));
    }
    
    // Zarządzanie bombami

    /**
     * Dodaje nową bombę
     * @param o bomba
     * @return id bomby na liście
     */
        public static int addBomb(Bomb o) {
        bomby.add(o);
        return bomby.indexOf(o);
    }

    /**
     * Zwraca bombę o podanym id
     * @param id id bomby
     * @return bomba
     */
    public static Bomb getBomb(int id) {
        return bomby.get(id);
    }

    /** 
     * Zwraca ID podanej bomby
     * @param Bomb bomba
     * @return id
     */
    public static int getBombID(int Bomb) {
        return bomby.indexOf(Bomb);
    }

    /**
     * Zwraca ilość bomb w grze
     * @return ilość bomb
     */
    public static int getNumberOfBomb() {
        return bomby.size();
    }

    /**
     * Usuwa podaną bombę z gry
     * @param o bomba
     */
    public static void removeBomb(Bomb o) {
        bomby.remove(bomby.indexOf(o));
    }
    
    
    // Dalsze opcje gry

    /**
     * Sprawdza czy jest włączona Pauza w grze
     * @return jeśli true to pauza jest włączona, jeśli false to jest wyłączona
     */
        public static boolean getPause() {
        return pause;
    }
    
    /**
     * Zwraca stan ustawienia gry
     * @return Jeśli 0 to gra wymaga ustawienia, jeśli 1 to jest w trakcie ustawień, jeśli 2 to gra ustawiona i jest gotowa
     */
    public static int getReady() {
        return readyGame;
    }
    
    /**
     * Ustawienie stanu gry
     * @param o 0 to gra wymaga ustawienia, 1 to gra jest w trakcie ustawiania, 2 to gra gotowa
     */
    public static void setReadyGame(int o) {
        readyGame = o;
    }
    
    /**
     * Włącza lub wyłącza pauzę w grze
     */
    public static void setPause() {
        pause = !pause;
    }
    
    /**
     * Usuwa podanego gracza
     * @param id numer id gracza na liście
     */
    public static void removePlayer(int id) {
        gracze.remove(id);
    }

    /**
     * Zwraca id gracza na liście
     * @param o gracz
     * @return id na liście
     */
    public static int IndexOf(Player o) {
        return gracze.indexOf(o);
    }
    // Losowanie danych
    
    /**
     * Losuje możliwe współrzędne X dla nowego gracza
     * @return współrzędne X
     */
    public static int losujSzerokosc() {
        return Math.abs((new Random().nextInt(screenWidth-x1-x2-playerWidth))+x1);
    }

    /**
     * Losuje możliwe współrzędne Y dla nowego gracza
     * @return współrzędne Y
     */
    public static int losujWysokosc() {
        return Math.abs((new Random().nextInt(screenHeight-y1-y2-playerHeight))+y1);        
    }

    /**
     * Oblicza odległość dwóch punktów od siebie
     * @param p1 punkt pierwszy
     * @param p2 punkt drugi
     * @return odległość bezwzględna
     */
    public static int odlegloscOdPunktow(Point p1, Point p2) {
        
        return (int) Math.sqrt((double)(((p2.getX()-p1.getX())*(p2.getX()-p1.getX()))+((p2.getY()-p1.getY())*(p2.getY()-p1.getY()))));
         
    }

    /**
     * Oblicza średnie położenie okna na ekranie
     * @param all szerokość/wysokość całego ekranu
     * @param length długość/szerokość okna
     * @return współrzędne wysokości/szerokość w którym należy umieścić okno
     */
    public static int obliczPolozenieSrodkowe(int all, int length) {
        int e,temp;
        e=(int)all/2;
        temp=(int)length/2;
        return e-temp;
    }
}
