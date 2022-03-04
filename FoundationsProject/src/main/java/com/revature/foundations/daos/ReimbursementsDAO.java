package com.revature.foundations.daos;

import com.revature.foundations.models.Reimbursements;

import com.revature.foundations.models.Users;
import com.revature.foundations.util.ConnectionFactory;
import com.revature.foundations.util.exceptions.ResourcePersistenceException;

import java.sql.*;
import java.util.ArrayList;

public class ReimbursementsDAO implements CrudDAO<Reimbursements> {

    @Override
    public void save(Reimbursements reimbursement) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO reimbursements (reimb_id, amount, submitted, description, author_id, status_id, type_id) VALUES (?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, reimbursement.getReimb_id());
            pstmt.setDouble(2, reimbursement.getAmount());
            pstmt.setTimestamp(3, reimbursement.getSubmitted());
            pstmt.setString(4, reimbursement.getDescription());
            pstmt.setString(5, reimbursement.getAuthor_id());
            pstmt.setString(6, reimbursement.getStatus_id());
            pstmt.setString(7, reimbursement.getType_id());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 1){
                throw new ResourcePersistenceException("Failed to persist reimbursement to data source");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Reimbursements getById(String id) {

        Reimbursements foundReimbursement = null;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM reimbursements WHERE id=?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                foundReimbursement = new Reimbursements();
                foundReimbursement.setReimb_id(rs.getString("reimb_id"));
                foundReimbursement.setAmount(rs.getDouble("amount"));
                foundReimbursement.setSubmitted(String.valueOf(rs.getTimestamp("submitted")));
                foundReimbursement.setDescription(rs.getString("description"));
                foundReimbursement.setAuthor_id(rs.getString("author_id"));
                foundReimbursement.setStatus_id(rs.getString("status_id"));
                foundReimbursement.setType_id(rs.getString("type_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundReimbursement;
    }

    @Override
    public ArrayList<Reimbursements> getAll() {
        ArrayList<Reimbursements> allReimbursements = new ArrayList<>();

        // todo learn how to store many users inside allReimbursements

        return null;
    }


    @Override
    public void update(Reimbursements updatedReimbursement) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE reimbursements SET amount=?, submitted=?, resolved=?, description=?, " +
                            "payment_id=?, author_id=?, resolver_id=?, status_id=?, type_id=? WHERE id=?"
            );

            pstmt.setDouble(1, updatedReimbursement.getAmount());
            pstmt.setTimestamp(2, updatedReimbursement.getSubmitted());
            pstmt.setTimestamp(3, updatedReimbursement.getResolved());
            pstmt.setString(4, updatedReimbursement.getDescription());
            pstmt.setString(5, updatedReimbursement.getPayment_id());
            pstmt.setString(6, updatedReimbursement.getAuthor_id());
            pstmt.setString(7, updatedReimbursement.getResolver_id());
            pstmt.setString(8, updatedReimbursement.getStatus_id());
            pstmt.setString(9, updatedReimbursement.getType_id());
            pstmt.setString(10, updatedReimbursement.getReimb_id());


            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1){
                throw new ResourcePersistenceException("Failed to update user in database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // DELETE
    @Override
    public void deleteById(String id) {
        Users deletedUser = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM reimbursements WHERE id=?");

            pstmt.setString(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted != 1){
                throw new ResourcePersistenceException("Failed to delete reimbursement from database");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

