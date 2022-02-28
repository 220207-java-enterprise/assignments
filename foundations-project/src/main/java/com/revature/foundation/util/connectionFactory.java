package com.revature.foundation.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionFactory {

    private static connectionFactory connectionFactory;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Properties props = new Properties();

    private connectionFactory() {
        try {
            props.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static connectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new connectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(props.getProperty("db-url"), props.getProperty("db-username"), props.getProperty("db-password"));

        if (conn == null) {
            throw new RuntimeException("Could not establish connection with the database!");
        }

        return conn;

    }

}


