package com.revature.foundation.dtos;

import com.revature.foundation.models.ErsUser;

public class RegisterNewUser extends ErsUser {

    public RegisterNewUser(){
        super();
    }

    public RegisterNewUser(String firstName, String lastName, String email, String username,
                           String password, String roleId, Boolean isActive){
        super(firstName, lastName, email, username, password, roleId, isActive);
    }


}
