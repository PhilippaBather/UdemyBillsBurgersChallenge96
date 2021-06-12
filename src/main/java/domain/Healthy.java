package domain;

import java.util.ArrayList;

import static domain.Additional.EXTRA_PRICE;

public class Healthy extends Hamburger {

    // member fields
    //private static final Scanner sc = new Scanner(System.in);

    // instance fields
    private final String NAME;
    private final double BASE_PRICE;
    private double totalPrice;
    private ArrayList<Additional> additionals;

    // constructor

    public Healthy(MEAT_TYPE meatType) {
        super(ROLL_TYPE.BROWN_RYE, meatType);
        this.NAME = "Healthy Burger";
        this.BASE_PRICE = 5.99;
        this.totalPrice = BASE_PRICE;
    }

    // other methods


    @Override
    public void printAdditionals() {
        super.printAdditionals();
        System.out.println("***** HEALTHY ADDITIONALS *****");
        System.out.println("11. Salad");
        System.out.println("12. Hummus");
        System.out.println("13. Roasted Vegetables");
    }

    @Override
    public EXTRA selectAdditionals() {
        boolean isValidInput = false;

        do {
            String userInput = scanner.nextLine().toLowerCase();

            switch(userInput) {
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
                case "11":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.SALAD;
                case "12":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.HUMMUS;
                case "13":
                    totalPrice += EXTRA_PRICE;
                    return EXTRA.ROASTED_VEGETABLES;
                case "x":
                    return EXTRA.NONE;
                default:
                    System.out.println("Invalid input. Enter valid selection: ");
            }
        } while (!isValidInput);
        return null;
    }

    @Override
    public void printOrder() {
        System.out.println("\n*********************************************");
        // print base price
        System.out.println(toString());
        // print additionals and price
        for (Additional additional : getAdditionals()) {
            System.out.println(additional.toString());
        }
        // print total price
        System.out.println("*********************************************");
        System.out.printf("TOTAL PRICE: %.2f", totalPrice);
        System.out.println("\n*********************************************\n");
    }

    @Override
    public String toString() {
        return "Base price for " + this.getMeatType() + " " + this.NAME + " on a " + this.getRollType() + " roll : $" + this.BASE_PRICE;
    }
}
