package zadanie3;

/**
 *
 * @author Marek Jóskowiak
 */

class Kolejka {
    static final int N = 5;
    private Object[] tab;
    private int pocz, zaost, lbel;

    public Kolejka() {
        pocz = 0;
        zaost = 0;
        lbel = 0;
        tab = new Object[N];
    }

    void doKolejki(Object el) throws Exception {
        if (lbel == N) {
            throw new Exception("Przepełniona kolejka!");
        }
        tab[zaost] = el;
        zaost = (zaost + 1) % N;
        ++lbel;
    }

    Object zKolejki() throws Exception {
        if (lbel == 0) {
            throw new Exception("Pusta kolejka!!");
        }
        int ind = pocz;
        pocz = (pocz + 1) % N;
        --lbel;
        return tab[ind];
    }
}

public class Zadanie3 {
    public static void main(String[] args) {
        Kolejka k = new Kolejka();
        try {
            k.zKolejki(); // Pusta kolejka
            k.doKolejki(new Integer(7));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new Double(3.14));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new String("Ala ma kota")); // Przepelnienie
            for (int i = 1; i <= 5; ++i)
                System.out.println((k.zKolejki()).toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
