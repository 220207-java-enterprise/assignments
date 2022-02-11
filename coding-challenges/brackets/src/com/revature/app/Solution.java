package com.revature.app;

import java.util.*;

public class Solution {
    public String brackets() {
        System.out.println("Enter a string with as many periods as you'd like: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();


        userInput = userInput.replaceAll("\\.", "[.]");
        return userInput;
    }
}