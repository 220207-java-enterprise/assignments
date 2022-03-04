package com.revature.foundations.models;

public class ReimbursementStatus {
    private String statusId;
    private static String status;

    public ReimbursementStatus() {
        super();
    }

    public ReimbursementStatus(String statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }



    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public static String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "reimbursementStatuses{" +
                "status_id='" + statusId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
