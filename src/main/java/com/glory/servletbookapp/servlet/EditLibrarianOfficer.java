package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.beans.LibraryOfficerBean;
import com.glory.servletbookapp.dao.LibraryOfficerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/servlets.EditLibrarian")

public class EditLibrarianOfficer extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String sid = request.getParameter("id");

        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String smobile = request.getParameter("mobile");
        long mobile = Long.parseLong(smobile);

        LibraryOfficerBean product = new LibraryOfficerBean(id, name, email, password, mobile);

        LibraryOfficerDao.updateProduct(product);
        response.sendRedirect("servlets.ViewLibrarian");

    }
}
