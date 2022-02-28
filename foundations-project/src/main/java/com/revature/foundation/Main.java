package com.revature.foundation;


import com.revature.foundation.daos.CrudDAO;
import com.revature.foundation.daos.UserDAO;
import com.revature.foundation.models.Users;
import com.revature.foundation.util.connectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        connectionFactory cconnectionFactory = connectionFactory.getInstance();

        Connection conn = null;

        try {
            conn = cconnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn == null) {
            System.out.println("Error!");
        } else {
            System.out.println("Success!");
        }
        String WelcomeMenu = "Hey, what would you like to log in as?\n" +
                "1. Admin\n" + "2. Finance Manager\n" + "3. Employee";
        System.out.println(WelcomeMenu);
        System.out.print("Select Role: ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));


//        String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=foundations";
//        String username = "postgres";
//        String password = "rock2fakie";
//
//        try {
//            Connection connection = DriverManager.getConnection(URL, username, password);
//
//            System.out.println("Connection successful");
//
//        } catch (SQLException e) {
//            System.out.println("Error in connecting to PostgreSQL");
//            e.printStackTrace();
//        }


        try {
            String userSelection = consoleReader.readLine();

            System.out.println(userSelection);
            switch (userSelection) {
                case "1": {
                    String WelcomeAdmin = "Welcome Admin,\n" + "Please enter your log in credentials. \n" + "UserName: ";
                    System.out.print(WelcomeAdmin);
                    String adminSelection = consoleReader.readLine();
                    System.out.println("Hello, " + adminSelection + "\nPassword: ");
                    String adminPassword = consoleReader.readLine();
                    String role = "Admin";
                    String sql = "insert into employees " + " (adminSelection, role";
                    break;
                }
                case "2": {
                    String WelcomeFinanceManager = "Welcome Finance Manager,\n" + "Please enter your log in credentials: ";
                    System.out.print(WelcomeFinanceManager);
                    String FASelection = consoleReader.readLine();
                    System.out.println(FASelection);
                    break;
                }
                case "3": {
                    String WelcomeEmployee = "Welcome Employee,\n" + "Please enter your log in credentials: ";
                    System.out.print(WelcomeEmployee);
                    String EmployeeSelection = consoleReader.readLine();
                    System.out.println(EmployeeSelection);
                    break;
                }
                case "4": {
                    CrudDAO crud = new UserDAO(conn);

                    Users user = (Users) crud.getById("1");

                    System.out.println(user);

                    break;
                }
                case "5": {
                    CrudDAO<Users> crud = new UserDAO(conn);

                    Object[] user = crud.getAll();


                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}