package zad52;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wspolrzedna that = (Wspolrzedna) obj;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }
}

public class Zad52 {
    public static void main(String[] args) {
        HashMap<Wspolrzedna, String> mapa = new HashMap<>();
        mapa.put(new Wspolrzedna(2, 3), "czerwony");
        mapa.put(new Wspolrzedna(-3, 0), "czarny");
        mapa.put(new Wspolrzedna(-1, 2), "czerwony");
        mapa.put(new Wspolrzedna(2, -1), "czarny");

        Wspolrzedna w = new Wspolrzedna(-1, 2);
        System.out.println("Punkt " + w.toString() + " ma kolor " + mapa.get(w));
    }
}
