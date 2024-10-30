package Exam2;



public class Delivery {
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

