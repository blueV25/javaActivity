package PetSimulator;


/**
 * The Cat class represents a cat pet in the game.
 * The Cat has unique behaviors, including making a specific sound and making  a scratch.
 */
public class Cat extends Pet {
    
    /**
     * make a cat pet with the specified name.
     * the name parameter is for the name of the cat pet.
     */
    public Cat(String name) {
        super(name, PetType.CAT);
    }

    /**
     * Makes a sound specific to a cat pet and overide the makeSound method in the Pet class.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow meow!");
    }

    /**
     * Allows the cat to scratch and increase the happiness level of the pet by 5 while the happiness level is less than 100.
     */
    public void scratch() {
        happiness += 5;
        if (happiness > 100) happiness = 100;
        System.out.println(name + " scratched. Happiness: " + happiness);
    }
}