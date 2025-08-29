package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.beans.IssuedProductBean;
import com.glory.servletbookapp.dao.IssuedProductDao;
import com.glory.servletbookapp.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/servlets.ViewIssuedProduct")

public class ViewIssuedProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> View Issued Product </title>");
        out.println("link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("glorylibrarian.html").include(request, response);

        out.println("<div class= 'container'");


        List<IssuedProductBean> listOfProducts = IssuedProductDao.viewIssuedProducts();

        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Callno</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>");
        for (IssuedProductBean number : listOfProducts) {
            out.println("<tr><td>" + number.getBookCode() + "</td><td>" + number.getStudentId() + "</td><td>" + number.getStudentName() + "</td><td>" + number.getStudentMobile() + "</td><td>" + number.getIssuedDate() + "</td><td>" + number.getReturnStatus() + "</td></tr>");
        }

        out.println("</table>");
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();

    }
}

