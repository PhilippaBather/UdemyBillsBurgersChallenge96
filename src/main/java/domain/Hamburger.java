package domain;

import java.util.ArrayList;
import java.util.Scanner;

import static domain.Additional.EXTRA_PRICE;

class Additional {

    static final double EXTRA_PRICE = 0.50;
    
    // instance field
    private EXTRA additional;

    // constructor
    public Additional(EXTRA additional) {
        this.additional = additional;
    }

    // getter

    @Override
    public String toString() {
        if (additional.equals(EXTRA.NONE)) {
            return additional + " : 0";
        } else {
            return additional + " : " + EXTRA_PRICE;
        }
    }
}

public class Hamburger {

    // member fields
    static final Scanner scanner = new Scanner(System.in);

    private final double BASE_PRICE = 4.99;
    private double totalPrice = BASE_PRICE;
    private ROLL_TYPE rollType;
    private MEAT_TYPE meatType;
    ArrayList<Additional> additionals = new ArrayList<>();

    // constructor

    public Hamburger(ROLL_TYPE rollType, MEAT_TYPE meatType) {
        this.rollType = rollType;
        this.meatType = meatType;
    }

    // getter

    public ROLL_TYPE getRollType() {
        return rollType;
    }

    public MEAT_TYPE getMeatType() {
        return meatType;
    }


    public ArrayList<Additional> getAdditionals() {
        return additionals;
    }

    // other methods

    /**
     * Print out roll options to console menu screen.
     */
     public static void rollMenu() {
        System.out.println("\n1: White bap");
        System.out.println("2: Brown bap");
        System.out.println("3: Wholemeal bap");
        System.out.println("4: Baguette");
        System.out.println("\nEnter selection number: ");
    }

    /**
     * Returns roll type selected by user.
     * @return RollType enum selected
     */
    public static ROLL_TYPE rollSelection() {
        boolean rollSelected = false;
        String rollNum;

        do {
            rollNum = scanner.nextLine();
            switch(rollNum) {
                case "1":
                    return ROLL_TYPE.WHITE_BAP;
                case "2":
                    return ROLL_TYPE.BROWN_BAP;
                case "3":
                    return ROLL_TYPE.WHOLEMEAL_BAP;
                case "4":
                    return ROLL_TYPE.BAGUETTE;
                case "5":
                    return ROLL_TYPE.BROWN_RYE;
                default:
                    System.out.println("Invalid input.");
            }
        } while (!rollSelected);

        return null;
    }

    /**
     * Print out meat options to console menu screen.
     */
    public static void meatMenu() {
        System.out.println("\n1: Beef");
        System.out.println("2: Lamb");
        System.out.println("3: Pork");
        System.out.println("4: Chicken");
        System.out.println("5: Falafel");
        System.out.println("\nEnter selection number: ");
    }

    public static MEAT_TYPE meatSelection() {
        boolean meatSelected = false;
        String meatNum;

        do {
            meatNum = scanner.nextLine();
            switch(meatNum) {
                case "1":
                    return MEAT_TYPE.BEEF;
                case "2":
                    return MEAT_TYPE.LAMB;
                case "3":
                    return MEAT_TYPE.PORK;
                case "4":
                    return MEAT_TYPE.CHICKEN;
                case "5":
                    return MEAT_TYPE.FALAFEL;
                default:
                    System.out.println("Invalid input.");
            }
        } while (!meatSelected);

        return null;
    }

    /**
     * Prints additionals menu to console.
     */
    public void printAdditionals() {
        System.out.println("\n***** BASIC ADDITIONALS *****");
        System.out.println("x.  None");
        System.out.println("1.  Drink");
        System.out.println("2.  Chips");
        System.out.println("3.  Lettuce");
        System.out.println("4.  Tomato");
        System.out.println("5.  Cheese");
        System.out.println("6.  Onion");
        System.out.println("7.  Jalapeños");
        System.out.println("8.  Ketchup");
        System.out.println("9.  Mayo");
        System.out.println("10. Mustard");
    }

    /**
     * Add addition (name and price) to order within Additional array and increment base price accordingly.
     */
    public void addAdditional(int NUM_ADDITIONALS) {
        EXTRA extra;

        for (int i = 1; i <= NUM_ADDITIONALS; i++) {
            System.out.println("\nEnter additional #" + i + ": ");
            extra = selectAdditionals();
            additionals.add(new Additional(extra));
        }
    }

    /**
     * Method to enable user to select additions to burger meal deal.
     * @return EXTRA additional requested by user
     */
    public EXTRA selectAdditionals() {
        boolean isValidInput = false;

        do {
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "1":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.DRINK;
                case "2":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.CHIPS;
                case "3":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.LETTUCE;
                case "4":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.TOMATO;
                case "5":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.CHEESE;
                case "6":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.ONION;
                case "7":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.JALEPEÑOS;
                case "8":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.KETCHUP;
                case "9":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.MAYO;
                case "10":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.MUSTARD;
                case "x":
                    return EXTRA.NONE;
                default:
                    System.out.println("Invalid input. Enter valid selection: ");
            }
        } while(!isValidInput);
        return null;
    }

    /**
     * Method prints the base price, additionals (name and price) and the total price
     * to the console.
     */
    public void printOrder() {
        System.out.println("\n*********************************************");
        // print base price
        System.out.println(toString());
        // print additionals and price
        for (Additional additional : additionals) {
            System.out.println(additional.toString());
        }
        // print total price
        System.out.println("*********************************************");
        System.out.printf("TOTAL PRICE: $%.2f", totalPrice);
        System.out.println("\n*********************************************\n");
    }

    @Override
    public String toString() {
        // instance fields
        String NAME = "Basic Burger";
        return "Base price for " + this.getMeatType() + " " + NAME + " on a " + this.getRollType() + " roll : $" + this.BASE_PRICE;
    }
}
