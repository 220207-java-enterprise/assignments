package Scratch;

import Scratch.ConnectionFactory;

import java.sql.Connection;

public class Foundations {

    public static void main(String[] args) {
        ConnectionFactory connection = new ConnectionFactory();
        Connection conn= connection.connect();

        if (conn == null)
            System.out.println("Error -- connection not established.");
        else
            System.out.println("Success!");

        //connection.close();

    }
}
