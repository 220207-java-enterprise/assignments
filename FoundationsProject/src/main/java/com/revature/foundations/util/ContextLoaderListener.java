package com.revature.foundations.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundations.daos.ReimbursementsDAO;
import com.revature.foundations.daos.UsersDAO;
import com.revature.foundations.services.ReimbursementsService;
import com.revature.foundations.services.UsersService;
import com.revature.foundations.services.TokenService;
import com.revature.foundations.servlets.AuthServlet;
import com.revature.foundations.servlets.ReimbursementServlet;
import com.revature.foundations.servlets.TestServlet;
import com.revature.foundations.servlets.UserServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ObjectMapper mapper = new ObjectMapper();
        JwtConfig jwtConfig = new JwtConfig();
        TokenService tokenService = new TokenService(jwtConfig);

        TestServlet testServlet = new TestServlet();

        UsersDAO userDAO = new UsersDAO();
        UsersService userService = new UsersService(userDAO);

        ReimbursementsDAO reimbDAO = new ReimbursementsDAO();
        ReimbursementsService reimbService = new ReimbursementsService(reimbDAO);

        UserServlet userServlet = new UserServlet(tokenService, userService, mapper);
        AuthServlet authServlet = new AuthServlet(tokenService, userService, mapper);
        ReimbursementServlet reimbursementServlet = new ReimbursementServlet(tokenService, reimbService, mapper);

//        // TODO implement missing servlets (also, you'll probably need a ReimbursementServlet)
//        // Programmatic Servlet Registration
        ServletContext context = sce.getServletContext();
        context.addServlet("TestServlet", testServlet).addMapping("/test");
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("ReimbursementServlet", reimbursementServlet).addMapping("/reimbursements/*");

    }

}