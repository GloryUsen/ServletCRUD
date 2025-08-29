package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.beans.LibraryOfficerBean;
import com.glory.servletbookapp.dao.LibraryOfficerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlets.AddLibrarian")
public class AddLibrarianOfficer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Add Librarian </title> <");
        out.println("<link rel= 'stylesheet' href= 'bootstrap.min.css' />");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("gloadmin.html").include(request, response);
        out.println("<div class= 'container'>");
        String sid = request.getParameter("id");

        int LibrarianId = Integer.parseInt(sid);
        String LibrarianName = request.getParameter("name");
        String LibrarianEmail = request.getParameter("email");
        String LibrarianPassword = request.getParameter("password");
        String mobileNumber = request.getParameter("mobile");
        long LibrarianMobileNumber = Long.parseLong(mobileNumber);

        LibraryOfficerBean officer = new LibraryOfficerBean(LibrarianId, LibrarianName, LibrarianEmail, LibrarianPassword, LibrarianMobileNumber);

        LibraryOfficerDao.saveProduct(officer);

        out.println("<h4> Librarian added successfully!</h4>");
        request.getRequestDispatcher("addlibrarianform.html").include(request, response);


        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();


    }

}
