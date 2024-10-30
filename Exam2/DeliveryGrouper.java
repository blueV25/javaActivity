package Exam2;

import java.util.*;

public class DeliveryGrouper {
    public List<DeliveryGroup> groupDeliveries(List<Delivery> deliveries) {
        Map<String, List<Delivery>> groupedDeliveries = new HashMap<>();


        for (Delivery delivery : deliveries) {
            groupedDeliveries
                .computeIfAbsent(delivery.getLocation(), k -> new ArrayList<>())
                .add(delivery);
        }

        List<DeliveryGroup> deliveryGroups = new ArrayList<>();

    
        for (Map.Entry<String, List<Delivery>> entry : groupedDeliveries.entrySet()) {
            String location = entry.getKey();
            List<Delivery> locationDeliveries = entry.getValue();

    
            locationDeliveries.sort(Comparator.comparingLong(Delivery::getTimestamp));

            List<Delivery> currentGroup = new ArrayList<>();
            long groupStartTimestamp = locationDeliveries.get(0).getTimestamp();

            for (Delivery delivery : locationDeliveries) {
                long deliveryTime = delivery.getTimestamp();
                long timeGap = deliveryTime - groupStartTimestamp;

                if (timeGap <= 300000) {
                    currentGroup.add(delivery);
                } else {
    
                    deliveryGroups.add(new DeliveryGroup(location, currentGroup));
                    currentGroup = new ArrayList<>();
                    currentGroup.add(delivery);
                    groupStartTimestamp = deliveryTime; 
                }
            }


            if (!currentGroup.isEmpty()) {
                deliveryGroups.add(new DeliveryGroup(location, currentGroup));
            }
        }

        return deliveryGroups;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Delivery> deliveries = new ArrayList<>();
        boolean addMore = true;

        while (addMore) {
            System.out.println("Enter delivery details:");

            System.out.print("Enter delivery ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter delivery location: ");
            String location = sc.nextLine();

            System.out.print("Enter delivery time in minutes (e.g., 5 for 5 minutes): ");
            int minutes = sc.nextInt();
            sc.nextLine();

    
            long timestampInMillis = minutes * 60 * 1000L;

    
            deliveries.add(new Delivery(id, location, timestampInMillis));

            System.out.println("Do you want to add another delivery? (yes/no)");
            String choice = sc.nextLine().trim().toLowerCase();

    
            if (!choice.equals("yes")) {
                addMore = false;
            }
        }

    
        DeliveryGrouper deliveryGrouper = new DeliveryGrouper();
        List<DeliveryGroup> groupedDeliveries = deliveryGrouper.groupDeliveries(deliveries);

    
        for (DeliveryGroup group : groupedDeliveries) {
            System.out.println("Location: " + group.getLocation() + ", Deliveries: " + group.getDeliveries().size());
            for (Delivery d : group.getDeliveries()) {
                System.out.println("    Delivery ID: " + d.getId() + ", Timestamp: " + d.getTimestamp());
            }
        }
    }
}
