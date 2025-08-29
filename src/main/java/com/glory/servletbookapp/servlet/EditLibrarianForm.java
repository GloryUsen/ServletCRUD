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

@WebServlet("/servlets.EditLibrarianForm")
public class EditLibrarianForm extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("text/html");
        PrintWriter out = response.getWriter();

        out.println("!DOCTYPE html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Edit Librarian Form </title>");
        out.println("<link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("gloryadmin.html").include(request, response);
        out.println("<div class= 'container'>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        LibraryOfficerBean newBean = LibraryOfficerDao.viewProductById(id);


        out.print("<form action='servlets.EditLibrarian' method='post' style='width:300px'>");
        out.print("<div class='form-group'>");
        out.print("<input type='hidden' name='id' value='" + newBean.getLibrarianId() + "'/>");
        out.print("<label for='name1'>Name</label>");
        out.print("<input type='text' class='form-control' value='" + newBean.getLibrarianName() + "' name='name' id='name1' placeholder='Name'/>");
        out.print("</div>");
        out.print("<div class='form-group'>");
        out.print("<label for='email1'>Email address</label>");
        out.print("<input type='email' class='form-control' value='" + newBean.getLibrarianEmail() + "'  name='email' id='email1' placeholder='Email'/>");
        out.print("</div>");
        out.print("<div class='form-group'>");
        out.print("<label for='password1'>Password</label>");
        out.print("<input type='password' class='form-control' value='" + newBean.getLibrarianPassword() + "'  name='password' id='password1' placeholder='Password'/>");
        out.print("</div>  ");
        out.print("<div class='form-group'>");
        out.print("<label for='mobile1'>Mobile Number</label>");
        out.print("<input type='number' class='form-control' value='" + newBean.getLibrarianMobileNumber() + "'name='mobile' id='mobile1' placeholder='Mobile'/>");
        out.print("</div>");
        out.print("<button type='submit' class='btn btn-primary'>Update</button>");
        out.print("</form>");

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();

    }
}
