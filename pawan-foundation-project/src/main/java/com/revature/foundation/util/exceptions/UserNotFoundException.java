package com.revature.foundation.util.exceptions;

public class UserNotFoundException extends RuntimeException{

    String message = "User not found, Please try again!";
    public UserNotFoundException(){
        System.out.println(message);
    }

}
