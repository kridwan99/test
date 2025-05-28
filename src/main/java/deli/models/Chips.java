package deli.models;

public class Chips {
    private final String type;

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    public String getDescription() {
        return type + " chips";
    }
}
