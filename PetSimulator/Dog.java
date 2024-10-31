package PetSimulator;

public class Dog extends Pet {
    
    public Dog(String name) {
        super(name, PetType.DOG);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof woof!");
    }

    public void fetch() {
        if (energy >= 10) {
            happiness += 10;
            energy -= 10;
            if (happiness > 100) happiness = 100;
            System.out.println(name + " played fetch. Happiness: " + happiness + ", Energy: " + energy);
        } else {
            System.out.println(name + " is too tired to fetch.");
        }
    }
}