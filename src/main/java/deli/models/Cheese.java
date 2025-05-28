package deli.models;

public class Cheese implements Topping {
    private final String name;
    private final boolean isExtra;

    public Cheese(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    @Override
    public String getName() {
        return name + (isExtra ? " (Extra)" : "");
    }

    @Override
    public double getPrice(int sizeInInches) {
        double base;
        switch (sizeInInches) {
            case 4 -> base = 0.75;
            case 8 -> base = 1.50;
            case 12 -> base = 2.25;
            default -> base = 0;
        }
        return isExtra ? base / 2 : base;
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
