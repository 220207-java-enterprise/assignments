package com.revature.foundations.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundations.daos.ReimbursementDAO;
import com.revature.foundations.daos.UserDAO;
import com.revature.foundations.services.ReimbursementService;
import com.revature.foundations.services.TokenService;
import com.revature.foundations.services.UserService;
import com.revature.foundations.servlets.AuthServlet;
import com.revature.foundations.servlets.ReimbursementServlet;
import com.revature.foundations.servlets.ReimbursementStatusServlet;
import com.revature.foundations.servlets.UserServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing ERS_Reimbursements Application");

        ObjectMapper mapper = new ObjectMapper();
        JwtConfig jwtConfig = new JwtConfig();
        TokenService tokenService = new TokenService(jwtConfig);

        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        UserServlet userServlet = new UserServlet(tokenService, userService, mapper);
        AuthServlet authServlet = new AuthServlet(tokenService, userService, mapper);


       ReimbursementDAO reimbDAO = new ReimbursementDAO();
       ReimbursementService reimbService = new ReimbursementService(reimbDAO);

       ReimbursementServlet reimbServlet = new ReimbursementServlet(tokenService, reimbService, mapper);

       ReimbursementStatusServlet resolveServlet = new ReimbursementStatusServlet(tokenService,reimbService,mapper);



        // Programmatic Servlet Registration
        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");


        context.addServlet("ReimbursementServlet", reimbServlet).addMapping("/reimbursement");
        context.addServlet("ReimbursementStatusServlet",resolveServlet).addMapping("/reimbursement/resolve");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down Foundations web application");
    }

}
