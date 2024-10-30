package firstyear;

import java.util.Scanner;

public class SeasonDeterminer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Please enter month [1 - 12]: ");
        int month = sc.nextInt();


        if(!(month >= 1 && month <= 12)){                             
            System.out.println("Invalid input. Please try again.");
            System.exit(0);                                        
        }


        System.out.print("Please enter hemisphere [N / S]: ");
        char hemisphere = sc.next().charAt(0);

        

    



        if(hemisphere == 'N' || hemisphere == 'n'){ 
            if(month == 12 || month == 1 || month == 2){               
                System.out.println("Winter");
            }else if(month == 6 || month == 7 || month == 8){
                System.out.println("Spring");
            }else if(month == 9 || month == 10 || month == 11){
                System.out.println("Summer");
            }else{
                System.out.println("Fall");
            }
        }else if(hemisphere == 'S' || hemisphere == 's'){
            if(month == 12 || month == 1 || month == 2){
                System.out.println("Summer");
            }else if(month == 6 || month == 7 || month == 8){
                System.out.println("Fall");
            }else if(month == 9 || month == 10 || month == 11){
                System.out.println("Winter");
            }else{
                System.out.println("Spring");
            }
        }else{
            System.out.println("Invalid input. Please try again.");        
            System.exit(0);                                            
        }
    }
}
    

