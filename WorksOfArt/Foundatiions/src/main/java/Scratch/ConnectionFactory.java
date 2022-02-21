package Scratch;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionFactory {



        public Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(getdbUrl(), getdbUserName(), getdbPasswordl());
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return conn;
        }

        public String getdbUrl() {
            Scanner getInput = new Scanner(new File("src/main/resources/application.properties"));
            String result, temp;
            temp = getInput.nextLine();
            result = temp.substring(6);
            getInput.close();

            return result;
        }

        public String getdbUserName() {
            Scanner getInput = new Scanner(new File("src/main/resources/application.properties"));
            String result, temp;
            temp = getInput.nextLine();
            temp = getInput.nextLine();
            result = temp.substring(12);
            getInput.close();

            return result;
        }

        public String getdbPasswordl() {
            Scanner getInput = new Scanner(new File("src/main/resources/application.properties"));
            String result, temp;
            temp = getInput.nextLine();
            temp = getInput.nextLine();
            temp = getInput.nextLine();
            result = temp.substring(12);
            getInput.close();

            return result;
        }






}
