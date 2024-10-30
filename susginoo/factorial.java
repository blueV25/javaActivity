
import java.math.BigInteger;
import java.util.Scanner;
public class factorial{

    public static void main(String []args){
    
        Scanner sc = new Scanner(System.in);

System.out.print("Enter a Number: ");
        int n = sc.nextInt();

    
      
       BigInteger f = BigInteger.ONE;

       for (int i = 1; i <= n ;i++) {
        
        f = f.multiply(BigInteger.valueOf(i));

         
           System.out.println(f );
  
           
       }


    }
}