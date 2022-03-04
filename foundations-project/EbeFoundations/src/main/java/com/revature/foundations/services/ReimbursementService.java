package com.revature.foundations.services;

import com.revature.foundations.daos.ReimbursementDAO;
import com.revature.foundations.dtos.requests.ReimbursementCreateRequest;
import com.revature.foundations.dtos.requests.ReimbursementResolveRequest;
import com.revature.foundations.dtos.responses.ReimbursementResponse;
import com.revature.foundations.models.Reimbursement;
import com.revature.foundations.models.ReimbursementStatus;
import com.revature.foundations.models.ReimbursementType;
import com.revature.foundations.util.exceptions.AuthenticationException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReimbursementService {

    //a dependency of Reimbursement Service
    private ReimbursementDAO reimbursementDao;

    // Construction injection

    public ReimbursementService(ReimbursementDAO reimbursementDAO){ this.reimbursementDao = reimbursementDAO;};

    public static Reimbursement updateReimbursement(ReimbursementResolveRequest updatedRequest) {

        Reimbursement updatedReimbursement = ReimbursementDAO.getById(updatedRequest.getReimbId());



        updatedReimbursement.setResolverId((updatedReimbursement.getResolverId()));
        if(updatedRequest.getStatus()!=null){
            if(updatedRequest.getStatus().equals("Approved")) updatedReimbursement.setStatus(new ReimbursementStatus("2","Approved"));
            else if (updatedRequest.getStatus().equals("Denied")) updatedReimbursement.setStatus(new ReimbursementStatus("3","Denied"));
        }
        Date date = new Date();
        updatedReimbursement.setResolved((new Timestamp(date.getTime())));
        ReimbursementDAO.Update(updatedReimbursement);
        return updatedReimbursement;
    };

    //For Finance Manager....

    public List<ReimbursementResponse> getAllReimbursements() {
          return ReimbursementDAO.getAll()
               .stream()
               .map(ReimbursementResponse::new) // intermediate operation
               .collect(Collectors.toList()); // terminal operation
    }

     //For Employee..




// Submit Reimbursement...

    public static Reimbursement submitReimbursement(ReimbursementCreateRequest createRequest) throws AuthenticationException {

            Reimbursement newReimbursement = createRequest.extractReimbursement();
        Date date = new Date();
           //Add more reimbursement validation like // if(!isReimbursementValid)
        newReimbursement.setReimbId(UUID.randomUUID().toString());
        newReimbursement.setStatus(new ReimbursementStatus("1","Pending")); //All new requests start as pending

        newReimbursement.setType(new ReimbursementType("4","OTHER"));
        newReimbursement.setSubmitted((new Timestamp(date.getTime())));
        ReimbursementDAO.save(newReimbursement);
        return newReimbursement;


    }


}
