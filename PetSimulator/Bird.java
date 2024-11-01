package PetSimulator;

/**
 * The Bird class represents a bird pet in the game.
 * The Bird has unique behaviors, including making a specific sound and playing fetch.
 */
public class Bird extends Pet {

    /**
     * make a bird pet with the specified name.
     * the name parameter is for the name of the bird pet.
     */
    public Bird(String name) {
        super(name, PetType.BIRD);
    }

    /**
     * Makes a sound specific to a bird pet and overide the makeSound method in the Pet class.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " says: Waaa... Waaaa!");
    }

    /**
     * Allows the bird to play fetch and increase the happiness level of the pet by 10 while the energy is greater than 10
     * and decrease the energy level of the pet by 10 after playing.
     */
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

