package com.revature.foundations.services;

import com.revature.foundations.daos.ReimbursementsDAO;

public class ReimbursementsService {

    private ReimbursementsDAO aReimbursementDAO;

    // Constructor injection
    public ReimbursementsService(ReimbursementsDAO reimbursementDAO) {
        this.aReimbursementDAO = reimbursementDAO;
    }


}

