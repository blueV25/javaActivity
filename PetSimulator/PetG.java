package PetSimulator;

import java.io.*;

public class PetG {
    private Pet pet;

    public PetG(Pet pet) {
        this.pet = pet;
    }

    public void feedPet() {
        pet.feed();
    }

    public void playWithPet() {
        pet.play();
    }

    public void growPet() {
        pet.grow();
    }

    public void petSleep() {
        pet.sleep();
    }

    public void makePetSound() {
        pet.makeSound();
    }
    
    public String getPetName() {
        return pet.getName();
    }
    
    public Pet getPet() {
        return pet;
    }
    

    public void displayStatus() {
        System.out.println("\n" + pet.getName() + "'s status:");
        System.out.println("Happiness: " + pet.getHappiness());
        System.out.println("Energy: " + pet.getEnergy());
        System.out.println("Age: " + pet.getAge());
        System.out.println("Weight: " + pet.getWeight());
    }

    public static void saveGame(Pet pet, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(pet);
            System.out.println("Game saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving game.");
        }
    }

    public static Pet loadPet(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Pet) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved game found in " + fileName);
            return null;
        }
    }
}
