  
  /*return a list containing all perfect number in a given range from input. 
  Perfect number is: sum of all its positive divisors == number / 2  */
  
  
  public static boolean isPerfectNumber(int number) {
        int sum=0;         
        for(int i=1; i<=number/2; i++) {
            if(number%i == 0) {
                sum += i;
            }
        }
          
        if(sum==number) { 
            return true;
        }else {
            return false;
        } 
    }
	
	

