

import java.util.*;


public class number13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter quantity: ");
        int q = sc.nextInt();

    
  int discount = 10;
  int discount1 = 20;
 
  
  int total;
  
  if(q >= 50 && q <= 99){

        total = 70 * q; //e update ang total
            System.out.println( total - (total * discount / 100));

      }else if(q >= 100){
       total = 70 * q ; //e update ang total
       System.out.println(total -  (total * discount1 / 100));


  }else{
    total = 70 * q;
    System.out.println(total);
  }


sc.close();

//ask user for quantity , if buying over 100 price is 30 ,if buying over 50 price is 50, else price is 70






    }
}
