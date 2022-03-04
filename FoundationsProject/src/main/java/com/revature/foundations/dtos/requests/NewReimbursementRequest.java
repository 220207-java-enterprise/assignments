package com.revature.foundations.dtos.requests;

import com.revature.foundations.models.ReimbursementStatuses;
import com.revature.foundations.models.ReimbursementTypes;
import com.revature.foundations.models.Reimbursements;

import java.util.UUID;

public class NewReimbursementRequest {

    private double amount;
    private String description;
    private String author_id;
    private String type;

    public NewReimbursementRequest(){super();}

    public NewReimbursementRequest(double amount, String description, String author_id, String type) {
        this.amount = amount;
        this.description = description;
        this.author_id = author_id;
        this.type = type;
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

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Reimbursements extractReimbursement() {
        String reimb_id = UUID.randomUUID().toString();
        ReimbursementStatuses status = new ReimbursementStatuses("PENDING", "PENDING");
        ReimbursementTypes type = new ReimbursementTypes(this.type, this.type);
        return new Reimbursements(reimb_id, this.amount, null, null,
                                    this.description, null, this.author_id, null, this.extractReimbursement().getStatus_id(), extractReimbursement().getType_id());
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", author_id='" + author_id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
