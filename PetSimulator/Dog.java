package PetSimulator;

/**
 * The Dog class represents a dog pet in the game.
 * The Dog has unique behaviors, including making a specific sound and playing fetch.
 */
public class Dog extends Pet {
    
    /**
     * make a dog pet with the specified name.
     * the name parameter is for the name of the dog pet.
     */
    public Dog(String name) {
        super(name, PetType.DOG);
    }

    /**
     * Makes a sound specific to a dog pet and overide the makeSound method in the Pet class.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof woof!");
    }

    /**
     * Allows the dog to play fetch and increase the happiness level of the pet by 10
     * and decrease the energy level of the pet by 10.
     */
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