package PetSimulator;

public class Dragon extends Pet {
    public Dragon(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: WHAAAAAAAAAAAA!");
    }
    public void fly() {
        happiness += 5;
        if (happiness > 100) happiness = 100;
        System.out.println(name + " flew. Happiness: " + happiness);
    }
}
