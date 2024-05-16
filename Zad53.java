package zad53;

/**
 *
 * @author Marek Jóskowiak
 */
import java.util.*;

class Graf {
    private int n; // liczba wierzchołków, V = {0,1,...,n-1}
    private LinkedList<Integer>[] tab; // tablica wierzchołków połączonych z danym wierzchołkiem

    @SuppressWarnings("unchecked")
    public Graf(String lan) {
        StringTokenizer st = new StringTokenizer(lan, "() ,");
        n = Integer.parseInt(st.nextToken());
        tab = new LinkedList[n];
        for (int i = 0; i < n; ++i)
            tab[i] = new LinkedList<>();
        while (st.hasMoreTokens()) {
            tab[Integer.parseInt(st.nextToken())].add(
                Integer.parseInt(st.nextToken()));
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(i).append(": ");
            for (Integer vertex : tab[i]) {
                sb.append(vertex).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class Zad53 {
    public static void main(String[] args) {
        Graf g = new Graf("4, (0,1), (1,2), (3,0), (1,3)");
        System.out.println(g.toString());
    }
}
