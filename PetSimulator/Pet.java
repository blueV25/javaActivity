package PetSimulator;

import java.io.Serializable;

public abstract class Pet implements Serializable{
    protected String name;
    protected int happiness;
    protected int energy;
    protected int age;
    protected int weight;
    protected PetType type;

    public Pet(String name , PetType type) {
        this.name = name;
        this.type = type;
        this.happiness = 50;
        this.energy = 100;
        this.age = 1;
        this.weight = 2;
    }


    public abstract void makeSound();

    public void feed() {
        energy += 25;
        if (energy > 100) energy = 100;
        System.out.println(name + " has been fed. Energy: " + energy);
    }

    public void play() {
        if (energy >= 20) {
            happiness += 15;
            energy -= 20;
            if (happiness > 100) happiness = 100;
            System.out.println(name + " played. Happiness: " + happiness + ", Energy: " + energy);
        } else {
            System.out.println(name + " is too tired to play.");
        }
    }
    public void sleep() {
        energy += 50;
        happiness += 5;
        weight += 2;
        if (energy > 100) energy = 100;
        System.out.println(name + " slept. Energy: " + energy + ", Happiness: " + happiness + ", Weight: " + weight);
    }
    public void grow() {
        age++;
        weight += 5;
        System.out.println(name + " grew. Age: " + age + ", Weight: " + weight);
    }


    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }
    public int getAge() {
        return age;
    }
    public int getWeight() {
        return weight;
    }
    public PetType getType() {
        return type;
    }
}



