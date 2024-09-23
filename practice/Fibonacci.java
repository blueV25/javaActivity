package practice;


public class Fibonacci{
    public static void main(String[] args) {



        int f1 = 0;
        int f2 = 1;


System.out.print(F(18)); // the 17th fibonacci number using recursion

System.out.println("");
//******************************************************************************************** */
        for(int i = 0 ; i < 18 ;i++ ){              //forloop 
            
            int Ff = f1 + f2;

            System.out.print(Ff + " ");
            
             f1 = f2;

             f2 = Ff;

        }
    }




//****************************************************************************************** */
        // fibonacci using recursion

public static int F(int n){

    if( n <= 1){
        return n ;

        
    } else {
        return F(n - 1) + F(n-2);
    }
    }


}


      