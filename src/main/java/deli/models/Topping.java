package deli.models;

public interface Topping {
    String getName();
    double getPrice(int sizeInInches);
    boolean isPremium();
}
