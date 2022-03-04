package com.revature.foundations.dtos.requests;

import com.revature.foundations.models.Reimbursement;
import com.revature.foundations.models.ReimbursementStatus;
import com.revature.foundations.models.ReimbursementType;

public class ReimbursementCreateRequest {


    private int amount;
    private String description;
    private String authorId;
    private ReimbursementType type;
    private ReimbursementStatus status;

    public ReimbursementCreateRequest() {
        super();
    } //Jackson needs this

    public ReimbursementCreateRequest(int amount, String description, String authorId, ReimbursementType type, ReimbursementStatus status) {
        this.amount = amount;
        this.description = description;
        this.authorId = authorId;    ///need to make this a token
        this.type = type;
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }



    public Reimbursement extractReimbursement() { return new Reimbursement( amount, description, authorId, type, status);}
}


