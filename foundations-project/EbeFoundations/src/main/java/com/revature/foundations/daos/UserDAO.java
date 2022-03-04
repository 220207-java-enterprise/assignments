package com.revature.foundations.daos;

import com.revature.foundations.models.User;
import com.revature.foundations.models.UserRole;
import com.revature.foundations.util.ConnectionFactory;
import com.revature.foundations.util.exceptions.DataSourceException;
import com.revature.foundations.util.exceptions.ResourcePersistenceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO  {

    private static final String rootSelect = "SELECT " +
            "eu.user_id, eu.given_name, eu.surname, eu.email, eu.username, eu.password, eu.is_active, eu.role_id, eur.role " +
            "FROM ers_users eu "
            +
          "JOIN ers_user_roles eur " +
          "ON eu.role_id = eur.role_id ";


// Getting ALL Users

    public static List<User> getAll() {

        List<User> users = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            ResultSet rs = conn.createStatement().executeQuery(rootSelect);
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setActive(rs.getBoolean("is_active"));
                user.setRole(new UserRole(rs.getString("role_id"), rs.getString("role")));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return users;
    }

    // When Registering

    public static void save(User newUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ers_users VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, newUser.getUserId());
            pstmt.setString(2, newUser.getUsername());
            pstmt.setString(3, newUser.getEmail());
            pstmt.setString(4, newUser.getPassword());
            pstmt.setString(5, newUser.getGivenName());
            pstmt.setString(6, newUser.getSurname());
            pstmt.setBoolean(7, newUser.getActive());
            pstmt.setString(8, newUser.getRole().getRoleId());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to persist user to data source");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    // When Logging

    public static User findUserByUsernameAndPassword(String username, String password) {

        User authUser = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                authUser = new User();
                authUser.setUserId(rs.getString("user_id"));
                authUser.setGivenName(rs.getString("given_name"));
                authUser.setSurname(rs.getString("surname"));
                authUser.setEmail(rs.getString("email"));
                authUser.setUsername(rs.getString("username"));
                authUser.setPassword(rs.getString("password"));
                authUser.setRole(new UserRole(rs.getString("role_id"), rs.getString("role")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return authUser;
    }

// Username lookup

    public static User findUserByUsername(String username) {

        User user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(new UserRole(rs.getString("role_id"), rs.getString("role")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

// Email Lookup

    public static User findUserByEmail(String email) {

        User user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE email = ?");
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(new UserRole(rs.getString("role_id"), rs.getString("role")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

// ID lookup

    public User getById(String id) {

        User user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE user_id = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setGivenName(rs.getString("given_name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(new UserRole(rs.getString("role_id"), rs.getString("role")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }


    public void update(User updatedUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE ers_users " +
                    "SET given_name = ?, " +
                    "surname = ?, " +
                    "email = ?, " +
                    "username = ?, " +
                    "password = ? " +
                    "WHERE user_id = ?");
            pstmt.setString(1, updatedUser.getGivenName());
            pstmt.setString(2, updatedUser.getSurname());
            pstmt.setString(3, updatedUser.getEmail());
            pstmt.setString(4, updatedUser.getUsername());
            pstmt.setString(5, updatedUser.getPassword());
            pstmt.setString(6, updatedUser.getUserId());

            // TODO allow role to be updated as well

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                throw new ResourcePersistenceException("Failed to update user data within datasource.");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }





    public void update(Object updatedObj) {

    }

    // Admin deleting a user

    public void deleteById(String id) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ers_users WHERE user_id = ?");
           // pstmt.setString(1, id);  Again commented out

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to delete user from data source");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }
}
