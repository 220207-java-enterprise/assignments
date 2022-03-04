package com.revature.foundations.dtos.responses;

import java.sql.Timestamp;

public class ReimbursementStatusResponse {

    private String status;
    private Timestamp resolved;
    private String resolverId;
    private String reimbId;

    public ReimbursementStatusResponse(String status, Timestamp resolved, String resolverId, String reimbId) {
        this.status = status;
        this.resolved = resolved;
        this.resolverId = resolverId;
        this.reimbId = reimbId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    public String getReimbId() {
        return reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }
}
