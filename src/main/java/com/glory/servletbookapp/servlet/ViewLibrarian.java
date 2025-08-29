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
import java.util.List;


@WebServlet("/servlets.ViewLibrarian")
public class ViewLibrarian extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> View Librarian </title>");
        out.println("<link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("gloryadmin.html").include(request, response);
        out.println("<div class= 'container'");


        List<LibraryOfficerBean> lists = LibraryOfficerDao.viewLibrarian();


        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
        for(LibraryOfficerBean bean:lists){
            out.println("<tr><td>"+bean.getLibrarianId()+"</td><td>"+bean.getLibrarianName()+"</td><td>"+bean.getLibrarianEmail()+"</td><td>"+bean.getLibrarianPassword()+"</td><td>"+bean.getLibrarianMobileNumber()+"</td><td><a href='servlets.EditLibrarianForm?id="+bean.getLibrarianId()+"'>Edit</a></td><td><a href='servlets.DeleteLibrarian?id="+bean.getLibrarianId()+"'>Delete</a></td></tr>");
        }

        out.println("</table>");
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();

    }
}
