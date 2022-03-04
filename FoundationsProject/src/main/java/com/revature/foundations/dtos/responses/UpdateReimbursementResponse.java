package com.revature.foundations.dtos.responses;

import com.revature.foundations.models.Reimbursements;

public class UpdateReimbursementResponse {

    private double amount;
    private String description;
    private String reimb_id;

    public UpdateReimbursementResponse(){ super();}

    public UpdateReimbursementResponse(Reimbursements reimbursement){
        this.amount = reimbursement.getAmount();
        this.description = reimbursement.getDescription();
        this.reimb_id = reimbursement.getReimb_id();
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

}
