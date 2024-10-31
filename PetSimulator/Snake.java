package PetSimulator;

public class Snake extends Pet {

    public Snake(String name) {
        super(name, PetType.SNAKE);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: HI , POGI ");
    }
    public void slither() {
        if (energy >= 10) {
            happiness += 10;
            energy -= 10;
            if (happiness > 100) happiness = 100;
            System.out.println(name + " is slithering. Happiness: " + happiness + ", Energy: " + energy);
        } else {
            System.out.println(name + " is too tired to slither.");
        }
    }
    
}
