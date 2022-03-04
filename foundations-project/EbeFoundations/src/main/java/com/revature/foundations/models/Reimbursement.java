package com.revature.foundations.models;

import java.sql.Timestamp;
public class Reimbursement {
    private String reimbId;
    private int amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private String receipt;
    private String paymentId;
    private String authorId;
    private String resolverId;
   // private String statusId;
   // private String typeId;
    private ReimbursementType type;
    private ReimbursementStatus status;

    public Reimbursement() {
        super();
    }

    public Reimbursement(String reimbId, int amount, Timestamp submitted, Timestamp resolved, String description, String receipt, String paymentId, String authorId, String resolverId, String statusId, String typeId) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt ;
        this.paymentId = paymentId;
        this.authorId = authorId;
        this.resolverId = resolverId;
        //this.statusId = statusId;
       // this.typeId = typeId;

    }

    //Constructor Overloading for the Reimbursement Request
    public Reimbursement (  int amount, String description, String authorId, ReimbursementType type,ReimbursementStatus status) {
        this.amount = amount;
        this.description = description;
        this.authorId = authorId;
        this.type = type;
        this.status=status;

    }


    public String getReimbId() {
        return reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId='" + reimbId + '\'' +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", receipt=" + receipt +
                ", paymentId='" + paymentId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", resolverId='" + resolverId + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
