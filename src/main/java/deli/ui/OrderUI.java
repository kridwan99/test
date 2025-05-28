package deli.ui;

import deli.models.*;
import deli.services.OrderService;
import deli.utils.InputHelper;

import java.util.List;
import java.util.Scanner;

public class OrderUI {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderService orderService;

    public enum Sauce {
        MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE;

        public static boolean isValid(String input) {
            for (Sauce s : values()) {
                if (s.name().replace("_", " ").equalsIgnoreCase(input)) return true;
            }
            return false;
        }

        public static String[] getFormattedList() {
            return java.util.Arrays.stream(values())
                    .map(s -> s.name().replace("_", " ").toLowerCase())
                    .toArray(String[]::new);
        }
    }

    public OrderUI(OrderService orderService) {
        this.orderService = orderService;
    }

    public void display() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\n--- Current Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("5) Add Signature Sandwich");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> {
                    System.out.println("\n" + orderService.getCurrentOrder().getReceiptText());
                    System.out.print("Confirm checkout? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        orderService.checkout();
                        ordering = false;
                    }
                }
                case "5" -> addSignatureSandwich();
                case "0" -> {
                    System.out.println("Order cancelled.");
                    orderService.cancelOrder();
                    ordering = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addSandwich() {
        int size = InputHelper.getInt("Enter sandwich size (4, 8, or 12): ");
        String bread = InputHelper.getString("Choose bread (white, wheat, rye, wrap): ");
        boolean toasted = InputHelper.getYesNo("Toasted? (yes/no): ");

        Sandwich sandwich = new Sandwich(bread, size, toasted);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Add topping: (type: meat/cheese/regular, name, extra true/false):");
            String[] parts = scanner.nextLine().split(",");
            if (parts.length >= 2) {
                String type = parts[0].trim().toLowerCase();
                String name = parts[1].trim();
                boolean extra = parts.length > 2 && Boolean.parseBoolean(parts[2].trim());

                Topping topping = switch (type) {
                    case "meat" -> new Meat(name, extra);
                    case "cheese" -> new Cheese(name, extra);
                    case "regular" -> new RegularTopping(name);
                    default -> null;
                };

                if (topping != null) {
                    sandwich.addTopping(topping);
                    System.out.println("Topping added.");
                } else {
                    System.out.println("Invalid topping type.");
                }
            }
            System.out.print("Add another topping? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                addingToppings = false;
            }
        }

        System.out.println("Available sauces:");
        for (String sauce : Sauce.getFormattedList()) {
            System.out.println("- " + sauce);
        }

        boolean addMoreSauce = true;
        while (addMoreSauce) {
            String sauceInput = InputHelper.getString("Add a sauce from the list above (or type 'done'): ").toLowerCase();
            if (sauceInput.equals("done")) {
                addMoreSauce = false;
            } else if (Sauce.isValid(sauceInput)) {
                sandwich.addTopping(new RegularTopping(sauceInput));
                System.out.println(sauceInput + " added.");
            } else {
                System.out.println("Invalid sauce. Try again.");
            }
        }

        orderService.addSandwich(sandwich);
        System.out.println("Sandwich added to order.");
    }

    private void addDrink() {
        String sizeInput = InputHelper.getDrinkSize("Enter drink size (small/medium/large): ");
        DrinkSize size = DrinkSize.fromLabel(sizeInput);
        String flavor = InputHelper.getString("Enter drink flavor (e.g., cola, lemonade): ");
        Drink drink = new Drink(size, flavor);
        orderService.addDrink(drink);
        System.out.println("Drink added to order.");
    }

    private void addChips() {
        String type = InputHelper.getString("Enter chips type (e.g., BBQ, sour cream): ");
        Chips chips = new Chips(type);
        orderService.addChips(chips);
        System.out.println("Chips added to order.");
    }

    private void addSignatureSandwich() {
        System.out.println("Choose a Signature Sandwich:");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");

        String choice = scanner.nextLine();
        Sandwich sandwich = null;

        switch (choice) {
            case "1" -> {
                sandwich = SignatureSandwich.makeBLT();
                System.out.println("BLT added.");
            }
            case "2" -> {
                sandwich = SignatureSandwich.makePhillyCheeseSteak();
                System.out.println("Philly Cheese Steak added.");
            }
            default -> System.out.println("Invalid choice.");
        }

        if (sandwich != null) {
            orderService.addSandwich(sandwich);
        }
    }
}
