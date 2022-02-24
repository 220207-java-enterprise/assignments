//package com.revature.foundation.utils.exceptions;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class ConnectionFactory {
//
//    private static ConnectionFactory connectionFactory;
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        }
//        catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    private Properties properties = new Properties();
//
//    private ConnectionFactory() {
//        try {
//            properties.load(new FileReader("resources/application.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static ConnectionFactory getInstance(){
//        if (connectionFactory == null)
//            connectionFactory = new ConnectionFactory();
//        return connectionFactory;
//    }
//
//    public Connection getConnection() throws SQLException {
//        Connection connection = DriverManager.getConnection(properties.getProperty("db-url"), properties.getProperty("db-username"), properties.getProperty("db-password"));
//
//        if (connection == null)
//            throw new RuntimeException("Connection could not be established");
//
//        return connection;
//    }
//}