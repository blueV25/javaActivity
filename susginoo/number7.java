import java.util.Scanner;
public class number7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

System.out.print("Enter day portion of the month: ");
int D = sc.nextInt();


if (D<1 || D>31) {
    System.out.print("Error Message");
}

sc.close();
    }
}
