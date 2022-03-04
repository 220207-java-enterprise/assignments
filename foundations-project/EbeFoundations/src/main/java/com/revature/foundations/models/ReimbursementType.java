package com.revature.foundations.models;

public class ReimbursementType {
    private String typeId;
    private String type;

    public ReimbursementType() {
    }

    public ReimbursementType(String typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public ReimbursementType(String type){
        this.type=type;
    }


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "typeId='" + typeId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
