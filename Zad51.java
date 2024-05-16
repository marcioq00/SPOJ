package zad51;

import java.util.*;

/**
 *
 * @author Marek Jóskowiak
 */
class Wspolrzedna implements Comparable<Wspolrzedna> {
    private int x, y;
    public Wspolrzedna(int _x, int _y) {
        x = _x;
        y = _y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
     @Override
    public int compareTo(Wspolrzedna other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y);
        }
    }
}
public class Zad51 {
    private static void wypiszElementy(TreeSet zbior) {
        Iterator it = zbior.iterator();
            while (it.hasNext()) {
            System.out.println((it.next()).toString());
        }
    }
    public static void main(String[] args) {
        TreeSet<Wspolrzedna> zbior = new TreeSet<>();
        zbior.add( new Wspolrzedna(2, 3) );
        zbior.add( new Wspolrzedna(-3, 0) );
        zbior.add( new Wspolrzedna(-1, 2) );
        zbior.add( new Wspolrzedna(-1, 2) ); //duplikat nie zostanie dodany
        zbior.add( new Wspolrzedna(-3, -2) );
        wypiszElementy(zbior);
    }
}
