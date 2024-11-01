package PetSimulator;

/**
 * The Dragon class represents a dragon pet in the game.
 * It extends the Pet class and provides specific behavior for dragon pets.
 */
public class Dragon extends Pet {

    // make a dragon pet with the specified name.
    // the name parameter is for the name of the dragon pet.
    public Dragon(String name) {
        super(name, PetType.DRAGON); 
    }

    /**
     * Makes a sound specific to a dragon pet and overide the makeSound method in the Pet class.
    */
    @Override
    public void makeSound() {
        System.out.println(name + " says: WHAAAAAAAAAAAA!");
    }

    /**
     * make the dragon fly and increase the happiness level of the pet by 5.
     */
    public void fly() {
        happiness += 5;
        if (happiness > 100) happiness = 100;
        System.out.println(name + " flew. Happiness: " + happiness);
    }
}
