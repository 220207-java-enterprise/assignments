package com.revature.Scratch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ConnectionFactory {



        public Connection connect() {
            System.out.println("in the connect() method.");
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(getdbUrl(), getdbUserName(), getdbPassword());
                //conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?CurrentSchema=Foundations", "postgres", "revature");
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return conn;
        }

        public String getdbUrl() {
            String result = "";

            Scanner getInput = null;
            try {
                getInput = new Scanner(new FileReader("src/main/resources/application.properties"));
                String temp;
                temp = getInput.nextLine();
                System.out.println(temp);
                result = temp.substring(7);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                getInput.close();
            }
            return result;
        }

        public String getdbUserName() {
            String result = "";
            Scanner getInput = null;
            try {
                getInput = new Scanner(new FileReader("src/main/resources/application.properties"));

                String temp;
                temp = getInput.nextLine();
                temp = getInput.nextLine();
                result = temp.substring(12);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } finally {
            getInput.close();
            }

            return result;
        }

        public String getdbPassword() {
            String result = "";
            Scanner getInput = null;
            try {
                getInput = new Scanner(new FileReader("src/main/resources/application.properties"));
                String temp;
                temp = getInput.nextLine();
                temp = getInput.nextLine();
                temp = getInput.nextLine();
                result = temp.substring(12);
            }
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                getInput.close();
            }

            return result;
        }






}
