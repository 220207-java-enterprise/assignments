package com.revature.foundations.daos;

import com.revature.foundations.models.ERSUserRoles;
import com.revature.foundations.models.ERSUsers;
import com.revature.foundations.util.ConnectionFactory;
import com.revature.foundations.util.exceptions.DataSourceException;
import com.revature.foundations.util.exceptions.ResourcePersistenceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ERSUsersDAO implements CrudDAO<ERSUsers> {

    private final String rootSelect = "SELECT " +
            "au.USER_ID, au.EMAIL, au.USERNAME, au.PASSWORD, au.ROLE_ID, ur.ROLE " +
            "FROM ERS_USERS au " +
            "JOIN ERS_USER_ROLES ur " +
            "ON au.ROLE_ID = ur.ROLE_ID ";

    public ERSUsers findUserByUsername(String username) {

        ERSUsers user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE USERNAME = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new ERSUsers();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(new ERSUserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public ERSUsers findUserByEmail(String email, Object String) {

        ERSUsers user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE EMAIL = ?");
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new ERSUsers();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(new ERSUserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

        public ERSUsers findUserByUsernameAndPassword(String email, String password) {

            ERSUsers authUser = null;

            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

                PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE USERNAME = ? AND PASSWORD = ?");
                pstmt.setString(1, email);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    authUser = new ERSUsers();
                    authUser.setUser_id(rs.getString("USER_ID"));
                    authUser.setEmail(rs.getString("EMAIL"));
                    authUser.setUsername(rs.getString("USERNAME"));
                    authUser.setPassword(rs.getString("PASSWORD"));
                    authUser.setRole(new ERSUserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
                }

            } catch (SQLException e) {
                throw new DataSourceException(e);
            }

            return authUser;
        }

    @Override
    public void save(ERSUsers newUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

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
    public ERSUsers getById(String user_id) {

        ERSUsers user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE USER_ID = ?");
            pstmt.setString(1, user_id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new ERSUsers();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(new ERSUserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

    @Override
    public List<ERSUsers> getAll() {

        List<ERSUsers> users = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            ResultSet rs = conn.createStatement().executeQuery(rootSelect);
            while (rs.next()) {
                ERSUsers user = new ERSUsers();
                user.setUser_id(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(new ERSUserRoles(rs.getString("ROLE"), rs.getString("ROLE_ID")));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return users;
    }

    @Override
    public void update(ERSUsers updatedUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE ERS_USERS " +
                    "SET EMAIL = ?, " +
                    "USERNAME = ?, " +
                    "PASSWORD = ? " +
                    "WHERE USER_ID = ?");
            pstmt.setString(3, updatedUser.getEmail());
            pstmt.setString(4, updatedUser.getUsername());
            pstmt.setString(5, updatedUser.getPassword());
            pstmt.setString(6, updatedUser.getUser_id());

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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM app_users WHERE id = ?");
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

    }
