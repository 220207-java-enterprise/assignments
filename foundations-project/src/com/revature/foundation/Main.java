package com.revature.foundation;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String WelcomeMenu = "Hey, what would you like to log in as?\n" +
                            "1. Admin\n" + "2. Finance Manager\n" + "3. Employee";
        System.out.println(WelcomeMenu);
        System.out.print("Select Role: ");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userSelection = consoleReader.readLine();

            System.out.println(userSelection);
            switch (userSelection) {
                case "1":
                    String WelcomeAdmin = "Welcome Admin,\n" + "Please enter your log in credentials. \n" + "UserName: ";
                    System.out.print(WelcomeAdmin);
                    String adminSelection = consoleReader.readLine();
                    System.out.println(adminSelection);

                    break;
                case "2":
                    String WelcomeFinanceManager = "Welcome Finance Manager,\n" + "Please enter your log in credentials: ";
                    System.out.print(WelcomeFinanceManager);
                    String FASelection = consoleReader.readLine();
                    System.out.println(FASelection);
                    break;
                case "3":
                    String WelcomeEmployee = "Welcome Employee,\n" + "Please enter your log in credentials: ";
                    System.out.print(WelcomeEmployee);
                    String EmployeeSelection = consoleReader.readLine();
                    System.out.println(EmployeeSelection);
                    break;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}