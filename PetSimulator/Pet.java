package PetSimulator;

import java.io.Serializable;

/**
 * The abstract Pet class represents a pet in the game.
 * it provide common attributes and behaviors that all pet types will share.
 */

public abstract class Pet implements Serializable{
    protected String name;      // The name of the pet
    protected int happiness;    // The happiness level of the pet
    protected int energy;       // The energy level of the pet
    protected int age;          // The age of the pet
    protected int weight;       // The weight of the pet
    protected PetType type;     // The type of the pet
    protected int hunger;       // The hunger level of the pet


    /**
     * Constructs a Pet with the specified name and type
     * and initializes happiness, energy, age, weight, and hunger to default values.
     * 
     * the parameter name is the name of the pet and the parameter type is the type of the pet.
     */
    public Pet(String name , PetType type) {
        this.name = name;
        this.type = type;
        this.happiness = 50;
        this.energy = 100;
        this.age = 1;
        this.weight = 2;
        this.hunger = 50;
    }

/**
 *make the pet to make a sound.
 * it will be implemented by the subclasses of the Pet class.
 */
    public abstract void makeSound();


    /**
     * feeds the pet increasing its hunger and energy levels.
     * if the pet is too full it will not eat.
     */
    public void feed() {
        if (hunger >= 100) {
            System.out.println(name + " is too full to eat. Energy: " + energy + ", Hunger: " + hunger);
            return;
        }

        hunger += 25;
        if (hunger > 100) hunger = 100;
    
        energy += 25;
        if (energy > 100) energy = 100;
    
        System.out.println(name + " has been fed. Energy: " + energy + ", Hunger: " + hunger);
    }
    

    /**
     * Allows the pet to play, increasing its happiness while decreasing energy levels.
     * if the pet is too old or too tired it will not play.
     */
    public void play() {
        if (age >= 20) {
            happiness -= 10;
            if (happiness < 0) happiness = 0;
            System.out.println(name + " is too old to play. Happiness decreased by 10.");
            System.out.println("Happiness: " + happiness);
            return;
        }

        if (energy < 20) {
            System.out.println(name + " is too tired to play.");
            System.out.println("Energy: " + energy);
            return;
        }
        energy -= 20;
        if (energy < 0) energy = 0; 
        
        happiness += 15;
        if (happiness > 100) happiness = 100;

        hunger -= 10;
        if (hunger < 0) hunger = 0;

        System.out.println(name + " played. Happiness: " + happiness + ", Energy: " + energy + ", Hunger: " + hunger);
    }

    /**
     * puts the pet to sleep, increasing its energy level and happiness level.
     * if the pets energy level is already 100 it will not sleep.
     */
    public void sleep() {
        if (energy >= 100) {
            System.out.println(name + " is naka tulog na ganiha and doesn't need more sleep.");
            return;
        }
        energy += 50;
        happiness += 5;
        weight += 2;
        if (energy > 100) energy = 100;
        if (happiness > 100) happiness = 100;
    
        System.out.println(name + " slept. Energy: " + energy + ", Happiness: " + happiness + ", Weight: " + weight + " kg");
    }
    
    /**
     * Increases the pets age and weight.
     * if the pets weight is already 70 it will not grow.
     */
    public void grow() {
        age++;
        if (weight < 70) {
            weight += 5;
            System.out.println(name + " grew. Age: " + age + ", Weight: " + weight + " kg");
        } else {
            System.out.println(name + " has reached maximum weight and cannot grow further.");
            System.out.println("Current Weight: " + weight + " kg, Age: " + age);
        }
    }
    

// returns the pets name
    public String getName() {
        return name;
    }
//returns the pets happiness level
    public int getHappiness() {
        return happiness;
    }
//returns the pets energy level
    public int getEnergy() {
        return energy;
    }
//returns the pets age    
    public int getAge() {
        return age;
    }
//returns the pets weight
    public int getWeight() {
        return weight;
    }
//returns the pets hunger level
    public int getHunger() {
        return hunger;
    }
// returns the pets type 
    public PetType getType() {
        return type;
    }
}



