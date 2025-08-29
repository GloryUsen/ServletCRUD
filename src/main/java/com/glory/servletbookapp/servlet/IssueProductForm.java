package com.glory.servletbookapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlets.IssueProductForm")

public class IssueProductForm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Issue Product Form </title>");
        out.println("<link rel= ' stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("glorylibrarian.html").include(request, response);
        out.println("<div class= 'container'");
        request.getRequestDispatcher("issuebookform").include(request, response);
        out.println("</div");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();



    }

}
