package rownaniekwadratowe;

import java.util.Scanner;

/**
 *
 * @author Marek Jóskowiak
 */
public class RownanieKwadratowe {

  
    private static double a,b,c,d;
    private static int liczbaMiejscZerowych;

    public static void main(String[] args) {
        try {
            ustawWspolczynniki();
            d = delta();
            liczbaMiejscZerowych = liczbaPierwiastkow(d);
            System.out.println("Delta = " + d);
            System.out.println("Liczba pierwiastków: " + liczbaMiejscZerowych);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1); 
        }
            
    }
    
    public static void ustawWspolczynniki(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Podaj a: ");
        a = sc.nextInt();
        if (a == 0) {
            throw new IllegalArgumentException("Współczynnik a nie może być równy zero.");
        } 
        System.out.println("Podaj b: ");
        b = sc.nextInt();
        System.out.println("Podaj c: ");
        c = sc.nextInt();
    }
    
    public static double delta() {
         double d;
         d = (b*b)-4*a*c;
         return d;       
    }
    
    public static int liczbaPierwiastkow(double d) {
        int mzerowe;
        if (d < 0) {
            mzerowe = 0;
        } else if ( d > 0){
            mzerowe = 2;
        } else {
            mzerowe = 1;
        }
        return mzerowe;
    }
  
}
