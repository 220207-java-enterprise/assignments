package com.revature.foundations.daos;

import com.revature.foundations.models.UserRoles;
import com.revature.foundations.models.Users;
import com.revature.foundations.util.ConnectionFactory;
import com.revature.foundations.util.exceptions.DataSourceException;
import com.revature.foundations.util.exceptions.ResourcePersistenceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements CrudDAO<Users> {

    private final String rootSelect = "SELECT " +
                                        "au.USER_ID, " +
                                        "au.EMAIL, " +
                                        "au.USERNAME, " +
                                        "au.PASSWORD, " +
                                        "au.GIVEN_NAME, " +
                                        "au.SURNAME, " +
                                        "au.IS_ACTIVE, " +
                                        "au.ROLE_ID, ur.ROLE " +
                                            "FROM ERS_USERS au " +
                                            "JOIN ERS_USER_ROLES ur " +
                                            "ON au.ROLE_ID = ur.ROLE_ID ";

    public Users findUserByUsername(String username) {

        Users user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE USERNAME = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new Users();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGiven_name(rs.getString("GIVEN_NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setIs_active(rs.getBoolean("IS_ACTIVE"));
                user.setRole(new UserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public Users findUserByEmail(String email) {

        Users user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE EMAIL = ?");
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new Users();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGiven_name(rs.getString("GIVEN_NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setIs_active(rs.getBoolean("IS_ACTIVE"));
                user.setRole(new UserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

        public Users findUserByUsernameAndPassword(String email, String password) {

            Users authUser = null;

            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

                PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE USERNAME = ? AND PASSWORD = ?");
                pstmt.setString(1, email);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    authUser = new Users();
                    authUser.setUser_id(rs.getString("USER_ID"));
                    authUser.setEmail(rs.getString("EMAIL"));
                    authUser.setUsername(rs.getString("USERNAME"));
                    authUser.setPassword(rs.getString("PASSWORD"));
                    authUser.setGiven_name(rs.getString("GIVEN_NAME"));
                    authUser.setSurname(rs.getString("SURNAME"));
                    authUser.setIs_active(rs.getBoolean("IS_ACTIVE"));
                    authUser.setRole(new UserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
                }

            } catch (SQLException e) {
                throw new DataSourceException(e);
            }

            return authUser;
        }

    @Override
    public void save(Users newUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt1 = conn.prepareStatement("INSERT INTO ers_user_roles VALUES (?, ?)");
            pstmt1.setString(1, newUser.getRole().getRole());
            pstmt1.setString(2, newUser.getRole().getRole_id());

            int rowsInserted1 = pstmt1.executeUpdate();
            if (rowsInserted1 != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to persist user role to data source");
            }

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ERS_USERS VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, newUser.getUser_id());
            pstmt.setString(4, newUser.getEmail());
            pstmt.setString(5, newUser.getUsername());
            pstmt.setString(6, newUser.getPassword());
            pstmt.setString(7, newUser.getRole().getRole_id());

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

    @Override
    public Users getById(String user_id) {

        Users user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE USER_ID = ?");
            pstmt.setString(1, user_id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new Users();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGiven_name(rs.getString("GIVEN_NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setIs_active(rs.getBoolean("IS_ACTIVE"));
                user.setRole(new UserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

    @Override
    public List<Users> getAll() {

        List<Users> users = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            ResultSet rs = conn.createStatement().executeQuery(rootSelect);
            while (rs.next()) {
                Users user = new Users();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setGiven_name(rs.getString("GIVEN_NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setIs_active(rs.getBoolean("IS_ACTIVE"));
                user.setRole(new UserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return users;
    }

    @Override
    public void update(Users updatedUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE ERS_USERS " +
                                                                "SET EMAIL = ?, " +
                                                                "USERNAME = ?, " +
                                                                "PASSWORD = ?, " +
                                                                "GIVEN_NAME = ?, " +
                                                                "SURNAME = ?, " +
                                                                "IS_ACTIVE = ? " +
                                                                "WHERE USER_ID = ?");
            pstmt.setString(1, updatedUser.getEmail());
            pstmt.setString(2, updatedUser.getUsername());
            pstmt.setString(3, updatedUser.getPassword());
            pstmt.setString(4, updatedUser.getGiven_name());
            pstmt.setString(5, updatedUser.getSurname());
            pstmt.setBoolean(6, updatedUser.getIs_active());
            pstmt.setString(7, updatedUser.getUser_id());

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

    @Override
    public void deleteById(String user_id) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ERS_USERS WHERE USER_ID = ?");
            pstmt.setString(1, user_id);

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

    public Users getRole() {
        return null;
    }
}