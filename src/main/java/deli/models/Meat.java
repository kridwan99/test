package deli.models;

public class Meat implements Topping {
    private final String name;
    private final boolean isExtra;

    public Meat(String name, boolean isExtra) {
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
            case 4 -> base = 1.00;
            case 8 -> base = 2.00;
            case 12 -> base = 3.00;
            default -> base = 0;
        }
        return isExtra ? base / 2 : base;
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}