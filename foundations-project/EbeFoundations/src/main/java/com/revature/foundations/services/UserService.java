package com.revature.foundations.services;

import com.revature.foundations.daos.UserDAO;
import com.revature.foundations.dtos.requests.LoginRequest;
import com.revature.foundations.dtos.requests.NewUserRequest;
import com.revature.foundations.dtos.responses.UserResponse;
import com.revature.foundations.models.User;
import com.revature.foundations.models.UserRole;
import com.revature.foundations.util.exceptions.AuthenticationException;
import com.revature.foundations.util.exceptions.InvalidRequestException;
import com.revature.foundations.util.exceptions.ResourceConflictException;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {

    private UserDAO userDao; // a dependency of UserService

    // Constructor injection
    public UserService(UserDAO userDAO) {
        this.userDao = userDAO;
    }

    public List<UserResponse> getAllUsers() {

        // Pre-Java 8 mapping logic (without Streams)
//        List<AppUser> users = userDAO.getAll();
//        List<AppUserResponse> userResponses = new ArrayList<>();
//        for (AppUser user : users) {
//            userResponses.add(new AppUserResponse(user));
//        }
//        return userResponses;

        // Java 8+ mapping logic (with Streams)
        return UserDAO.getAll()
                .stream()
                .map(UserResponse::new) // intermediate operation
                .collect(Collectors.toList()); // terminal operation
    }


  /*My logic for authentication


  private boolean isUserAuthenticated(User appUser){
      //We need to get a JWT token for registered employees and FM;

  }    */

    public User register(NewUserRequest newUserRequest) throws IOException {

        User newUser = newUserRequest.extractUser();

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Bad registration details given.");
        }
// I feel like we should check the presence of email and username before checking validation...but its fine

        boolean usernameAvailable = isUsernameAvailable(newUser.getUsername());
        boolean emailAvailable = isEmailAvailable(newUser.getEmail());

        if (!usernameAvailable || !emailAvailable) {
            String msg = "The values provided for the following fields are already taken by other users: ";
            if (!usernameAvailable) msg += "username ";
            if (!emailAvailable) msg += "email";
            throw new ResourceConflictException(msg);
        }

        // TODO encrypt provided password before storing in the database

        newUser.setUserId(UUID.randomUUID().toString());
        //I added the code below and defaulted all to 3 / employee
        //  newUser.setRole_id("3");
        newUser.setRole(new UserRole("3", "Employee")); // All newly registered users start as BASIC_USER
        newUser.setActive(false); // Admin will need to update this so they can log in ...
        UserDAO.save(newUser);

        return newUser;
    }

    public User login(LoginRequest loginRequest) throws AuthenticationException {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (!isUsernameValid(username) || !isPasswordValid(password)) {
            throw new InvalidRequestException("Invalid credentials provided!");
        }

        // TODO encrypt provided password (assumes password encryption is in place) to see if it matches what is in the DB

        User authUser = UserDAO.findUserByUsernameAndPassword(username, password);

        if (authUser == null) {
            throw new AuthenticationException();
        }

        return authUser;

    }

    private boolean isUserValid(User appUser) {

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
    }

    public boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public boolean isUsernameAvailable(String username) {
        return UserDAO.findUserByUsername(username) == null;
    }

    public boolean isEmailAvailable(String email) {
        return UserDAO.findUserByEmail(email) == null;
    }

}



