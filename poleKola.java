Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        double r = in.nextDouble();
        double d = in.nextDouble();
        
        double p = (Math.pow(r, 2)- Math.pow(d, 2) / 4) * 3.141592654;
        int precision = 2;
        BigDecimal bigDecimal = new BigDecimal(p);
        bigDecimal = bigDecimal.setScale(precision, RoundingMode.HALF_UP);
        
        System.out.println(bigDecimal);
