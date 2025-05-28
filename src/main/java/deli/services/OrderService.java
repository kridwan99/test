package deli.services;

import deli.models.*;

public class OrderService {
    private Order currentOrder;

    public void startNewOrder() {
        currentOrder = new Order();
    }

    public void cancelOrder() {
        currentOrder = null;
    }

    public boolean hasActiveOrder() {
        return currentOrder != null;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void addSandwich(Sandwich sandwich) {
        if (currentOrder != null) {
            currentOrder.addSandwich(sandwich);
        }
    }

    public void addDrink(Drink drink) {
        if (currentOrder != null) {
            currentOrder.addDrink(drink);
        }
    }

    public void addChips(Chips chips) {
        if (currentOrder != null) {
            currentOrder.addChips(chips);
        }
    }

    public void checkout() {
        if (currentOrder != null) {
            ReceiptService.saveReceipt(currentOrder);
            currentOrder = null;
        }
    }
}
