package com.revature.foundation.daos;

        import com.revature.foundation.models.Users;
        import com.revature.foundation.util.exceptions.ResourcePersistenceException;

        import java.io.*;
        import java.sql.*;
        import java.util.Arrays;

public class UserDAO implements CrudDAO<Users> {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public Users findUserByUsername(String username) {
        return null;
    }

    public Users findUserByEmail(String email) {
        return null;
    }

    public Users findUserByUsernameAndPassword(String username, String password) {


        return null;

    }

    @Override
    public void save(Users newUser) {
        try {
            File usersDataFile = new File("data/users.txt");
            FileWriter dataWriter = new FileWriter(usersDataFile, true);
            dataWriter.write(newUser.toFileString() + "\n");
            dataWriter.close();
        } catch (IOException e) {
            throw new ResourcePersistenceException("An error occurred when accessing the data file.");
        }
    }

    @Override
    public Users getById(String id) {
        String query = "select * from ers_users where user_id = ?";
        Users user = new Users();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user.setUserId(rs.getString("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setIsActive(rs.getString("is_active"));
                user.setRoleId(rs.getString("role_id"));

//                System.out.print(rs.getString("user_id"));
//                System.out.print(":" + rs.getString("username"));
//                System.out.print(":" + rs.getString("email"));
//                System.out.print(":" + rs.getString("password"));
//                System.out.print(":" + rs.getString("given_name"));
//                System.out.print(":" + rs.getString("surname"));
//                System.out.print(":" + rs.getString("is_active"));
//                System.out.print(":" + rs.getString("role_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Users[] getAll() {
        String queryAll = "select * from ers_users;";
        Users user = new Users();

        try {
            PreparedStatement ps = conn.prepareStatement(queryAll);
//            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

//            while()
            while(rs.next()){
                user.setUserId(rs.getString("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setIsActive(rs.getString("is_active"));
                user.setRoleId(rs.getString("role_id"));

//                System.out.print(rs.getString("user_id"));
//                System.out.print(":" + rs.getString("username"));
//                System.out.print(":" + rs.getString("email"));
//                System.out.print(":" + rs.getString("password"));
//                System.out.print(":" + rs.getString("given_name"));
//                System.out.print(":" + rs.getString("surname"));
//                System.out.print(":" + rs.getString("is_active"));
//                System.out.print(":" + rs.getString("role_id"));
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Users[]{user};
    }

    @Override
    public void update(Users updatedObject) {

    }

    @Override
    public void deleteById(String id) {

    }
}
