package zad3.pkg2;

/**
 *
 * @author Marek Jóskowiak
 */

abstract class Wierzcholek {
    Wierzcholek lewy, prawy;
    public abstract int wartosc() throws ArithmeticException;
}

class Stala extends Wierzcholek {
    private int wart;
    public Stala(int x) {
        wart = x;
    }
    public int wartosc() {
        return wart;
    }
}

class Dzialanie extends Wierzcholek {
    private char op; // operator +, -, / lub *
    public Dzialanie(char znak) {
        op = znak;
    }
    public void dodajLewyArg(Wierzcholek arg) {
        lewy = arg;
    }
    public void dodajPrawyArg(Wierzcholek arg) {
        prawy = arg;
    }
    
    public int wartosc() throws ArithmeticException {
        int lewyWartosc, prawyWartosc;
        switch (op) {
            case '+': return lewy.wartosc() + prawy.wartosc();
            case '-': return lewy.wartosc() - prawy.wartosc();
            case '/':
                prawyWartosc = prawy.wartosc();
                if (prawyWartosc == 0) {
                    throw new ArithmeticException("Dzielenie przez zero");
                }
                lewyWartosc = lewy.wartosc();
                return lewyWartosc / prawyWartosc;
            case '*': return lewy.wartosc() * prawy.wartosc();
            default: throw new IllegalArgumentException("Niepoprawny operator");
        }
    }
}

class Wyrazenie {
    private Wierzcholek korzen;

    private Wierzcholek utworzDrzewo(String w, int p, int q) throws IllegalArgumentException {
        if (p == q) {
            if (Character.isDigit(w.charAt(p))) {
                return new Stala(Character.digit(w.charAt(p), 10));
            } else {
                throw new IllegalArgumentException("Niepoprawnie skonstruowane wyrażenie");
            }
        } else {
            int i = p + 1, nawiasy = 0;
            while (i < q && ((nawiasy != 0) || (w.charAt(i) == '(') ||
                   (w.charAt(i) == ')') || (Character.isDigit(w.charAt(i))))) {
                if (w.charAt(i) == '(') ++nawiasy;
                if (w.charAt(i) == ')') --nawiasy;
                ++i;
            }
            if (i >= w.length() || "+-*/".indexOf(w.charAt(i)) == -1) {
                throw new IllegalArgumentException("Niepoprawnie skonstruowane wyrażenie");
            }
            Dzialanie nowy = new Dzialanie(w.charAt(i));
            nowy.dodajLewyArg(utworzDrzewo(w, p + 1, i - 1));
            nowy.dodajPrawyArg(utworzDrzewo(w, i + 1, q - 1));
            return nowy;
        }
    }

    public Wyrazenie(String w) throws IllegalArgumentException {
        korzen = utworzDrzewo(w, 0, w.length() - 1);
    }

    public int oblicz() throws ArithmeticException {
        return korzen.wartosc();
    }
}

public class Zad32 {
    public static void main(String[] args) {
        try {
            Wyrazenie wyr = new Wyrazenie("(3*((1+2)-1))"); // 6
            //Wyrazenie wyr = new Wyrazenie("(8/(2-2))"); //Dzielenie przez zero
            //Wyrazenie wyr = new Wyrazenie("(3+)"); // Niepoprawnie skontruowane wyrazenie
            
            System.out.println("" + wyr.oblicz());
        } catch (ArithmeticException  | IllegalArgumentException e) {
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}
