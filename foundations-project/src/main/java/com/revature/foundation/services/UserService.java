package com.revature.foundation.services;

import java.io.IOException;
import java.util.UUID;


        import com.revature.foundation.models.Users;
        import com.revature.foundation.daos.UserDAO;
        import com.revature.foundation.util.exceptions.AuthenticationException;
        import com.revature.foundation.util.exceptions.InvalidRequestException;

public class UserService {

    private UserDAO userDAO; // a dependency of UserService

    // Constructor injection
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Users register(Users newUser) throws IOException {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Bad registration details given."); // this will halt the app
        }

        // TODO validate that the provided username and email are not already taken

        // TODO encrypt provided password before storing in the database

        newUser.setUserId(UUID.randomUUID().toString());
        userDAO.save(newUser);

        return newUser;
    }

    public Users login(String username, String password) {

        if (!isUsernameValid(username) || !isPasswordValid(password)) {
            throw new InvalidRequestException("Invalid credentials provided!");
        }

        // TODO encrypt provided password (assumes password encryption is in place) to see if it matches what is in the DB

        Users authUser = userDAO.findUserByUsernameAndPassword(username, password);

        if (authUser == null) {
            throw new AuthenticationException();
        }

        return authUser;

    }

    private boolean isUserValid(Users appUser) {

        // First name and last name are not just empty strings or filled with whitespace
        if (appUser.getGivenName().trim().equals("") || appUser.getSurname().trim().equals("")) {
            return false;
        }

        // Usernames must be a minimum of 8 and a max of 25 characters in length, and only contain alphanumeric characters.
        if (!isUsernameValid(appUser.getUsername())) {
            return false;
        }

        // Passwords require a minimum eight characters, at least one uppercase letter, one lowercase
        // letter, one number and one special character
        if (!isPasswordValid(appUser.getPassword())) {
            return false;
        }

        // Basic email validation
        return isEmailValid(appUser.getEmail());

    }

    public boolean isEmailValid(String email) {
        if (email == null) return false;
        return email.matches("^[^@\\s]+@[^@\\s.]+\\.[^@.\\s]+$");
    }

    public boolean isUsernameValid(String username) {
        if (username == null) return false;
        return username.matches("^[a-zA-Z0-9]{8,25}");
//        return false;
    }

    public boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
//        return false;
    }

}
