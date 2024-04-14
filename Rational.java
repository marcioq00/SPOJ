package rational;

/**
 *
 * @author Marek Jóskowiak
 */

public class Rational {
    private int licznik;
    private int mianownik;
    
 public static void main(String[] args) {
        Rational r1 = new Rational(1,4);
        Rational r2 = new Rational(1,6);
        System.out.println(r1.add(r2)); // 5/12
        System.out.println(r1.mul(r2)); // 1/24
        System.out.println(r1.sub(r2)); // 1/12
        System.out.println(r1.div(r2)); // 3/2
        System.out.println(r1.equals(r2)); // false
        System.out.println(r1.compareTo(r2)); // 1 
        System.out.println(r1.toString()); // 1/4
    }
    private Rational(int licznik, int mianownik) {
        this.licznik = licznik;
        if (mianownik == 0) {
            throw new IllegalArgumentException("Mianownik nie może być zerem.");
        }
        this.mianownik = mianownik;
        simplifyFraction(); 
    }

    public Rational add(Rational arg) {
        int nowyLicznik = this.licznik * arg.mianownik + this.mianownik * arg.licznik;
        int nowyMianownik = this.mianownik * arg.mianownik;
        return new Rational(nowyLicznik, nowyMianownik);
    }

    public Rational mul(Rational arg) {
        int nowyLicznik = this.licznik * arg.licznik;
        int nowyMianownik = this.mianownik * arg.mianownik;
        return new Rational(nowyLicznik, nowyMianownik);
    }

    public Rational sub(Rational arg) {
        int nowyLicznik = this.licznik * arg.mianownik - this.mianownik * arg.licznik;
        int nowyMianownik = this.mianownik * arg.mianownik;
        return new Rational(nowyLicznik, nowyMianownik);
    }

    public Rational div(Rational arg) {
        if (arg.licznik == 0) {
            throw new IllegalArgumentException("Nie można dzielić przez zero.");
        }
        int nowyLicznik = this.licznik * arg.mianownik;
        int nowyMianownik = this.mianownik * arg.licznik;
        return new Rational(nowyLicznik, nowyMianownik);
    }

    public boolean equals(Rational arg) {
        double leftSide = (double) this.licznik / this.mianownik;
        double rightSide = (double) arg.licznik / arg.mianownik;
        return leftSide == rightSide;
    }

    public int compareTo(Rational arg) {
        if (equals(arg)) {
            return 0;
        }
        double firstValue = (double) this.licznik / this.mianownik;
        double secondValue = (double) arg.licznik / arg.mianownik;
        if (firstValue < secondValue) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString() {
        return licznik + "/" + mianownik;
    }

    private void simplifyFraction() {
        int nwd = nwd(Math.abs(licznik), Math.abs(mianownik));
        licznik = licznik / nwd;
        mianownik = mianownik / nwd;
        if (mianownik < 0) { 
            licznik = -licznik;
            mianownik = Math.abs(mianownik);
        }
    }

    private int nwd(int a, int b) { 
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
