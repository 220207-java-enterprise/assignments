package com.revature.foundations.dtos.requests;

import com.revature.foundations.models.ERSUserRoles;
import com.revature.foundations.models.ERSUsers;

import java.util.UUID;

public class NewUserRequest {

    private String username;
    private String email;
    private String password;
    private String given_name;
    private String surname;
    private boolean is_Active;
    private String role;

    public NewUserRequest() {
        super();
    }

    public NewUserRequest(String username, String email, String password, String given_name, String surname, String role) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.given_name = given_name;
        this.surname = surname;
        this.is_Active = extractUser().getIs_active();
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isIs_Active() {
        return is_Active;
    }

    public void setIs_Active(boolean is_Active) {
        this.is_Active = is_Active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ERSUsers extractUser() {
        String user_id = UUID.randomUUID().toString();
        String role_id = UUID.randomUUID().toString();
        ERSUserRoles aRole = new ERSUserRoles(role_id, this.role);
        return new ERSUsers(user_id, username, email, password, given_name, surname, false, aRole);
    }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", given_name='" + given_name + '\'' +
                ", surname='" + surname + '\'' +
                ", is_Active=" + is_Active +
                ", role='" + role + '\'' +
                '}';
    }
}
