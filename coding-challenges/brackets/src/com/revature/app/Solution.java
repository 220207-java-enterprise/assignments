package com.revature.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = s;

//        try {
//            System.out.println("Enter a string with a period somewhere.");
//            userInput = consoleReader.readLine();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(userInput);

        int periodIndex = userInput.indexOf(".");

        String stringStart = userInput.substring(0, periodIndex) + "[";
        String stringEnd = "]" + userInput.substring(periodIndex +1, userInput.length());

        return stringStart + "." + stringEnd;
    }
}
