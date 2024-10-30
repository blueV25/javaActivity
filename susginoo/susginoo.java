import java.util.Scanner;
public class susginoo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int n = sc.nextInt();

       

        if(n >= 9 && n<=99 ){
                    System.out.println("The Number you enter is 2 digits");

                }else if(n >=100 && n<=999){
                    System.out.println("3 digits");

                }else if(n >=1000 && n<=9999){
                    System.out.println("4 digits");

                }else if(n>= 10000 && n<=99999){
                    System.out.println("5 digits");

                }else if (n>= 100000 && n<=999999){
                    System.out.println("6 digits");


     } else {
        System.out.println("Error");
        }

sc.close();
    }
    
}
