package com.revature.foundations.services;

import com.revature.foundations.daos.ReimbursementsDAO;
import com.revature.foundations.dtos.requests.NewReimbursementRequest;
import com.revature.foundations.dtos.requests.UpdateReimbursementRequest;
import com.revature.foundations.dtos.responses.ResourceCreationResponse;
import com.revature.foundations.models.ReimbursementStatuses;
import com.revature.foundations.models.Reimbursements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReimbursementsService {

    private ReimbursementsDAO reimbursementDAO; // a dependency of ReimbursementService

    public ReimbursementsService(ReimbursementsDAO reimbursementDAO) {

        this.reimbursementDAO = reimbursementDAO;
    }

    public ResourceCreationResponse saveNewReimbursement(NewReimbursementRequest newReimbursementRequest) throws IOException {

        Reimbursements newReimbursement = newReimbursementRequest.extractReimbursement();

        // TODO validate that the data provided in the new reimbursement request is valid

        reimbursementDAO.save(newReimbursement);

        return new ResourceCreationResponse(newReimbursement.getReimb_id());
    }

    public ResourceCreationResponse updateReimbursement(UpdateReimbursementRequest updateReimbursementRequest) throws IOException {

        Reimbursements reimbursementToBeUpdated = reimbursementDAO.getById(updateReimbursementRequest.getReimb_id());
        ReimbursementStatuses reimbursementStatus = new ReimbursementStatuses(updateReimbursementRequest.getReimb_id());

        reimbursementToBeUpdated.setStatus_id(String.valueOf(reimbursementStatus));//set reimbursement to new status

        reimbursementDAO.update(reimbursementToBeUpdated);

        return new ResourceCreationResponse(reimbursementToBeUpdated.getReimb_id());
    }

    public List<Reimbursements> getAllReimbursements() {
        return reimbursementDAO.getAll().stream().collect(Collectors.toList());
    }

}

