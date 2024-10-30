package Exam;


public class DeliveryGroup {
     private String location;
     private List<Delivery> deliveries;

    public DeliveryGroup(String location, List<Delivery> deliveries) {
        this.location = location;
        this.deliveries = deliveries;
    }

    public String getLocation() {
        return location;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }


class Delivery {
    private int id;
    private String location;
    private long timestamp;

    public Delivery(int id, String location, long timestamp) {
        this.id = id;
        this.location = location;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

}