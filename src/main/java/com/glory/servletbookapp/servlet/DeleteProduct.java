package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.dao.ProductDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlets.DeleteBook")
public class DeleteProduct extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        ProductDao.delete(request.getParameter("bookCode"));
        response.sendRedirect("servlet.ViewProduct");
    }
}
