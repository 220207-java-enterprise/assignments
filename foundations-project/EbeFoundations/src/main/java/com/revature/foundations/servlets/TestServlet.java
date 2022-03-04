package com.revature.foundations.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>\n" +
                "<HEAD><TITLE>Hello Ebe final</TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<H1>Chronic Fist Fue:)</H1>\n" +
                "</BODY></HTML>"
        );
        // resp.getWriter().write("<h1>Sunday Plan: Servlet and JWT integration</h1>");
    }

}