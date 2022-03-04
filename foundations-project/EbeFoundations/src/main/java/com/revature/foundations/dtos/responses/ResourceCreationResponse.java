package com.revature.foundations.dtos.responses;

public class ResourceCreationResponse {

    private String id;

    public ResourceCreationResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
