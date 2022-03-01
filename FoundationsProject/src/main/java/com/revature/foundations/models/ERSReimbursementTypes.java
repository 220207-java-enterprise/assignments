package com.revature.foundations.models;

public class ERSReimbursementTypes {
    private String type_id;
    private String type;

    public ERSReimbursementTypes() {
        super();
    }

    public ERSReimbursementTypes(String type) {
        this.type = type;
    }

    public ERSReimbursementTypes(String type_id, String type) {
        this.type_id = type_id;
        this.type = type;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ERSReimbursementTypes{" +
                "type_id='" + type_id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
