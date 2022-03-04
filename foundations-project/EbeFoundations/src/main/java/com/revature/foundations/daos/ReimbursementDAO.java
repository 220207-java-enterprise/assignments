package com.revature.foundations.daos;

import com.revature.foundations.models.Reimbursement;
import com.revature.foundations.models.ReimbursementStatus;
import com.revature.foundations.models.ReimbursementType;
import com.revature.foundations.util.ConnectionFactory;
import com.revature.foundations.util.exceptions.DataSourceException;
import com.revature.foundations.util.exceptions.ResourcePersistenceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO {

    private static final String rootSelect = "SELECT " +

            "ers_r.reimb_id, " +
            "ers_r.amount," +
            " ers_r.submitted, " +
            "ers_r.resolved, " +
            "ers_r.description, " +
            "ers_r.receipt," +
            " ers_r.payment_id," +
            " ers_r.author_id, " +
            "ers_r.resolver_id, " +
            "ers_s.status_id ," +
            " ers_s.status " +
            "FROM ers_reimbursements ers_r " +
                    "JOIN ers_reimbursement_statuses ers_s " +
                    "ON ers_r.status_id = ers_s.status_id" +
            "JOIN ers_reimbursement_types ers_t " +
            "ON ers_r.type_id = ers_t.type_id"
            ;



        //get all reimbursements


        public static List<Reimbursement> getAll() {

            List<Reimbursement> reimbursements = new ArrayList<>();

            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

                ResultSet rs = conn.createStatement().executeQuery(rootSelect);
                while (rs.next()) {
                    Reimbursement reimbursement = new Reimbursement();
                    reimbursement.setReimbId(rs.getString("reimb_id"));
                    reimbursement.setAmount(rs.getInt("amount"));
                    reimbursement.setSubmitted(rs.getTimestamp("submitted"));
                    reimbursement.setSubmitted(rs.getTimestamp("resolved"));
                    reimbursement.setDescription(rs.getString("description"));
                    reimbursement.setReceipt(rs.getString("receipt"));
                    reimbursement.setPaymentId(rs.getString("payment_id"));
                    reimbursement.setAuthorId(rs.getString("author_id"));
                    reimbursement.setResolverId(rs.getString("resolver_id"));
                    reimbursement.setStatus(new ReimbursementStatus("status_id","status"));
                    reimbursement.setType(new ReimbursementType("type_id","type"));
                    reimbursements.add(reimbursement);
                }
            } catch (SQLException e) {
                throw new DataSourceException(e);
            }

            return reimbursements;
        }


  // Save Reimbursements - this could be initial creation or update and save.

    public static void save(Reimbursement newReimbursement) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ers_reimbursements VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, newReimbursement.getReimbId());
            pstmt.setInt(2, newReimbursement.getAmount());
            pstmt.setTimestamp(3, newReimbursement.getSubmitted());
            pstmt.setTimestamp(4, newReimbursement.getResolved());
            pstmt.setString(5, newReimbursement.getDescription());
            pstmt.setString(6, newReimbursement.getReceipt());
            pstmt.setString(7,newReimbursement.getPaymentId());
            pstmt.setString(8,newReimbursement.getAuthorId());
            pstmt.setString(9,newReimbursement.getResolverId());
            pstmt.setString(10,newReimbursement.getStatus().getStatusId());
            pstmt.setString(11, newReimbursement.getType().getTypeId());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to persist Reimbursement to ERS");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }


    //Update Reimbursements - Status

    public static void Update(Reimbursement updateReimbursement) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE ers_reimbursements " +
                    "SET resolved = ?, " +
                    //"payment_id = ? " +
                    "resolver_id = ?, " +
                    "status_id = ? " +
                    "WHERE reimb_id = ? ");

            pstmt.setTimestamp(1, updateReimbursement.getResolved());
         //  pstmt.setString(7, updateReimbursement.getPaymentId());
            pstmt.setString(2, updateReimbursement.getResolverId());
            pstmt.setString(3, updateReimbursement.getStatus().getStatusId());

            // TODO allow role to be updated as well

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                throw new ResourcePersistenceException("Failed to update Reimbursement.");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }


// get reimbursement by ID -- an Employee can view their reimbursement request history

    public static Reimbursement getById(String id) {

        Reimbursement reimbursement = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE reimb_id = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                reimbursement = new Reimbursement();
                reimbursement.setReimbId(rs.getString("reimb_id"));
                reimbursement.setAmount(rs.getInt("amount"));
                reimbursement.setSubmitted(rs.getTimestamp("submitted"));
                reimbursement.setResolved(rs.getTimestamp("resolved"));
                reimbursement.setDescription(rs.getString("description"));
                reimbursement.setReceipt(rs.getString("receipt"));
                reimbursement.setPaymentId(rs.getString("payment_id"));
                reimbursement.setAuthorId(rs.getString("author_id"));
                reimbursement.setResolverId(rs.getString("resolver_id"));
                reimbursement.setStatus(new ReimbursementStatus("status_id","status"));
                reimbursement.setType(new ReimbursementType("type_id","type"));

            }



        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return reimbursement;

    }

    public void save(Object newObj) {

    }



    public void deleteById(String id) {

    }
}
