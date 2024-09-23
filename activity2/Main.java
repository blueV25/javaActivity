package activity2;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static CarSystem carSystem = new CarSystem();
   
    public static void main(String[] args) {
        while (true) {
            displayMainMenu();
            int choice = getValidIntegerInput("Select from the Menu: ");
            handleMenuChoice(choice);
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add a Car");
        System.out.println("2. Display All Cars");
        System.out.println("3. Start Car Engine");
        System.out.println("4. Stop Car Engine");
        System.out.println("5. Compare Two Cars");
        System.out.println("6. Exit");
    }

    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
              
             carSystem.addCar();
             break;



            case 2:
                carSystem.displayCars();
                break;
            case 3:
                Car carToStart = carSystem.selectCar();
                if (carToStart != null) {
                    carToStart.startEngine();
                }
                break;
            case 4:
                Car carToStop = carSystem.selectCar();
                if (carToStop != null) {
                    carToStop.stopEngine();
                }
                break;
            case 5:
                carSystem.compareTwoCars();
                break;
            case 6:
                System.out.println("Exiting the program.");
                sc.close();
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a number between 1 and 6.");
        }
    }


    private static int getValidIntegerInput(String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

 
}
