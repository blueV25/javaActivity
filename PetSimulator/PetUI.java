package PetSimulator;

import java.util.Scanner;

/**
 * The PetUI class represents the user interface for the Pet Simulator game.
 * it allow user to interact with the game and manage their pet like feeding, playing, growing, and making their pet sleep.
 */
public class PetUI {
    private PetG game;
    private Scanner scanner = new Scanner(System.in);

/**
 * start the game , welcoming the user and setting up the pet.
 * It will display a menu of options for the user to choose from, and perform the corresponding action based on the user's input.
 */

    public void start() {
        System.out.println("Welcome to Pet Simulator!");
        petSetup();

        while (true) {
            showMenu();
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    game.feedPet();
                    break;
                case 2:
                    game.playWithPet();
                    break;
                case 3:
                    game.growPet();
                    break;
                case 4:
                    game.petSleep();
                    break;
                case 5:
                    game.makePetSound();
                    break;
                case 6:
                    game.displayStatus();
                    break;
                case 7:
                    saveAndExit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

/**
 * Sets up the pet by asking the user whether to load a saved game or create a new one.
 */
    private void petSetup() {
        System.out.print("Would you like to load a saved game? (y/n): ");
        String loadChoice = scanner.nextLine().trim().toLowerCase();

        if (loadChoice.equals("y") || loadChoice.equals("yes")) {
            System.out.print("Enter the name of the file you want to load: ");
            String loadFileName = scanner.nextLine();
            Pet pet = PetG.loadPet(loadFileName);

            if (pet != null) {
                System.out.println("Welcome back, " + pet.getName() + "!");
                game = new PetG(pet);
            } else {
                System.out.println("No saved pet found. Let's create a new one.");
                game = new PetG(createNewPet());
            }
        } else {
            System.out.println("Creating new pet");
            game = new PetG(createNewPet());
        }
    }

    /**
     * Displays the menu for pet interaction and allowing user to choose an action.
     */
    private void showMenu() {
        System.out.println("\n1. Feed " + game.getPetName());
        System.out.println("2. Play with " + game.getPetName());
        System.out.println("3. Grow " + game.getPetName() );
        System.out.println("4. Sleep");
        System.out.println("5. Make " + game.getPetName() + " make a sound");
        System.out.println("6. Check Status");
        System.out.println("7. Save and Exit");
        System.out.print("Choose an action: ");
    }

/**
 * Creating new pet by asking the user to enter the name of the pet and the type of the pet.
 * and return the newly created pet object.
 */
    private Pet createNewPet() {
        System.out.print("Enter your pet's name: ");
        String name = scanner.nextLine();

        PetType type = null;
        while (type == null) {
            System.out.print("Choose a pet type (DOG, CAT, SNAKE, BIRD, DRAGON): ");
            String typeInput = scanner.nextLine().trim().toUpperCase();
            try {
                type = PetType.valueOf(typeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid pet type. Please try again.");
            }
        }

// Return the specific pet type based on PetType.
        switch (type) {
            case DOG:
                return new Dog(name);
            case CAT:
                return new Cat(name);
            case SNAKE:
                return new Snake(name);
            case BIRD:
                return new Bird(name);
            case DRAGON:
                return new Dragon(name);
            default:
                throw new IllegalStateException("Unexpected pet type: " + type);
        }
    }
// Saves the current game state to a file and exits the game.
    private void saveAndExit() {
        System.out.print("Enter the name of the file to save your pet: ");
        String fileName = scanner.nextLine();
        PetG.saveGame(game.getPet(), fileName);
        System.out.println("Thanks for playing Pet Simulator!");
        System.exit(0);
    }
}
