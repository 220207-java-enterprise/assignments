package com.revature.Scratch;

import sun.plugin2.message.Message;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import static java.sql.ResultSet.*;

public class Gears {
    public static String getPermissions(Connection conn, String userName) {
        String result = "";

        //conn.createStatement()

        String selectStatement = "Select eur.role from ers_users eu "
                + "inner join ers_user_roles eur "
                + "on eur.role_id = eu.role_id where eu.username = ? and eu.is_active = true;";

        try {
            PreparedStatement getRole = conn.prepareStatement(selectStatement);
            conn.setAutoCommit(false);
            getRole.setString(1, userName);
            System.out.println("Executing getPermissions' getRole query.");
            ResultSet rs = getRole.executeQuery();
            rs.next();
            result = rs.getString("role");
            rs.close();
            getRole.close();
            conn.setAutoCommit(true);

            //conn.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }


    public boolean login(Connection conn, String userName, String password) {
        boolean result = false;
        String outcome = "";
        String selectStatement = "Select eu.user_ID from ers_users eu where eu.userName = ? and eu.password = ? "
                + " AND is_active = true;";

        try {
            PreparedStatement getUserId = conn.prepareStatement(selectStatement, TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
            //conn.setAutoCommit(false);
            getUserId.setString(1, userName);
            getUserId.setString(2, password);
            ResultSet rs = getUserId.executeQuery();
            if (!rs.first())
                return result;
            //rs.next();
            outcome = rs.getString("User_ID");
            rs.close();
            getUserId.close();

            //conn.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }


    //2
    public ResultSet viewReimbursements(Connection conn, String userID) {

        ResultSet result = null;

        String queryString = "select er.reimb_id, er.amount, er.submitted, er.resolved, er.description, er.recepit, "
                + "er.er.payment_id, eu.username, eu2.username, ers.status, ert.type "
                + " from ers_reimbursements er inner join ers_users eu on er.author_id = eu.user_id "
                + "left outer join ers_users eu2 on eu2.user_id = er.resolver_id "
                + "left outer join ers_reimbursement_statuses ers on ers.status_id = er.status_id "
                + "left outer join ers_reimbursement_types ert on ert.type_id = er.type.id "
                + "where eu.is_active is true and eu.user_id = ?;";

        try {
            PreparedStatement getReimbursements = conn.prepareStatement(queryString, TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
            conn.setAutoCommit(false);
            getReimbursements.setString(1, userID);
            result = getReimbursements.executeQuery();
            //result.close();
            getReimbursements.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return result;
        }

        return result;
    }

    //3
// Deleted.  #2 already shows all the reimbursement details for a particular user's reimbursements
// 4
    public String editReimbursement(Connection conn, double amount, String userID, String reimbId) {
        String result = "update ers_reimbursements"
                + "set amount = ?, description = ?, type_id = ? "
                + "where reimb_id = ?";

        if (reimbId != "LODGING" && reimbId != "TRAVEL" && reimbId != "FOOD" && reimbId != "OTHER") {
            result = "No such reimbursement type.";
            return result;
        }
        try {
            PreparedStatement updateReimbursements = conn.prepareStatement(result);
            conn.setAutoCommit(false);
            updateReimbursements.setDouble(1, amount);
            updateReimbursements.setString(2, reimbId);
            // System.out.println("Executing getPermissions' getRole query.");
            ResultSet rs = updateReimbursements.executeQuery();
            updateReimbursements.close();
            // rs.next();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return result;
    }

    // 5
    public ResultSet viewAllReimbursements(Connection conn, String authorizationLevel) {
        ResultSet result = null;

        if (authorizationLevel == "EMPLOYEE") {
            System.out.println("You are not authorized to do that.");
            return result;
        }

        String queryString = "select er.reimb_id, er.amount, er.submitted, er.resolved, er.description, er.receipt ,\n" +
                "er.payment_id, eu.username, eu2.username, ers.status, ert.type \n" +
                "from ers_reimbursements er inner join ers_users eu on er.author_id = eu.user_id \n" +
                "left outer join ers_users eu2 on eu2.user_id = er.resolver_id \n" +
                "left outer join ers_reimbursement_statuses ers on ers.status_id = er.status_id \n" +
                "left outer join ers_reimbursement_types ert on ert.type_id = er.type_id \n" +
                "where eu.is_active is true;";

        try {
            PreparedStatement getReimbursements = conn.prepareStatement(queryString, TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
            conn.setAutoCommit(false);
            // getReimbursements.setString(1, userID);
            // System.out.println("Executing getPermissions' getRole query.");
            ResultSet rs = getReimbursements.executeQuery();
            // rs.next();
            result = rs;
            rs.close();
            getReimbursements.close();

            //conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    // 6
    public ResultSet filterReimbursementsByStatus(Connection conn, String authorizationLevel, String status) {
        ResultSet result = null;

        if (authorizationLevel == "EMPLOYEE") {
            System.out.println("You are not authorized to do that.");
            return result;
        }

        if ((status != "Pending") && (status != "Approved") && (status != "Denied")) {
            System.out.println("No such status.");
            return result;
        }

        String queryString = "select er.reimb_id, er.amount, er.submitted, er.resolved, er.description, er.receipt , " +
                "er.payment_id, eu.username, eu2.username, ers.status, ert.type" +
                "from ers_reimbursements er inner join ers_users eu on er.author_id = eu.user_id " +
                "left outer join ers_users eu2 on eu2.user_id = er.resolver_id " +
                "left outer join ers_reimbursement_statuses ers on ers.status_id = er.status_id" +
                "left outer join ers_reimbursement_types ert on ert.type_id = er.type_id" +
                "where eu.is_active is true and ers.status = ?;";

        try {
            PreparedStatement getReimbursements = conn.prepareStatement(queryString, TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
            conn.setAutoCommit(false);
            getReimbursements.setString(1, status);
            ResultSet rs = getReimbursements.executeQuery();

            conn.setAutoCommit(false);
            result = rs;
            rs.close();
            getReimbursements.close();
            conn.setAutoCommit(true);
            //conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public ResultSet filterReimbursementsByType(Connection conn, String authorizationLevel, String type) {
        ResultSet result = null;

        if (authorizationLevel == "EMPLOYEE") {
            System.out.println("You are not authorized to do that.");
            return result;
        }

        if ((type != "Pending") && (type != "Approved") && (type != "Denied")) {
            System.out.println("No such status.");
            return result;
        }

        String queryString = "select er.reimb_id, er.amount, er.submitted, er.resolved, er.description, er.receipt , " +
                "er.payment_id, eu.username, eu2.username, ers.status, ert.type" +
                "from ers_reimbursements er inner join ers_users eu on er.author_id = eu.user_id " +
                "left outer join ers_users eu2 on eu2.user_id = er.resolver_id " +
                "left outer join ers_reimbursement_statuses ers on ers.status_id = er.status_id" +
                "left outer join ers_reimbursement_types ert on ert.type_id = er.type_id" +
                "where eu.is_active is true and ers.status = ?;";

        try {
            PreparedStatement getReimbursements = conn.prepareStatement(queryString, TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
            conn.setAutoCommit(false);
            getReimbursements.setString(1, type);
            ResultSet rs = getReimbursements.executeQuery();

            conn.setAutoCommit(false);
            result = rs;
            rs.close();
            getReimbursements.close();
            conn.setAutoCommit(true);
            //conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    //7


    //8
    public int changeReimbursementStatus(Connection conn, String authorizationLevel, String userID, String reimbId, String newStatus) {
        if (!authorizationLevel.equals("ADMIN") && !authorizationLevel.equals("FINANCE MANAGER")) {
            System.out.println("You are not authorized to do that.");
            return -1;
        }

        if (newStatus != "1" && newStatus != "2" && newStatus != "3") {
            System.out.println("That is not a valid status.");
            return -1;
        }
        int outcome = 0;
        String result = "update ers_reimbursements "
                + "set status_id = ?, resolved = ?, resolver_id = ? "
                + "where reimb_id = ? and resolved is null";

        try {
            PreparedStatement updateReimbursements = conn.prepareStatement(result);
            conn.setAutoCommit(false);
            updateReimbursements.setString(1, newStatus);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            result = formatter.format(date);
            System.out.println("Reimbursement resolved on " + date);
            updateReimbursements.setDate(2, (java.sql.Date) date);
            updateReimbursements.setString(3, userID);
            updateReimbursements.setString(4, reimbId);
            // System.out.println("Executing getPermissions' getRole query.");
            System.out.println("Attempting to update the reimbursement.");
            System.out.println(updateReimbursements.toString());
            // Don't use an execute command where you need to use an executeUpdate command
            outcome = updateReimbursements.executeUpdate();
            updateReimbursements.close();
            // rs.next();
            // rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return outcome;
    }

    // 9
    public boolean addNewUser(Connection conn, String authorizationLevel, String username, String email, String password,
                             String givenName, String surname, boolean is_active, String role_id) {
        String result = "";
        System.out.println("Auth level is " + authorizationLevel);
        if (!authorizationLevel.equals("ADMIN")) {
            System.out.println("You are not authorized to do that.");
            return false;
        }
        boolean outcome = false;
        try {
            String insertString = "insert into ers_users (user_id, username, email, password, given_name, "
                    + "surname, is_active, role_id) values ( "
                    + "?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement insertUser = conn.prepareStatement(insertString);

            conn.setAutoCommit(false);
            insertUser.setString(1, newUUID());
            insertUser.setString(2, username);
            insertUser.setString(3, email);
            insertUser.setString(4, password);
            insertUser.setString(5, givenName);
            insertUser.setString(6, surname);
            insertUser.setBoolean(7, true);
            insertUser.setString(8, role_id);
            System.out.println("Executing getPermissions' getRole query.");
            outcome = insertUser.execute();
            System.out.println("Outcome is " + outcome);
            conn.commit();
            conn.setAutoCommit(true);
            insertUser.close();
            // rs.next();
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outcome;
    }

    // add new reimbursement request
    public String newRequest(Connection conn, double amount, Date submitted, String description,
                             Blob receipt, String author_id, String status_id, String type_id) {
        String result = "";

        try {
            String insertString = "insert into ers_reimbursements (reimb_id, amount, submitted, description," +
                    " receipt, author_id, status_id, type_id) values ( "
                    + "?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement insertUser = conn.prepareStatement(result);
            conn.setAutoCommit(false);
            insertUser.setString(1, "1");
            insertUser.setDouble(2, amount);
            insertUser.setDate(3, submitted);
            insertUser.setString(4, description);
            insertUser.setBlob(5, receipt);
            insertUser.setString(6, author_id);
            insertUser.setString(7, status_id);
            insertUser.setString(8, type_id);
            // System.out.println("Executing getPermissions' getRole query.");
            ResultSet rs = insertUser.executeQuery();
            conn.commit();
            conn.setAutoCommit((true));
            insertUser.close();
            // rs.next();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // 10
    public String updateUser(Connection conn, String authorizationLevel, String userId, String victimID,
                             String username, String email, String password, String givenName, String surname,
                             boolean is_active, String role_id) {
        String result = "";

        if (!authorizationLevel.equals("ADMIN")) {
            System.out.println("You are not authorized to do that.");
        }
        try {
            String updateString = "update ers_users set username = ?, email = ?, password = ?, given_name = ?," +
                    "surname = ?, is_active = ?, role_id = ? " +
                    "where user_id = ?;";
            PreparedStatement insertUser = conn.prepareStatement(result);
            conn.setAutoCommit(false);
            insertUser.setString(1, username);
            insertUser.setString(2, email);
            insertUser.setString(3, password);
            insertUser.setString(4, givenName);
            insertUser.setString(5, surname);
            insertUser.setBoolean(6, is_active);
            insertUser.setString(7, role_id);
            insertUser.setString(8, victimID);
            // System.out.println("Executing getPermissions' getRole query.");
            ResultSet rs = insertUser.executeQuery();
            conn.commit();
            conn.setAutoCommit((true));
            insertUser.close();
            // rs.next();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }
    // 11
    public boolean deleteUser(Connection conn, String authorizationLevel, String victimId) {
        boolean result = false;
        if (!authorizationLevel.equals("ADMIN")) {
            System.out.println("You are not authorized to do that.");
            return false;
        }
        String deleteStatement = "update ers_users set is_active = false" +
                "where user_id = ?";
        boolean outcome = false;
        try {
            PreparedStatement deleteU = conn.prepareStatement(deleteStatement);
            deleteU.setString(1, victimId);
            //System.out.println("Executing getPermissions' getRole query.");
            outcome = deleteU.execute();
            deleteU.close();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }

        return outcome;
    }

    public static String getUserID(Connection conn, String userName) {
        String result = "";

        String selectStatement = "Select user_id from ers_users eu "
                + "where eu.username = ?";
        String userID = "";
        try {
            PreparedStatement getID = conn.prepareStatement(selectStatement);
            conn.setAutoCommit(false);
            getID.setString(1, userName);
            //System.out.println("Executing getPermissions' getRole query.");
            ResultSet rs = getID.executeQuery();
            rs.next();
            result = rs.getString("user_id");
            rs.close();
            getID.close();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
        return result;
    }

    public ResultSet displayReimbursement(Connection conn, String authorizationLevel,  String username ) {
        ResultSet result = null;

        if (authorizationLevel == "EMPLOYEE") {


            String queryString = "select er.reimb_id, er.amount, er.submitted, er.resolved, er.description , " +
                    "er.payment_id, eu.username, eu2.username as Resolver, ers.status, ert.type , eur.Role " +
                    "from ers_reimbursements er inner join ers_users eu on er.author_id = eu.user_id " +
                    "left outer join ers_users eu2 on eu2.user_id = er.resolver_id " +
                    "left outer join ers_reimbursement_statuses ers on ers.status_id = er.status_id " +
                    "left outer join ers_reimbursement_types ert on ert.type_id = er.type_id " +
                    "left outer join ers_user_roles eur on eur.role_id = eu.role_id " +
                    "where eu.is_active is true AND eu.username = ? ) " +
                    "order by eu.username ;";

            try {
                PreparedStatement getReimbursements = conn.prepareStatement(queryString, TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
                conn.setAutoCommit(false);
                getReimbursements.setString(1, username);
                System.out.println(getReimbursements.toString());
                ResultSet rs = getReimbursements.executeQuery();

                String reimb_id = "", description = "", payment_id = "", userName2 = "", resolver = "";
                String status = "", type = "", role = "";
                double amount;
                Date submitted, resolved;

                while (rs.next()) {
                    reimb_id = rs.getString("reimb_id");
                    amount = rs.getDouble("amount");
                    submitted = rs.getDate("submitted");
                    resolved = rs.getDate("resolved");
                    description = rs.getString("description");
                    payment_id = rs.getString("payment_id");
                    userName2 = rs.getString("username");
                    resolver = rs.getString("resolver");
                    status = rs.getString("status");
                    type = rs.getString("type");
                    role = rs.getString("role");

                    System.out.println("Reimbursement ID: " + reimb_id);
                    System.out.println("Amount: " + amount);
                    System.out.println("Submitted on " + submitted);
                    System.out.println("Resolved on: " + resolved);
                    System.out.println("Description: " + description);
                    System.out.println("Payment ID: " + payment_id);
                    System.out.println("Requestor: " + userName2);
                    System.out.println("Resolver: " + resolver);
                    System.out.println("Status: " + status);
                    System.out.println("Type: " + type);
                    System.out.println("User Role: " + role);
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                }

                //conn.setAutoCommit(false);
                result = null;
                rs.close();
                getReimbursements.close();
                //conn.setAutoCommit(true);
                //conn.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else {


            String queryString = "select er.reimb_id, er.amount, er.submitted, er.resolved, er.description , " +
                    "er.payment_id, eu.username, eu2.username as Resolver, ers.status, ert.type , eur.Role " +
                    "from ers_reimbursements er inner join ers_users eu on er.author_id = eu.user_id " +
                    "left outer join ers_users eu2 on eu2.user_id = er.resolver_id " +
                    "left outer join ers_reimbursement_statuses ers on ers.status_id = er.status_id " +
                    "left outer join ers_reimbursement_types ert on ert.type_id = er.type_id " +
                    "left outer join ers_user_roles eur on eur.role_id = eu.role_id " +
                    "where eu.is_active is true  " +
                    "order by eu.username ;";

            try {
                PreparedStatement getReimbursements = conn.prepareStatement(queryString, TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
                conn.setAutoCommit(false);
                System.out.println(getReimbursements.toString());
                ResultSet rs = getReimbursements.executeQuery();

                String reimb_id = "", description = "", payment_id = "", userName2 = "", resolver = "";
                String status = "", type = "", role = "";
                double amount;
                Date submitted, resolved;

                while (rs.next()) {
                    reimb_id = rs.getString("reimb_id");
                    amount = rs.getDouble("amount");
                    submitted = rs.getDate("submitted");
                    resolved = rs.getDate("resolved");
                    description = rs.getString("description");
                    payment_id = rs.getString("payment_id");
                    userName2 = rs.getString("username");
                    resolver = rs.getString("resolver");
                    status = rs.getString("status");
                    type = rs.getString("type");
                    role = rs.getString("role");

                    System.out.println("Reimbursement ID: " + reimb_id);
                    System.out.println("Amount: " + amount);
                    System.out.println("Submitted on " + submitted);
                    System.out.println("Resolved on: " + resolved);
                    System.out.println("Description: " + description);
                    System.out.println("Payment ID: " + payment_id);
                    System.out.println("Requestor: " + userName2);
                    System.out.println("Resolver: " + resolver);
                    System.out.println("Status: " + status);
                    System.out.println("Type: " + type);
                    System.out.println("User Role: " + role);
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                }

                //conn.setAutoCommit(false);
                result = null;
                rs.close();
                getReimbursements.close();
                //conn.setAutoCommit(true);
                //conn.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    // 1
    public int submitReimbursement(Connection conn, double amount, Date submitted,
                                   String description, String authorId, String statusId, String typeId) {
        int result = 0;
        String insertStatement = "insert into ers_reimbursements(reimb_id, amount, submitted, description, author_id, "
                + "status_id, type_id) values (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement insertReimbursement = conn.prepareStatement(insertStatement);
            conn.setAutoCommit(false);
            String horrible = newUUID();
            insertReimbursement.setString(1, horrible);
            insertReimbursement.setDouble(2, amount);
            insertReimbursement.setDate(3, (java.sql.Date) submitted);
            insertReimbursement.setString(4, description);
            insertReimbursement.setString(5, authorId);
            insertReimbursement.setString(6, statusId);
            insertReimbursement.setString(7, typeId);
            result = insertReimbursement.executeUpdate();
            insertReimbursement.close();
            conn.setAutoCommit(true);
            System.out.println("The new reimbursement request's ID is " + horrible);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //
        return result;
    }

    public String newUUID() {
        return UUID.randomUUID().toString();
    }

//    public String hashString(String originalMessage) {
//        byte[] encodedHash = new byte[512];
//        try {
//            final MessageDigest digest = MessageDigest.getInstance("SunRsaSign");
//            encodedHash = digest.digest(originalMessage.getBytes(StandardCharsets.UTF_8));
//            return bytesToHex(encodedHash);
//        } catch (NoSuchAlgorithmException ex) {
//            ex.printStackTrace();
//        }
//        return bytesToHex(encodedHash);
//    }

    public String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xFF & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}