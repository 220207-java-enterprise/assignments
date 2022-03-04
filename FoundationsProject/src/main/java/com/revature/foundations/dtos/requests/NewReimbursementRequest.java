package com.revature.foundations.dtos.requests;

public class NewReimbursementRequest {

    public ReimbursementRequest(){super();}

    public ReimbursementRequest(double amount, String description, Bytea receipt, String author_id, String type) {
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.author_id = author_id;
        this.type = type;
    }
}
