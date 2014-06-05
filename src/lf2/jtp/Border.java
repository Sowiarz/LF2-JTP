package lf2.jtp;

public class Border {
    private Point punkt1;
    private Point punkt2;

    public Border(Point p1, Point p2) {
        punkt1 = p1;
        punkt2 = p2;
    }
    
    public int podajSzerokosc() {
        return punkt2.getX()-punkt1.getX();
    }
    
    public int podajWysokosc() {
        return punkt2.getY()-punkt1.getY();
    }
    public int getP1X() {
        return punkt1.getX();
    }
    public int getP1Y() {
        return punkt1.getY();
    }
    public boolean czyNalezy(Point p) {
        if(p.getX() >= punkt1.getX() && p.getX() <= punkt2.getX() && p.getY() >= punkt1.getY() && p.getY() <= punkt2.getY())
            return true;
        else
            return false;
    }
    
    
    
}
