package deli.models;

public class RegularTopping implements Topping {
    private final String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice(int sizeInInches) {
        return 0.0;
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
