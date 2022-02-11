package com.revature.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Use Main to enter in values into your Solution class */

        Solution sol = new Solution();
        String input;
        boolean result;

        //  Set up a scanner to obtain string input
        System.out.print("PLease enter a word or a short string: ");
        Scanner getInput = new Scanner(System.in);

        // Fetch a string
        input = getInput.next();


        result = sol.recurringSubstring(input);

        if (result) {
            System.out.println(input + " is composed of multiple repeating substrings.");
        }
        else {
            System.out.println(input + " is not composed of repeating substrings");
        }

        getInput.close();
    }
}
