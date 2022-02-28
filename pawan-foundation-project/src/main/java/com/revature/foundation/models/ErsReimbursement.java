package com.revature.foundation.models;

import java.util.Objects;
import java.util.UUID;

public class ErsReimbursement {

    String reimbId;               // PK type varchar
    int amount;                 // not null type int (limit 6 digit with 2 decimal points)
    String submitted;           // not null(undeclared) type timestamp
    String resolved;            // not null type timestamp
    String description;         // not null type varchar
    String receipt;             // not null(not declared) type blob
    String paymentId;           // not null(not declared) type varchar
    String authorId;              // FK not null varchar
    String resolverId;            // Fk not null (not declared) varchar
    String statusId;              // FK not null varchar
    String typeId;              // Fk not null varchar


    public ErsReimbursement(){

    }

    public ErsReimbursement(int amount, String sumitted, String resolved,
                            String description, String receipt){
        setAmount(amount);
        setSubmitted(sumitted);
        setResolved(resolved);
        setDescription(description);
        setReceipt(receipt);
    }

    public String getReimbId() {
        return this.reimbId = generateUUIID();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
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
        return this.paymentId = generateUUIID();
    }

    public String getAuthorId() {
        return this.authorId = generateUUIID();
    }

    public String getResolverId() {
        return this.resolverId = generateUUIID();
    }

    public String getStatusId() {
        return statusId = generateUUIID();
    }

    public String getTypeId() {
        return typeId = generateUUIID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsReimbursement erUser = (ErsReimbursement) o;
        return amount == erUser.amount && Objects.equals(reimbId, erUser.reimbId) && Objects.equals(submitted, erUser.submitted) && Objects.equals(resolved, erUser.resolved) && Objects.equals(description, erUser.description) && Objects.equals(receipt, erUser.receipt) && Objects.equals(paymentId, erUser.paymentId) && Objects.equals(authorId, erUser.authorId) && Objects.equals(resolverId, erUser.resolverId) && Objects.equals(statusId, erUser.statusId) && Objects.equals(typeId, erUser.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbId, amount, submitted, resolved, description, receipt, paymentId, authorId, resolverId, statusId, typeId);
    }

    @Override
    public String toString() {
        return "ErUser{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", authorId=" + authorId +
                ", resolverId=" + resolverId +
                ", statusId=" + statusId +
                ", typeId='" + typeId + '\'' +
                '}';
    }

    private String generateUUIID(){
        String uniqueVal = UUID.randomUUID().toString();
        return uniqueVal;
    }
}