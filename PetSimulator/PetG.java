package PetSimulator;

import java.io.*;

/**
The PetG class represents a game that allows users to interact with a pet.
It provides methods to feed, play with, grow, and make the pet sleep.
and manange the pet's status.
 */

public class PetG {
    private Pet pet;

    /** 
     * Constructs a new PetG object with the specified pet.
     * The pet parameter, the pet to be managed by the game
    */

    public PetG(Pet pet) {
        this.pet = pet;
    }

    /** 
     * Feeds the pet by calling the feed() method on the pet object. increasing the pet's happiness  and energy.
    */
    public void feedPet() {
        pet.feed();
    }

    /**
     * Plays with the pet by calling the play() method on the pet object. increasing the pet's happiness while decreasing the pet's energy.
      */
    public void playWithPet() {
        pet.play();
    }

    /**
     * Grows the pet by calling the grow() method on the pet object. increasing the pet's age, weight, and hunger.
     */
    public void growPet() {
        pet.grow();
    }

    /**
     * Makes the pet sleep by calling the sleep() method on the pet object. increasing the pet's energy.
     */
    public void petSleep() {
        pet.sleep();
    }

    /**
     * Makes the pet make a sound by calling the makeSound() method on the pet object.
     * the pet will make a shound based on its type.
     */
    public void makePetSound() {
        pet.makeSound();
    }
    
    /**
     * Gets the name of the pet.
     */
    public String getPetName() {
        return pet.getName();
    }

    /**
     * Gets the pet object manage by the PetG
     */
    public Pet getPet() {
        return pet;
    }
    
// Display the current status of the pet , including happiness, energy, age, weight, and hunger.
    public void displayStatus() {
        System.out.println("\n" + pet.getName() + "'s status:");
        System.out.println("Happiness: " + pet.getHappiness());
        System.out.println("Energy: " + pet.getEnergy());
        System.out.println("Age: " + pet.getAge());
        System.out.println("Weight: " + pet.getWeight() + " kg");
        System.out.println("Hunger: " + pet.getHunger());
    }

    /**
     * Saves the current game state to a specified file.
     * the parameter fileName is the name of the file to save the game state to.
     * and the pet object is the pet object to be saved.
     */
    public static void saveGame(Pet pet, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(pet);
            System.out.println("Game saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving game.");
        }
    }


    /**
     * Loads a saved game state from a specified file.
     * the parameter fileName is the name of the file to load the game state from.
     */
    public static Pet loadPet(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Pet) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved game found in " + fileName);
            return null;
        }
    }
}
