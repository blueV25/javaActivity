package PetSimulator;

/**
 * The Snake class represents a snake pet in the game.
 * It extends the Pet class and provides specific behavior for snake pets.
 */
public class Snake extends Pet {

    // make a snake pet with the specified name.
    // the name parameter is for the name of the snake pet.
    public Snake(String name) {
        super(name, PetType.SNAKE);
    }
    /**
     * Makes a sound specific to a snake example pst.. HI POGI AHAHHAHAHAHA and overide the makeSound method in the Pet class.
    */
    @Override
    public void makeSound() {
        System.out.println(name + " says:PPSSSSSSTT HI , POGI ");
    }

    /**
     * make the snake slither and increase the happiness level of the pet by 10 
     * and decrease the energy level of the pet by 10 after slithering.
     */
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
