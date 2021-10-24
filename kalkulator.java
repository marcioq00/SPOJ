int result = 0;        
        Scanner in = new Scanner(System.in);             
        char operator;
        boolean validData= true;
      
        while(in.hasNext()) {        
             operator = in.next().charAt(0);
             int a = in.nextInt();
             int b = in.nextInt();                                                                            
          
             switch(operator) {
             case '+':
                 result = a + b;   
                 System.out.println(result);                
                 break;
              case '-': 
                 result = a - b;
                 System.out.println(result);               
                 break;
              case '*': 
                 result = a * b;  
                 System.out.println(result);                   
                 break;
              case '/':
                 result = a / b;
                 System.out.println(result); 
                // validData = false;
                 break;
              case '%':
                 result = a % b;  
                 System.out.println(result);                  
                 break;  
              default: 
                  validData = false;
                  break;
                 
             }

                                                                                   
      }