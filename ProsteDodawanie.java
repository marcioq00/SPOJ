 Scanner input = new Scanner(System.in);

            int zestaw, iloscLiczb, temp;
            int suma=0;
            zestaw = input.nextInt();

            for (int i = 0; i < zestaw; i++) {
                iloscLiczb = input.nextInt();

            for (int j = 0; j < iloscLiczb; j++) {
                temp = input.nextInt();
                suma += temp;          
            }
             System.out.println(suma);
             suma=0;
            }