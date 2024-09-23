package activity2;
import java.util.ArrayList;
import java.util.Scanner;

public class CarSystem {
    private ArrayList<Car> cars = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addCar() {
        System.out.println("Enter Car Details:");
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("Color: ");
        String color = sc.nextLine();

     
        if (isCarExists(brand, model, year, color)) {
            System.out.println("Error: A car with the same brand, model, year, and color already exists.");
            return;
        }

//para e add niya ang car kung wala pa
        Car newCar = new Car(brand, model, year, color);
        cars.add(newCar);
        System.out.println("Car added successfully!");
    }

    private boolean isCarExists(String brand, String model, int year, String color) {
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand) &&
                car.getModel().equalsIgnoreCase(model) &&
                car.getYear() == year &&
                car.getColor().equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    public void displayCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car car : cars) {
                car.displayInfo();
            }
        }
    }

    public Car selectCar() {
        if (cars.isEmpty()) {
            System.out.println("No cars available to select.");
            return null;
        }

        displayCars();
        int index = getValidIntegerInput("Select a car by its number (1 - " + cars.size() + "): ");
        if (index < 1 || index > cars.size()) {
            System.out.println("Invalid selection.");
            return null;
        }
        return cars.get(index - 1);
    }

    public void compareTwoCars() {
        if (cars.size() < 2) {
            System.out.println("Not enough cars to compare.");
            return;
        }

        System.out.println("Select the first car to compare:");
        Car car1 = selectCar();

        System.out.println("Select the second car to compare:");
        Car car2 = selectCar();

        if (car1 != null && car2 != null) {
            car1.compareCarYear(car2);
        }
    }

    private int getValidIntegerInput(String prompt) {
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
