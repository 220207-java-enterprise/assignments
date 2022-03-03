package com.revature.foundations.util.exceptions;

public class ResourceConflictException extends RuntimeException {

    public ResourceConflictException(Throwable cause) {
        super("The username or email you have provided has already been taken. Please choose a different one.", cause);
    }

    public ResourceConflictException(String msg) {
        super(msg);
    }

    public ResourceConflictException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
