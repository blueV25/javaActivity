package Exam;

public class DeliveryGrouper  {
    public List<DeliveryGroup> groupDeliveries(List<Delivery> deliveries) {
        Map<String, List<Delivery>> groupedDeliveries = new HashMap<>();

        for (Delivery delivery : deliveries) {
            groupedDeliveries

                .computeIfAbsent(delivery.getLocation(), k -> new ArrayList<>())                                                         //e group ang deliveries by their locations sa map
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
                long timeThreshold = groupStartTimestamp + 300000; // 5 minutes ni ayaw pa ilad milliseconds
            
                if (deliveryTime <= timeThreshold) {
                    currentGroup.add(delivery); 
                }
            }

            if (!currentGroup.isEmpty()) {
                deliveryGroups.add(new DeliveryGroup(location, currentGroup));
            }
        }

        return deliveryGroups;
    }

public static void main(String[] args) {
        List<Delivery> deliveries = Arrays.asList(
            new Delivery(1, "Compostela", 1600000L),
            new Delivery(2, "Compostela", 1660000L),
            new Delivery(3, "Compostela", 1720000L),
            new Delivery(4, "Nabunturan", 2500000L),
            new Delivery(5, "New Bataan", 1600000L),
            new Delivery(6, "New Bataan", 1660000L),
            new Delivery(7, "Tagum", 2300000L),
            new Delivery(8,"Tagum",2304000L),
            new Delivery(9,"Tagum",2300500L),
            new Delivery(10,"Mawab",3000000L),
            new Delivery(11,"Mawab",3060000L),
            new Delivery(12,"Mawab",3120000L),
            new Delivery(13,"Mawab",3180000L)
        );

        DeliveryGrouper deliveryGrouper = new DeliveryGrouper();
        List<DeliveryGroup> groupedDeliveries = deliveryGrouper.groupDeliveries(deliveries);

        for (DeliveryGroup group : groupedDeliveries) {
            System.out.println("Location: " + group.getLocation() + ", Deliveries: " + group.getDeliveries().size());
        }
    }
}
