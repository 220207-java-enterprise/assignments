package com.revature.Scratch;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.security.Provider;
import java.security.Security;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Foundations {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory cf = new ConnectionFactory();
        // Connect to the database
        Connection conn = cf.connect();
        Scanner getInput = new Scanner(System.in);
        String result = "", authorizationLevel;
        String userName, password;
        String userID, reimbID;
        boolean allDone = false, outcome;
        int whatHappened = 0;

        if (conn == null) {
            System.out.println("Error -- connection not established.");
            return;
        } else
            System.out.println("Connected to database " + cf.getdbUrl());

       // System.out.println("Current Schema is: " + conn.getSchema());
        conn.setSchema("Foundations");
        System.out.println("Current Schema is now " + conn.getSchema());

      // log in as ardavidson, admin
        Gears cog = new Gears();
        System.out.print("User name: ");
        userName = getInput.nextLine();
        System.out.print("Password:  ");
        password = getInput.nextLine();
        if (!cog.login(conn, userName, password)) {
            System.out.println("You are not an authorized user of the ERS System.");
            return;
        }

        // User is successfully logged in at this point
        authorizationLevel = cog.getPermissions(conn, userName);
        System.out.println("Your user role is : " + authorizationLevel);

        userID = cog.getUserID(conn, userName);
        System.out.println("Your user id is : " + userID);
//-----------------------------------------------------------------------------------------------------------------
        // 2 Register a new user
        System.out.println("Registering a new user.");
        outcome = cog.addNewUser(conn, "ADMIN", "chbrown", "charlie.brown@revature.net", "snoopy",
                "Charlie", "Brown", true, "2");

        // System.out.println(Security.getProviders());
//-----------------------------------------------------------------------------------------------------------------
        // 3 log in as Shaggy Rogers
        System.out.println("\nLog in as a lowly employee.");
        System.out.print("User name: ");
        userName = getInput.nextLine();
        System.out.print("Password:  ");
        password = getInput.nextLine();
        if (!cog.login(conn, userName, password)) {
            System.out.println("You are not an authorized user of the ERS System.");
            return;
        }
        authorizationLevel = cog.getPermissions(conn, userName);
        userID = cog.getUserID(conn, userName);

        System.out.println("Your authorization level is " + authorizationLevel);

//------------------------------------------------------------------------------------------------------------------
        // 4  Create a new reimbursement as an EMPLOYEE
        // submitReimbursement(Connection conn, double amount, Date submitted,
        //                                   String description, String authorId, String statusId, String typeId)
        //boolean outcome;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        result = formatter.format(date);
        whatHappened = cog.submitReimbursement(conn, 18.00, date, "Dinner", "2", "1", "3");

        System.out.println( "Result: " + whatHappened);
//-----------------------------------------------------------------------------------------------------------------
    // 5 Log in again as Charlie Brown
        System.out.println("\nLog in as a Finance manager.");
        System.out.print("User name: ");
        userName = getInput.nextLine();
        System.out.print("Password:  ");
        password = getInput.nextLine();
        System.out.print("What is the id of the reimbursement request to be changed? ");
        String horrible = getInput.nextLine();
        if (!cog.login(conn, userName, password)) {
            System.out.println("You are not an authorized user of the ERS System.");
            return;
        }

        // User is successfully logged in at this point
        authorizationLevel = cog.getPermissions(conn, userName);
        userID = cog.getUserID(conn, userName);
        System.out.println("Your user role is " + authorizationLevel);
//-----------------------------------------------------------------------------------------------------------------
        // 6 change status of a reimbursement request

        //  changeReimbursementStatus(Connection conn, String authorizationLevel, String userID, String reimbId, String newStatus) {
        whatHappened = cog.changeReimbursementStatus(conn, authorizationLevel, userID, horrible, "3");
        System.out.println(whatHappened);
//------------------------------------------------------------------------------------------------------------------
        // 7  Show the details of the changed reimbursement request
        // log back in as user ardavidson

        System.out.println("\nLog in as any kind of user");
        System.out.print("User name: ");
        userName = getInput.nextLine();
        System.out.print("Password:  ");
        password = getInput.nextLine();
        if (!cog.login(conn, userName, password)) {
            System.out.println("You are not an authorized user of the ERS System.");
            return;
        }

        // User is successfully logged in at this point
        authorizationLevel = cog.getPermissions(conn, userName);
        userID = cog.getUserID(conn, userName);

        System.out.println("Your user role is : " + authorizationLevel);
        System.out.println("Your user id is : " + userID);

        ResultSet rs = cog.displayReimbursement(conn, authorizationLevel, userName);



//---------------------------------------------------------------------------------------------------------------
        // All done
        System.out.println("\n\n\nHashing algorithms available to this version of java:");
        try {
            conn.close();
            getInput.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Provider[] algorithms = Security.getProviders();
        for (Provider target : algorithms) {

            System.out.println(target.toString() + "  " + target.getName());
            //System.out.println(target);
        }

        System.out.println("\n\nNow you know why I couldn't use SHA-256.");

        System.out.println("\n\nThank you for using ERS.");
    }
}
