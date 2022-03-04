package com.revature.foundations.dtos.responses;

import com.revature.foundations.models.User;

public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String role;

    public UserResponse() {
        super();
    }

    public UserResponse(User user) {
        this.id = user.getUserId();
        this.firstName = user.getGivenName();
        this.lastName = user.getSurname();
        this.username = user.getUsername();
        this.role = user.getRole().getRoleName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
