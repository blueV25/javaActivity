
package Exam2;

import java.util.List;

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
}
