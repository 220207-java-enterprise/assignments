package com.revature.foundations.models;

public class ReimbursementStatuses {
    private String status_id;
    private String status;

    public ReimbursementStatuses() {
        super();
    }

    public ReimbursementStatuses(String status) {
        this.status = status;
    }

    public ReimbursementStatuses(String status_id, String status) {
        this.status_id = status_id;
        this.status = status;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ERSReimbursementStatuses{" +
                "status_id='" + status_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
