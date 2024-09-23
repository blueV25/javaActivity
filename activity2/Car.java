package activity2;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isEngineRunning;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isEngineRunning = false; 
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEngineRunning() {
        return isEngineRunning;
    }

    public void setEngineRunning(boolean isEngineRunning) {
        this.isEngineRunning = isEngineRunning;
    }



    public void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("The engine of " + brand + " " + model + " has started.");
        } else {
            System.out.println("The engine is already running.");
        }
    }

    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("The engine of " + brand + " " + model + " has stopped.");
        } else {
            System.out.println("The engine is already off.");
        }
    }

    public void displayInfo() {
        System.out.println("**********************************");
        System.out.println("\tCar Information:");
        System.out.println("**********************************");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Engine Status: " + (isEngineRunning ? "Running" : "Stopped"));
        System.out.println();
        System.out.println("***********************************\n");
    }

    public void compareCarYear(Car otherCar) {
        if (this.year > otherCar.year) {
            System.out.println(this.brand + " " + this.model + " is newer than " + otherCar.brand + " " + otherCar.model);
        } else if (this.year < otherCar.year) {
            System.out.println(this.brand + " " + this.model + " is older than " + otherCar.brand + " " + otherCar.model);
        } else {
            System.out.println(this.brand + " " + this.model + " and " + otherCar.brand + " " + otherCar.model + " are from the same year.");
        }
    }
}
