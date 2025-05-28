package deli.models;

public enum Bread {
    WHITE, WHEAT, RYE, WRAP;

    public static boolean isValid(String input) {
        for (Bread b : values()) {
            if (b.name().equalsIgnoreCase(input)) return true;
        }
        return false;
    }

    public static String[] getFormattedList() {
        return java.util.Arrays.stream(values())
                .map(b -> b.name().toLowerCase())
                .toArray(String[]::new);
    }
}
