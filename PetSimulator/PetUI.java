package PetSimulator;

import java.util.Scanner;

public class PetUI {
    private PetG game;
    private Scanner scanner = new Scanner(System.in);

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
                System.out.println("WALA PAKAY PET KULERITA KA!!. PAG BUHAT SA!!.");
                game = new PetG(createNewPet());
            }
        } else {
            System.out.println("Creating new pet");
            game = new PetG(createNewPet());
        }
    }

    private void showMenu() {
        System.out.println("\n1. Feed " + game.getPetName());
        System.out.println("2. Play with " + game.getPetName());
        System.out.println("3. Grow " + game.getPetName());
        System.out.println("4. Sleep");
        System.out.println("5. Make " + game.getPetName() + " make a sound");
        System.out.println("6. Check Status");
        System.out.println("7. Save and Exit");
        System.out.print("Choose an action: ");
    }

    private Pet createNewPet() {
        System.out.print("Enter your pet's name: ");
        String name = scanner.nextLine();

        System.out.print("Choose a pet type (1 for Dog, 2 for Cat, 3 for Snake, 4 for Bird, 5 for Dragon): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return new Dog(name);
            case 2:
                return new Cat(name);
            case 3:
                return new Snake(name);
            case 4:
                return new Bird(name);
            case 5:
                return new Dragon(name);
            default:
                System.out.println("Invalid choice. Exiting.");
                return null;
        }
    }

    private void saveAndExit() {
        System.out.print("Enter the name of the file to save your pet: ");
        String fileName = scanner.nextLine();
        PetG.saveGame(game.getPet(), fileName);
        System.out.println("Thanks for playing Pet Simulator!");
        System.exit(0);
    }
}
