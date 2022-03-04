package com.revature.foundations.util;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDriver {

    public static void main(String[] args)  {
        ConnectionFactory connFactory = ConnectionFactory.getInstance();


        String query = "Select * from ers_reimbursements";
        try (Statement stmt = connFactory.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String email = rs.getString("description");
                int id = rs.getInt("amount");
                System.out.println(email + " " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



