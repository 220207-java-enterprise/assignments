package com.revature.foundations.models;

public class Users {

    private String user_id;
    private String username;
    private String email;
    private String password;
    private String given_name;
    private String surname;

    public Users() {
        super();
    }

    public Users(String user_id, String username, String email, String password, String given_name, String surname) {
            this.user_id = user_id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.given_name = given_name;
            this.surname = surname;
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

    @Override
    public String toString() {
        return "Users{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", given_name='" + given_name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

