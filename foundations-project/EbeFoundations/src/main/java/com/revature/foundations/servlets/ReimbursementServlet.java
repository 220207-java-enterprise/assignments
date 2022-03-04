package com.revature.foundations.servlets;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundations.dtos.requests.ReimbursementCreateRequest;
import com.revature.foundations.dtos.responses.Principal;
import com.revature.foundations.dtos.responses.ReimbursementResponse;
import com.revature.foundations.dtos.responses.ResourceCreationResponse;
import com.revature.foundations.models.Reimbursement;
import com.revature.foundations.services.ReimbursementService;
import com.revature.foundations.services.TokenService;
import com.revature.foundations.util.exceptions.InvalidRequestException;
import com.revature.foundations.util.exceptions.ResourceConflictException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {

    private final TokenService tokenService;
    private final ReimbursementService reimbursementService;
    private final ObjectMapper mapper;

    public ReimbursementServlet(TokenService tokenService, ReimbursementService reimbursementService, ObjectMapper mapper) {
        this.tokenService = tokenService;
        this.reimbursementService = reimbursementService;
        this.mapper = mapper;

    }


    //Get all reimbursements
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Principal requester = tokenService.extractRequesterDetails(req.getHeader("Authorization"));

        if (requester == null) {
            resp.setStatus(401);
            return;
        }

       if (requester.getRole().equals("Employee")){
           resp.setStatus(403);
           return;
       }





        List<ReimbursementResponse> reimbursements = reimbursementService.getAllReimbursements();
        String payload = mapper.writeValueAsString(reimbursements);
        resp.setContentType("application/json");
        resp.getWriter().write(payload);

    }

    //create reimbursements
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("Authorization");
        Principal requester = tokenService.extractRequesterDetails(token);
        PrintWriter respWriter = resp.getWriter();

        if (requester == null) {
            resp.setStatus(401);
            return;
        }

        if (!requester.getRole().equals("Employee")){
            resp.setStatus(403);
            return;

        }

        //if (!requester.getRole().equals("Employee")) {
        //    resp.setStatus(403); //Forbidden
        //    return;
        //}

        if (requester.getRole().equals("Employee")) {


            try {


                ReimbursementCreateRequest newReimbursementRequest = mapper.readValue(req.getInputStream(), ReimbursementCreateRequest.class);
                newReimbursementRequest.setAuthorId(requester.getId());
                Reimbursement newReimbursement = ReimbursementService.submitReimbursement(newReimbursementRequest);
                resp.setStatus(201); // CREATED
                resp.setContentType("application/json");
                String payload = mapper.writeValueAsString(new ResourceCreationResponse(newReimbursement.getReimbId()));
                respWriter.write(payload);

            } catch (InvalidRequestException | DatabindException e) {
                resp.setStatus(400);
                e.printStackTrace();// BAD REQUEST
            } catch (ResourceConflictException e) {
                resp.setStatus(409); // CONFLICT
            } catch (Exception e) {
                e.printStackTrace(); // include for debugging purposes; ideally log it to a file
                resp.setStatus(500);
            }


        }
    }

    ;
}
