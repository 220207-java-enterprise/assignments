package com.revature.foundations.dtos.requests;

public class UpdateReimbursementRequest {

    private double amount;
    private String description;
    private String reimb_id;

    public UpdateReimbursementRequest(){ super();}

    public UpdateReimbursementRequest(double amount, String description,  String reimb_id){
        this.amount = amount;
        this.description = description;
        this.reimb_id = reimb_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(String reimb_id) {
        this.reimb_id = reimb_id;
    }

    @Override
    public String toString() {
        return "UpdateReimbursementRequest{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", reimb_id='" + reimb_id + '\'' +
                '}';
    }
}
