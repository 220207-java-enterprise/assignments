package com.revature.foundations.dtos.responses;

import com.revature.foundations.models.ERSUsers;

public class Principal {

    private String user_id;
    private String username;
    private String role;

    public Principal() {
        super();
    }

    public Principal(ERSUsers user) {
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
        this.role = user.getRole().getRole_id();
    }

}
