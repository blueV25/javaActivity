import java.util.*;

public class number12 {
    





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter quantity: ");
        int q = sc.nextInt();

    
  int price1 = 30;
  int price2 = 50;
  int price3 = 70;
 
  
  int total;
  
  if(q > 100){
    total = price1 * q;
    System.out.println(total);
    

  } else if(q > 50 && q < 100){
    total = price2 * q;
System.out.println(total);

  } else {
    total = price3 * q;
    System.out.println(total);
  }



sc.close();




//ask user for quantity , if buying over 100 price is 30 ,if buying over 50 price is 50, else price is 70






    }
}

    
