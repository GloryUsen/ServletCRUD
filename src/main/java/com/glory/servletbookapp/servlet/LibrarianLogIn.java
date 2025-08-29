package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.dao.LibraryOfficerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlets.LibrarianLogin")

public class LibrarianLogIn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Librarian Section </title>");
        out.println("<link rel= 'stylesheet' href= ' boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (LibraryOfficerDao.authentication(email, password)){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            request.getRequestDispatcher("glolibrarian.html").include(request, response);
            request.getRequestDispatcher("librariancarousel.html").include(request, response);

        } else {
            request.getRequestDispatcher("gloryhome.html").include(request, response);
            out.println("<div class= 'container'");
            out.println("<h3>username or password error</h3>");
            request.getRequestDispatcher("librarianloginform.html").include(request, response);
            out.println("</div>");
        }

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }


}
