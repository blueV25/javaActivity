package practice;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public void register() {
        System.out.print("Enter Name: ");
        String N = sc.nextLine();

        System.out.print("Enter LastName: ");
        String LN = sc.nextLine();

        System.out.print("Enter Gender: ");
        String G = sc.nextLine();

        System.out.print("Enter Age: ");
        int A = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline

        // Correct class name from 'person' to 'Person'
        Person newPerson = new Person(N, LN, G, A);

        System.out.println(newPerson);
    }

    public static void main(String[] args) {
        Main R = new Main();
        R.register();
    }
}
