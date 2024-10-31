package PetSimulator;

public class Bird extends Pet {

    public Bird(String name) {
        super(name, PetType.BIRD);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: Waaa... Waaaa!");
    }

    public void fetch() {
        if (energy >= 10) {
            happiness += 10;
            energy -= 10;
            if (happiness > 100) happiness = 100;
            System.out.println(name + " Flew around. Happiness: " + happiness + ", Energy: " + energy);
        } else {
            System.out.println(name + " is too tired to Fly.");
        }
    }
}

