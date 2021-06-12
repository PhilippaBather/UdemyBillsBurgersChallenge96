package com.philippa;

import domain.*;

import java.util.Scanner;

public class Menu {

    // member fields
    private static boolean exitApp = false;
    private static Scanner sc = new Scanner(System.in);

    private static final int NUMBER_ADDITIONALS_BASIC = 4;
    private static final int NUMBER_ADDITIONALS_HEALTHY = 6;

    // instance fields
    private String userInput;


    /**
     * Method prints menu options to the console
     */
    public void executeMenu() {
        do {
            System.out.println("\n*****\t\t\t\tBill's Burgers\t\t\t\t*****\n");
            System.out.println("1. Basic Hamburger");
            System.out.println("2. Healthy Hamburger");
            System.out.println("3. Deluxe Hamburger");
            System.out.println("x. Exit");
            System.out.println("\nEnter selection: ");
            userInput = sc.nextLine().toLowerCase();    // to accept either upper or lower case x for exit

            switch (userInput) {
                case "1":
                    placeBasicOrder();
                    break;
                case "2":
                    placeHealthyOrder();
                    break;
                case "3":
                    placeDeluxeOrder();
                    break;
                case "x":
                    exitApp = true;
                    break;
                default:
                    System.out.println("Input invalid.");
            }

        } while (!exitApp);
    }

    /**
     * Presents appropriate menus to collect input to create Basic Hamburger instance.
     */
    public void placeBasicOrder() {
        // print roll menu to console and register choice
        Hamburger.rollMenu();
        ROLL_TYPE roll = Hamburger.rollSelection();
        // print meat menu to console and register choice
        Hamburger.meatMenu();
        MEAT_TYPE meat = Hamburger.meatSelection();
        // create instance of basic hamburger
        Hamburger hamburger = new Hamburger(roll, meat);
        // add additionals
        System.out.println("\nYou may add up to 4 additionals at 0.30 cents each.");
        hamburger.printAdditionals();
        hamburger.addAdditional(NUMBER_ADDITIONALS_BASIC);
        // print order summary to console
        hamburger.printOrder();
    }

    /**
     * Presents appropriate menus to collect input to create Healthy Hamburger instance.
     */
    public void placeHealthyOrder() {
        // print meat menu to console and register details
        Hamburger.meatMenu();
        MEAT_TYPE meat = Hamburger.meatSelection();
        // create instance of Healthy hamburger
        Healthy healthy = new Healthy(meat);
        // add additionals
        System.out.println("\nYou may add up to 6 additionals at 0.50 cents each.");
        healthy.printAdditionals();
        healthy.addAdditional(NUMBER_ADDITIONALS_HEALTHY);
        // print order summary to console
        healthy.printOrder();
    }

    public void placeDeluxeOrder() {
        // print roll menu to console and register choice
        Hamburger.rollMenu();
        ROLL_TYPE roll = Hamburger.rollSelection();
        // print meat menu to console and register details
        Hamburger.meatMenu();
        MEAT_TYPE meat = Hamburger.meatSelection();
        Deluxe deluxe = new Deluxe(roll, meat);
        // print order summary to console
        deluxe.printOrder();

    }

}


