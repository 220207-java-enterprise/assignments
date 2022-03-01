package com.revature.foundations.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectMapper mapper = new ObjectMapper();
    }
}
