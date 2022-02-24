package com.revature.foundations;

import com.revature.foundations.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FoundationsDriver {

    public static int loopCounter = 0;

    public static void main(String[] args) {

        if (loopCounter == 3) {
            throw new RuntimeException("Looped three times:");
        }

        String welcomeMenu = "Welcome to the Reimbursement Portal!\n" +
                "Please make a selection from the options below: \n" +
                "1) Login\n" +
                "2) Register\n" +
                "3) Exit\n" +
                " > ";

        System.out.print(welcomeMenu);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userSelection = consoleReader.readLine();
            System.out.println(userSelection);

            switch (userSelection) {
                case "1":
                    System.out.println("You selected: Login");
                    break;
                case "2":
                    System.out.println("You selected: Register");
                    System.out.println("Please provide some basic information to register an account: ");

                    System.out.println("First name: ");
                    String firstName = consoleReader.readLine();

                    System.out.println("Last name: ");
                    String lastName = consoleReader.readLine();

                    System.out.println("Email: ");
                    String email = consoleReader.readLine();

                    System.out.println("Username: ");
                    String username = consoleReader.readLine();

                    System.out.println("Password: ");
                    String password = consoleReader.readLine();

                    User newUser = new newUser(firstName, lastName, email, username, password);
                    System.out.println("Registration info provided: %s %s %s %s %s, newUser);

                    break;
                case "3":
                    System.out.println("You selected: Exit");
                    break;
                default:
                    System.out.println("You have made an incorrect selection!");
                    break;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        loopCounter++;
        main(args);
    }
}
