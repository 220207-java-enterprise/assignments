package com.revature.foundations.dtos.responses;

public class ResourceCreationResponse {

    private String user_id;

    public ResourceCreationResponse(String id) {
        this.user_id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setId(String id) {
        this.user_id = id;
    }
}
