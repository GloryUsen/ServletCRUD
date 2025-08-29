package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.beans.LibraryOfficerBean;
import com.glory.servletbookapp.dao.LibraryOfficerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/servlets.DeleteBook")

public class DeleteLibrarianOfficer extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String string = request.getParameter("id");
        int id = Integer.parseInt(string);
        LibraryOfficerDao.deleteProduct(id);
        response.sendRedirect("servlet.ViewLibrarian");
    }
}
