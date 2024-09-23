package activity;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static studentsystem student_s = new studentsystem(); 

    public static void main(String[] args) {
        System.out.println("");

        while (true) {
            displayMainMenu();
            int choices = getValidIntegerInput("Select from the Menu: ");
            handleMenuChoice(choices);
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Sort Students");
        System.out.println("4. Find Student by ID");
        System.out.println("5. Close");
    }

    private static void handleMenuChoice(int choices) {
        switch (choices) {
            case 1:
                student_s.addStudent();
                break;

            case 2:
                if (!student_s.Students.isEmpty()) {
                    student_s.displayAllStudent();
                } else {
                    System.out.println("No students available.");
                }
                break;

            case 3:
                if (!student_s.Students.isEmpty()) {
                    displaySortMenu();
                } else {
                    System.out.println("No students available to sort.");
                }
                break;

            case 4:
                if (!student_s.Students.isEmpty()) {
                    findStudentById();
                } else {
                    System.out.println("No students record found!");
                }
                break;

            case 5:
                System.out.println("Exiting the program.");
                sc.close();
                System.exit(0);
                break;

            default:
                System.out.println("Please enter a number between 1 and 5.");
                break;
        }
    }

    private static void displaySortMenu() {
        System.out.println(
            "1. Sort by Name\n" +
            "2. Sort by GPA"
        );
        int sortChoice = getValidIntegerInput("Enter number: ");
        
        switch (sortChoice) {
            case 1:
                student_s.sort_students_by_name();
                student_s.displayAllStudent();
                break;
            case 2:
                student_s.sort_studentsbygpa();
                student_s.displayAllStudent();
                break;
            default:
                System.out.println("Please Select from the Choices.");
                break;
        }
    }

    private static void findStudentById() {
        int id = getValidIntegerInput("Enter Student ID: ");
        student_s.find_students_by_id(id);
    }

    private static int getValidIntegerInput(String prompt) {
        int input;
        while (true) {
            try {
                if (!prompt.isEmpty()) {
                    System.out.print(prompt);
                }
                input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer.");
                sc.nextLine();  
            }
        }
    }
}
