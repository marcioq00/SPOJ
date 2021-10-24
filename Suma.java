Scanner in = new Scanner(System.in);
       
        boolean validData = true;
        int j = 0;
       
        while(in.hasNextInt()) {
           int a = in.nextInt();
           j += a;
            System.out.println(j);
           
        }