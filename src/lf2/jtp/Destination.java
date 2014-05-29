package lf2.jtp;

import java.util.LinkedList;
import java.util.Queue;

public class Destination {
    private Queue<Point> cele = new LinkedList<Point>();
        
    public Destination() {
        
    }
    public Destination(int x, int y) {
        Point punkt = new Point(x, y);
        cele.add(punkt);
    }
    public void addDestination(int x, int y) {
        Point punkt = new Point(x, y);
        cele.add(punkt);
    }
    public void addDestination(Point o) {
        cele.add(o);
    }
    public void deleteDestination() {
        cele.remove();
    }
    public Point getDestination() {
        return cele.element();
    }
    public void deleteAllDestinations() {
        cele.removeAll(cele);
    }
    public boolean isEmpty() {
        return cele.isEmpty();
    }
    
    
    
}
