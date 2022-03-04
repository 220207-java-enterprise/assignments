package com.revature.foundations.dtos.responses;

import com.revature.foundations.models.Reimbursement;
import com.revature.foundations.models.ReimbursementStatus;
import com.revature.foundations.models.ReimbursementType;

public class ReimbursementResponse {

    private String ReimbursementID;
    private String AuthorID;
    private String Description;
    private ReimbursementStatus status;
    private ReimbursementType type;


    public ReimbursementResponse() {
        super();
    }

    public ReimbursementResponse(Reimbursement reimbursement) {
        this.ReimbursementID = reimbursement.getReimbId();
        this.AuthorID = reimbursement.getAuthorId();
        this.Description = reimbursement.getDescription();
        this.status = reimbursement.getStatus();
        this.type = reimbursement.getType();
    }

    public String getReimbursementID() {
        return ReimbursementID;
    }

    public void setReimbursementID(String reimbursementID) {
        ReimbursementID = reimbursementID;
    }

    public String getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(String authorID) {
        AuthorID = authorID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }
}
