package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.dao.IssuedProductDao;
import com.glory.servletbookapp.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlets.ReturnProduct")
public class ReturnProduct extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.sendRedirect("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Return Product </title>");
        out.println("<link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("glorylibrarian.html").include(request, response);

        out.println("<div class=' container'>");
        String bookCode = request.getParameter("bookCode");
        String studentId= request.getParameter("studentId");
        int studentId1 = Integer.parseInt(studentId);


        int i = IssuedProductDao.returnedProduct(bookCode, studentId1);
        if (i > 0){
            out.println("<h3> Product returned successfully </h3>");

        } else {
            out.println("<h3> Sorry, unable to return product </h3><p> We may have shortage of products. Kindly visit later.</p>");
        }
        out.println("</div>");


        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }
}
