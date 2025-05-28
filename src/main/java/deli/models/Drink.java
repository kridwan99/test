package deli.models;

public class Drink {
    private final DrinkSize size;
    private final String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        return size.getPrice();
    }

    public String getDescription() {
        return size.getDescription() + " " + flavor + " drink";
    }

    public DrinkSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }
}
