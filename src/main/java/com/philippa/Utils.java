package com.philippa;

import java.util.Scanner;

public class Utils {

    private static final Scanner sc = new Scanner(System.in);

    public static double validateDouble(String input) {
        boolean isDouble = false;
        double validatedDouble = 0.0;

        do {
            try {
                validatedDouble = Double.parseDouble(input);
                isDouble = true;
            } catch(NumberFormatException nfe) {
                System.out.println("Please enter a valid number.");
                input = sc.nextLine();
            }
        } while(!isDouble);

        return validatedDouble;
    }

}
