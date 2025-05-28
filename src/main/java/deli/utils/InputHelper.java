package deli.utils;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static boolean getYesNo(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    public static String getDrinkSize(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "s", "small" -> { return "small"; }
                case "m", "medium" -> { return "medium"; }
                case "l", "large" -> { return "large"; }
                default -> System.out.println("Invalid input. Please enter small (s), medium (m), or large (l).");
            }
        }
    }
}