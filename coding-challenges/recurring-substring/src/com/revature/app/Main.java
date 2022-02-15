package com.revature.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Use Main to enter in values into your Solution class */
        String userInput;
        String splitWord;
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        System.out.println("Enter a string: ");
        userInput = sc.nextLine();

        for (int i = 0; i < userInput.length() / 2; i++) {
            splitWord = userInput.substring(0, i+1);

            if (splitWord.length() == userInput.length()/2) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }


    }
}
