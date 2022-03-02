package com.revature.foundations.daos;

import com.revature.foundations.models.ERSUserRoles;
import com.revature.foundations.models.ERSUsers;
import com.revature.foundations.util.ConnectionFactory;
import com.revature.foundations.util.exceptions.DataSourceException;

import javax.management.relation.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ERSUsersDAO implements CrudDAO<ERSUsers> {

    private final String rootSelect = "SELECT " +
            "au.id, au.first_name, au.last_name, au.email, au.username, au.password, au.role, ur.role_name " +
            "FROM app_users au " +
            "JOIN user_roles ur " +
            "ON au.role = ur.id ";

    public ERSUsers findUserByUsername(String username) {

        ERSUsers user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new ERSUsers();
                user.setUser_id(rs.getString("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(new ERSUserRoles(rs.getString("role"), rs.getString("role_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public ERSUsers findUserByEmail(String email) {

        ERSUsers user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE email = ?");
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new ERSUsers();
                user.setUser_id(rs.getString("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(new ERSUserRoles(rs.getString("role"), rs.getString("role_name")));
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;



    }
}
