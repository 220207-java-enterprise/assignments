package com.revature.foundations.dtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReimbursementResolveRequest {

    private String reimbId;
    private Timestamp resolved;
    private String resolverId;
    private String status;


    public ReimbursementResolveRequest()
    {
        super();
    }

    public String getReimbId() {
        return reimbId;
    }


    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
