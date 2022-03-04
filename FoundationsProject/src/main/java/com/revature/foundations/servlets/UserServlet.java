package com.revature.foundations.servlets;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundations.dtos.requests.NewUserRequest;
import com.revature.foundations.dtos.responses.Principal;
import com.revature.foundations.dtos.responses.ResourceCreationResponse;
import com.revature.foundations.dtos.responses.UserResponse;
import com.revature.foundations.models.Users;
import com.revature.foundations.services.TokenService;
import com.revature.foundations.services.UsersService;
import com.revature.foundations.util.exceptions.InvalidRequestException;
import com.revature.foundations.util.exceptions.ResourceConflictException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {

    private final TokenService tokenService;
    private final UsersService userService;
    private final ObjectMapper mapper;

    public UserServlet(TokenService tokenService, UsersService userService, ObjectMapper mapper) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] reqFrags = req.getRequestURI().split("/");
        if (reqFrags.length == 4 && reqFrags[3].equals("availability")) {
            checkAvailability(req, resp);
            return; // necessary, otherwise we end up doing more work than was requested
        }

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(401);
            return;
        }

        Principal requester = tokenService.extractRequesterDetails(req.getHeader("Authorization"));

        if (requester == null) {
            resp.setStatus(401);
            return;
        }
        if (!requester.getRole().equals("Admin")) {
            resp.setStatus(403); // FORBIDDEN
            return;
        }

        List<UserResponse> users = userService.getAllUsers();
        String payload = mapper.writeValueAsString(users);
        resp.setContentType("application/json");
        resp.getWriter().write(payload);

    }

    // registration endpoint
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter respWriter = resp.getWriter();

        try {

            NewUserRequest newUserRequest = mapper.readValue(req.getInputStream(), NewUserRequest.class);
            Users newUser = userService.register(newUserRequest);
            resp.setStatus(201); // CREATED
            resp.setContentType("application/json");
            String payload = mapper.writeValueAsString(new ResourceCreationResponse(newUser.getUser_id()));
            respWriter.write(payload);

        } catch (InvalidRequestException | DatabindException e) {
            resp.setStatus(400); // BAD REQUEST
        } catch (ResourceConflictException e) {
            resp.setStatus(409); // CONFLICT
        } catch (Exception e) {
            resp.setStatus(500);
        }
    }

    protected void checkAvailability(HttpServletRequest req, HttpServletResponse resp) {
        String usernameValue = req.getParameter("username");
        String emailValue = req.getParameter("email");
        if (usernameValue != null) {
            if (userService.isUsernameAvailable(usernameValue)) {
                resp.setStatus(204); // NO CONTENT
            } else {
                resp.setStatus(409);
            }
        } else if (emailValue != null) {
            if (userService.isEmailAvailable(emailValue)) {
                resp.setStatus(204);
            } else {
                resp.setStatus(409);
            }
        }
    }
}
