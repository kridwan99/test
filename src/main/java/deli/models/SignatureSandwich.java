package deli.models;

public class SignatureSandwich {

    public static Sandwich makeBLT() {
        Sandwich blt = new Sandwich("white", 8, true);
        blt.addTopping(new Meat("bacon", false));
        blt.addTopping(new Cheese("cheddar", false));
        blt.addTopping(new RegularTopping("lettuce"));
        blt.addTopping(new RegularTopping("tomato"));
        blt.addTopping(new RegularTopping("ranch"));
        return blt;
    }

    public static Sandwich makePhillyCheeseSteak() {
        Sandwich philly = new Sandwich("white", 8, true);
        philly.addTopping(new Meat("steak", false));
        philly.addTopping(new Cheese("american", false));
        philly.addTopping(new RegularTopping("peppers"));
        philly.addTopping(new RegularTopping("mayo"));
        return philly;
    }
}
