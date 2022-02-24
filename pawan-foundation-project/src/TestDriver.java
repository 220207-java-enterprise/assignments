package test_utils;


//import com.revature.foundation.utils.exceptions.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDriver {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql//localhost:5432/postgres?currentSchema=foundation", "postgres", "revature");

        if (conn == null)
            throw new RuntimeException("Connection could not be established");
        else
            System.out.println("Connected to foundation database");



    }
}
