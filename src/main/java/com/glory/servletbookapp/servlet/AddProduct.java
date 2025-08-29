package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.beans.ProductBean;
import com.glory.servletbookapp.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlets.DeleteBook")
public class AddProduct extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Add Book Form </title>");
        out.println("<link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");


        request.getRequestDispatcher("glorylibrarian.html").include(request, response);

        out.println("<div class= 'container'>");
        String bookCode = request.getParameter("bookCode");
        String bookName = request.getParameter("bookName");
        String bookAuth = request.getParameter("bookAuthor");
        String bookPublish = request.getParameter("bookPublisher");
        String bookQan = request.getParameter("bookQuantity");
        int bookQuantity = Integer.parseInt(bookQan);

        ProductBean product = new ProductBean(bookCode, bookName, bookAuth, bookPublish, bookQuantity, 2);
        int i = ProductDao.saveProduct(product);
        if (i > 0){
            out.println("<h3> Product Save Successfully </h3>");

        }

        request.getRequestDispatcher("addbookform.html").include(request, response);
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }
}
