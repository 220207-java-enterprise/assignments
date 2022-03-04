package com.revature.foundations.util.exceptions;

public class AuthenticationException extends ResourceNotFoundException {

    public AuthenticationException() {
        super("No user found using the provided credentials.");
    }

}
