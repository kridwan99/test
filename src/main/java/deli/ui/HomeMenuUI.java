// File: HomeMenuUI.java
package deli.ui;

import deli.services.OrderService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class HomeMenuUI {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderService orderService = new OrderService();

    public void display() {
        boolean running = true;
        while (running) {
            System.out.println("\n====================================");
            System.out.println("     WELCOME TO DELI-cious RESTAURANT! 🥪");
            System.out.println("         Point-of-Sale System");
            System.out.println("====================================");
            System.out.println("1) Start New Order");
            System.out.println("2) View Receipts");
            System.out.println("0) Exit Application");
            System.out.print("\nPlease select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    orderService.startNewOrder();
                    new OrderUI(orderService).display();
                }
                case "2" -> showReceipts();
                case "0" -> {
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    private void showReceipts() {
        File folder = new File("receipts");
        if (!folder.exists() || folder.listFiles() == null || folder.listFiles().length == 0) {
            System.out.println("\nNo receipts found.");
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("\nNo receipt files available.");
            return;
        }

        System.out.println("\nAvailable Receipts:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ") " + files[i].getName());
        }

        System.out.print("\nEnter the number of the receipt to view: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > files.length) {
                System.out.println("Invalid choice.");
                return;
            }
            File selected = files[choice - 1];
            System.out.println("\nViewing receipt: " + selected.getName());
            System.out.println("\n--- Receipt Content ---");
            Files.lines(selected.toPath()).forEach(System.out::println);
            System.out.println("------------------------");
            System.out.print("\nPress Enter to return to menu...");
            scanner.nextLine();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error reading receipt: " + e.getMessage());
        }
    }
}
