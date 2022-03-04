package com.revature.foundations.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundations.daos.UsersDAO;
import com.revature.foundations.services.UsersService;
import com.revature.foundations.services.TokenService;
import com.revature.foundations.servlets.AuthServlet;
import com.revature.foundations.servlets.TestServlet;
import com.revature.foundations.servlets.UserServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    private static Logger logger = LogManager.getLogger(ContextLoaderListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("Initializing Foundations web application");

        ObjectMapper mapper = new ObjectMapper();
        JwtConfig jwtConfig = new JwtConfig();
        TokenService tokenService = new TokenService(jwtConfig);

        TestServlet testServlet = new TestServlet();

        UsersDAO userDAO = new UsersDAO();
        UsersService userService = new UsersService(userDAO);
        UserServlet userServlet = new UserServlet(tokenService, userService, mapper);
        AuthServlet authServlet = new AuthServlet(tokenService, userService, mapper);

//        // TODO implement missing servlets (also, you'll probably need a ReimbursementServlet)
//        // Programmatic Servlet Registration
        ServletContext context = sce.getServletContext();
        context.addServlet("TestServlet", testServlet).addMapping("/test");
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("Shutting down Foundations web application");
    }
}