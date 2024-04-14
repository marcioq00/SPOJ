package zadanie;

/**
 *
 * @author Marek Jóskowiak
 */
abstract class Wielomian {
    abstract void wypiszMiejscaZerowe();
}

class FunkcjaLiniowa extends Wielomian {
    private double a;
    private double b;

    FunkcjaLiniowa(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    void wypiszMiejscaZerowe() {
        if (a != 0) {
            System.out.println(-b / a);
        } else {
            System.out.println("brak");
        }
    }
}

class FunkcjaKwadratowa extends Wielomian {
    private double a;
    private double b;
    private double c;

    FunkcjaKwadratowa(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    void wypiszMiejscaZerowe() {
        double delta = (b * b) - 4 * a * c;
        if (delta < 0) {
            System.out.println("brak");
        } else if (delta == 0) {
            System.out.println(-b / (2 * a));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }
}
public class Zadanie {

   public static void main(String[] args) {
        Wielomian w[] = new Wielomian[3];
        w[0] = new FunkcjaLiniowa(2, 1); // 2x + 1
        w[1] = new FunkcjaKwadratowa(1, -2, 2); // x*x - 2x + 2
        w[2] = new FunkcjaKwadratowa(1, 0, -1); // x*x - 1
        for (int i=0; i<3; i++) {
            w[i].wypiszMiejscaZerowe();
        }
    }
    
}
