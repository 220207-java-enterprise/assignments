import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TestDriver {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        Class.forName("org.postgresql.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:postgresql//localhost:5432/postgres?currentSchema=foundation", "postgres", "revature");
//
//        if (conn == null)
//            throw new RuntimeException("Connection could not be established");
//        else
//            System.out.println("Connected to foundation database");


        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=foundation";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","revature");

        Connection conn = DriverManager.getConnection(url, props);

        if (conn == null)
            throw new SQLException("Could not connect");
        else
            System.out.println("Success");


        String sql = "insert into ers_reimbursement_status (status_id, status)"
                + " values (?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString (1, "12345");
        preparedStatement.setString (2, "Active");
        preparedStatement.execute();

        conn.close();
    }
}
