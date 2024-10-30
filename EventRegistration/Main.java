package EventRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EventRegistrationSystem {
    private static final int MIN_AGE = 18;
    private static final int CAPACITY_LIMIT = 5;
    private List<String> registeredParticipants = new ArrayList<>();
    private int currentCapacity = 0;

    private String getParticipantKey(String firstName, String lastName, int age) {
        return (firstName + " " + lastName + " age:" + age).toLowerCase();
    }

    public void registerParticipant(String firstName, String lastName, int age) throws AgeRestrictionException, DuplicateRegistrationException, CapacityLimitException {
        String participantKey = getParticipantKey(firstName, lastName, age);

        if (age < MIN_AGE) {
            throw new AgeRestrictionException("Age restriction: Participant must be at least " + MIN_AGE + " years old.");
        }
        

        for (String registered : registeredParticipants) {
            if (registered.equals(participantKey)) {
                throw new DuplicateRegistrationException("Participant with this name and age already exists.");
            }
        }
        
        if (currentCapacity >= CAPACITY_LIMIT) {
            throw new CapacityLimitException("Capacity limit reached: Cannot register more than " + CAPACITY_LIMIT + " participants.");
        }

        registeredParticipants.add(participantKey);
        currentCapacity++;
        System.out.println("Participant " + firstName + " " + lastName + " (age " + age + ") registered successfully!");
    }

    public void showRegisteredParticipants() {
        System.out.println("Registered Participants: " + registeredParticipants);
        System.out.println("Current capacity: " + currentCapacity + "/" + CAPACITY_LIMIT);
    }
}

public class Main {
    public static void main(String[] args) {
        EventRegistrationSystem registrationSystem = new EventRegistrationSystem();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continueRegistration = true;
            while (continueRegistration) {
                System.out.print("Enter participant first name:");
                String firstName = scanner.nextLine();

                System.out.print("Enter participant last name:");
                String lastName = scanner.nextLine();

                System.out.print("Enter participant age:");
                int age = scanner.nextInt();
                scanner.nextLine();

                try {
                    registrationSystem.registerParticipant(firstName, lastName, age);
                } catch (AgeRestrictionException | DuplicateRegistrationException | CapacityLimitException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                System.out.println("Do you want to add another participant? (yes/no)");
                String response = scanner.nextLine().trim().toLowerCase();
                continueRegistration = response.equals("yes");
            }

            registrationSystem.showRegisteredParticipants();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String message) {
        super(message);
    }
}

class DuplicateRegistrationException extends Exception {
    public DuplicateRegistrationException(String message) {
        super(message);
    }
}

class CapacityLimitException extends Exception {
    public CapacityLimitException(String message) {
        super(message);
    }
}
