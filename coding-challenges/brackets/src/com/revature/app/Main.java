package com.revature.app;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        userInput = userInput.replaceAll("\\.", "");
        System.out.println(userInput);
    }
}
