package com.revature.foundation.services;

import com.revature.foundation.dtos.RegisterNewUser;

public class UserService {

    private RegisterNewUser newUser;

    public UserService(RegisterNewUser newUser){
        this.newUser = newUser;
    }

    public RegisterNewUser register(RegisterNewUser newUser){
        return newUser;
    }
}