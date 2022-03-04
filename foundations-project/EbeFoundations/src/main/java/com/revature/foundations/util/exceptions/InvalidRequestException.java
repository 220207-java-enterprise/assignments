package com.revature.foundations.util.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("The provided request parameters did not meet validation requirements.");
    }

    public InvalidRequestException(String message) {
        super(message);
    }

}
