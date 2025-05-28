package deli.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Chips> chipsList = new ArrayList<>();

    // Adds a sandwich to the order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // Adds a drink to the order
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // Adds chips to the order
    public void addChips(Chips chips) {
        chipsList.add(chips);
    }

    // Calculates the total price of the order
    public double calculateTotal() {
        double total = 0.0;
        for (Sandwich s : sandwiches) {
            total += s.calculatePrice();
        }
        for (Drink d : drinks) {
            total += d.getPrice();
        }
        for (Chips c : chipsList) {
            total += c.getPrice();
        }
        return total;
    }

    // Builds a receipt text summary of the order
    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");

        for (int i = 0; i < sandwiches.size(); i++) {
            sb.append("\nSandwich #").append(i + 1).append(":\n");
            sb.append(sandwiches.get(i).getDescription()).append("\n");
        }

        for (Drink d : drinks) {
            sb.append("\nDrink: ").append(d.getDescription()).append("\n");
        }

        for (Chips c : chipsList) {
            sb.append("\nChips: ").append(c.getDescription()).append("\n");
        }

        sb.append("\nTOTAL: $").append(String.format("%.2f", calculateTotal()));
        return sb.toString();
    }
}
