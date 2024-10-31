package PetSimulator;

public class Cat extends Pet {
    
    public Cat(String name) {
        super(name, PetType.CAT);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow meow!");
    }

    public void scratch() {
        happiness += 5;
        if (happiness > 100) happiness = 100;
        System.out.println(name + " scratched. Happiness: " + happiness);
    }
}