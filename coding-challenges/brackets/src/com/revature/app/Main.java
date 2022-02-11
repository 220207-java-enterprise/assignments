package com.revature.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Use this to enter in values for your Solution class */
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your string \n" +
                         "> ");

        String userInput = scan.nextLine();

        System.out.println(
            "Your new string is " + new Solution().brackets(userInput)
        );
    }
}
