package domain;

import java.util.ArrayList;

public class Deluxe extends Hamburger {

    // instance fields
    private String name;
    private final double PRICE;
    private Additional add1;
    private Additional add2;

    // constructor

    public Deluxe(ROLL_TYPE rollType, MEAT_TYPE meatType) {
        super(rollType, meatType);
        this.name = "Deluxe Burger";
        this.PRICE = 5.00;
        this.add1 = new Additional(EXTRA.DRINK);
        this.add2 = new Additional(EXTRA.CHIPS);
        ArrayList<Additional> additionals = new ArrayList<>();
        additionals.add(add1);
        additionals.add(add2);
    }

    @Override
    public void printOrder() {
        System.out.println("\n*********************************************");
        // print base price
        System.out.println("Order for " + this.toString());
        // print additionals and price
        System.out.println("Additionals: chips and drink included");
        // print total price
        System.out.println("*********************************************");
        System.out.printf("TOTAL PRICE: %.2f", PRICE);
        System.out.println("\n*********************************************\n");
    }

    @Override
    public String toString() {
        return this.name + " on a " + this.getRollType() + " roll";
    }
}
