/* Eoin Lynch - C17310846
 * Advanced Security 1
 * Assignment 1 */

package assign1;

public class MilRabAlg 
{  
    // modular exponention
    static int power(int x, int y, int z) 
    { 
        int result1 = 1;
          
        x = x % z;  
  
        while (y > 0) 
        { 
            // If y is odd, make it even with x
            if ((y & 1) == 1) 
            	result1 = (result1 * x) % z; 
          

            y = y / 2;
            x = (x * x) % z;
        }
         
        return result1; 
    }
      
    /* repeats depending how many times user wants to iterate
       returns false if n is composite or if n is probably prime.
       m is an odd number. */
    static boolean MilRabTest(int m, int n) 
    {        
        // Pick a random number in [2..n-2] 
        int a = 2 + (int)(Math.random() % (n - 4)); 
        
        
        int x = power(a, m, n); 
      
        
        if (x == 1 || x == n - 1) 
            return true; 
      
        // Keeps squaring x until m does not reach n-1, (x^2) % n is not 1 or (x^2) % n is not n-1

        while (m != n - 1) 
        {
        	
            x = (x * x) % n; 
            m *= 2; 
      
            
            if (x == 1) 
                return false; 
            if (x == n - 1) 
                return true; 
        } 
        
        // returns  composite
        return false; 
    } 
      
    
    // If n is composite this return false or if n is prime it returns true, iteration can be used to describe accuracy
    boolean isPrime(int n, int iter) 
    
    {          
        // Corner cases 
        if (n <= 1 || n == 4) 
            return false; 
        
        if (n <= 3) 
            return true; 
      
        int m = n - 1; 
          
        
        while (m % 2 == 0) 
            m /= 2;
      
        
        // Repeats as many times as user asked
        for (int i = 0; i < iter; i++) 
            if (!MilRabTest(m, n))
                return false;
      
        return true; 
    }
}