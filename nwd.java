Scanner in = new Scanner(System.in);
       
        System.out.println("Podaj liczbę testów: ");
        int t = in.nextInt();
        for(int i=1; i <= t; i++){
            boolean valid = true;
            int a = in.nextInt();
            int b= in.nextInt();
            while(valid){             
                int wynik = a % b;
                if(wynik == 0) {
                    System.out.println(b);
                    valid = false;
                } else if (wynik != 0) {
                    a = b;
                    b = wynik;
                }
            }
        }