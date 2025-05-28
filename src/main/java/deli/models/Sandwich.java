package deli.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private final int sizeInInches;
    private boolean toasted;
    private final List<Topping> toppings = new ArrayList<>();

    public Sandwich(String bread, int sizeInInches, boolean toasted) {
        this.bread = bread;
        this.sizeInInches = sizeInInches;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        double basePrice;
        switch (sizeInInches) {
            case 4 -> basePrice = 5.50;
            case 8 -> basePrice = 7.00;
            case 12 -> basePrice = 8.50;
            default -> basePrice = 0;
        }

        double toppingCost = toppings.stream()
                .mapToDouble(t -> t.getPrice(sizeInInches))
                .sum();

        return basePrice + toppingCost;
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(sizeInInches).append("\" ").append(bread).append(toasted ? " (Toasted)" : "");
        for (Topping topping : toppings) {
            sb.append("\n  - ").append(topping.getName());
        }
        return sb.toString();
    }

    public int getSizeInInches() {
        return sizeInInches;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getBread() {
        return bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}
