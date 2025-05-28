package deli.models;

public enum DrinkSize {
    SMALL("small", 2.00),
    MEDIUM("medium", 2.50),
    LARGE("large", 3.00);

    private final String label;
    private final double price;

    DrinkSize(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getDescription() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    public static boolean isValid(String input) {
        for (DrinkSize size : values()) {
            if (size.label.equalsIgnoreCase(input)) return true;
        }
        return false;
    }

    public static DrinkSize fromLabel(String input) {
        for (DrinkSize size : values()) {
            if (size.label.equalsIgnoreCase(input)) return size;
        }
        throw new IllegalArgumentException("Invalid drink size: " + input);
    }
}
