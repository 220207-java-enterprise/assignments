package com.revature.foundations.dtos.responses;

import com.revature.foundations.models.Users;

public class UserResponse {

    private String user_id;
    private String username;
    private String email;
    private String password;
    private String given_name;
    private String surname;
    private Boolean is_active;
    private String role;

    public UserResponse() {super();}

    public UserResponse(Users user) {
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.given_name = user.getGiven_name();
        this.surname = user.getSurname();
        this.is_active = user.getIs_active();
        this.role = user.getRole().getRole_id();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
