package com.revature.foundations.servlets;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.foundations.dtos.requests.NewReimbursementRequest;
import com.revature.foundations.dtos.requests.UpdateReimbursementRequest;
import com.revature.foundations.dtos.responses.Principal;
import com.revature.foundations.dtos.responses.ReimbursementResponse;
import com.revature.foundations.dtos.responses.ResourceCreationResponse;
import com.revature.foundations.models.Reimbursements;
import com.revature.foundations.services.ReimbursementsService;
import com.revature.foundations.services.TokenService;
import com.revature.foundations.services.UsersService;
import com.revature.foundations.util.exceptions.AuthenticationException;
import com.revature.foundations.util.exceptions.InvalidRequestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {

    private final TokenService tokenService;
    private final ReimbursementsService reimbursementService;
    private final ObjectMapper mapper;

    public ReimbursementServlet(TokenService tokenService, ReimbursementsService reimbursementService, ObjectMapper mapper) {
        this.tokenService = tokenService;
        this.reimbursementService = reimbursementService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Principal requester = tokenService.extractRequesterDetails(req.getHeader("Authorization"));

        if (requester == null) {
            resp.setStatus(401);
            return;
        }

        if (!requester.getRole().equals("FINANCE_MANAGER")) {
            resp.setStatus(403); // FORBIDDEN
            return;
        }

        List<Reimbursements> users = reimbursementService.getAllReimbursements();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String payload = mapper.writeValueAsString(users);
        resp.setContentType("application/json");
        resp.getWriter().write(payload);
        resp.setStatus(200);//OK(success)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        try {

            Principal principal = tokenService.extractRequesterDetails(req.getHeader("Authorization"));//authorize requester
            if (!principal.getRole().equals("EMPLOYEE")) {//if requester role not equal to EMPLOYEE
                throw new InvalidRequestException("You are not authorized as an employee. Only employees are able to submit reimbursement requests.");
            }

            NewReimbursementRequest newReimbursementRequest = mapper.readValue(req.getInputStream(), NewReimbursementRequest.class);
            newReimbursementRequest.setAuthor_id(principal.getUser_id());
            // send newReimbReq to reimbService
            ResourceCreationResponse creationResp = reimbursementService.saveNewReimbursement(newReimbursementRequest);
            // get result and write it to the response body as a json string (using the mapper)
            String payload = mapper.writeValueAsString(creationResp);
            resp.setContentType("application/json");
            writer.write(payload);

        } catch (InvalidRequestException | DatabindException e) {
            e.printStackTrace();
            resp.setStatus(400);//BAD request(client side error)
        } catch (AuthenticationException e) {
            resp.setStatus(401); // UNAUTHORIZED (no user found with provided credentials)
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }

    //-----------------------------update a reimbursement(MANAGER ONLY)--------------------------//
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        try {
            Principal principal = tokenService.extractRequesterDetails(req.getHeader("Authorization"));//authorize requester
            if (!principal.getRole().equals("FINANCE_MANAGER")) {//if requester role not equal to FINANCE_MANAGER
                throw new InvalidRequestException("You are not authorized as an manager. Only managers are able to update reimbursement requests.");
            }

            UpdateReimbursementRequest updateReimbursementRequest = mapper.readValue(req.getInputStream(), UpdateReimbursementRequest.class);
            ResourceCreationResponse updatedReimbursement = reimbursementService.updateReimbursement(updateReimbursementRequest);

            String payload = mapper.writeValueAsString(updatedReimbursement);
            resp.setContentType("application/JSON");
            writer.write(payload);

        } catch (InvalidRequestException | DatabindException e) {
            e.printStackTrace();
            resp.setStatus(400);//BAD request(client side error)
        } catch (AuthenticationException e) {
            resp.setStatus(401); // UNAUTHORIZED (no user found with provided credentials)
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}

