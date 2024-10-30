import java.util.Scanner;
public class animal {
    public static void main(String []args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Animal ka? :");
        String  g = sc.nextLine();

        System.out.print("animal ka? :");
        int A = sc.nextInt();

        String gender = "M";
        String gender1 = "F";

        int age1 = ( 16 );
        

     if(g.equals(gender) && A < age1){
        System.out.print("Master");

         }else if(g.equals(gender) && A > age1){
        System.out.println("Mr.");

         }else if(g.equals(gender1) && A < age1){
        System.out.println("miss");
        

         }else if(g.equals(gender1) && A > age1){
        System.out.println("Ms");

     }



    }
}
