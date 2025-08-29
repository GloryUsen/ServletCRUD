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
import java.util.List;

@WebServlet("/servlets.ViewProduct")

public class ViewProduct extends HttpServlet{

        protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> View Product </title>");
            out.println("<link rel= 'stylesheet' href= ' boostrap.min.css'/>");
            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("glorylibrarian.html").include(request, response);

            out.println("<div class= ' container'>");
            List<ProductBean> list = ProductDao.viewProduct();

            out.println("<table class= 'table table-bordered table striped'>");
            out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
            for(ProductBean book:list){
                out.println("<tr><td>"+book.getBookCode()+"</td><td>"+book.getBookName()+"</td><td>"+book.getBookAuthor()+"</td><td>"+book.getBookPublisher()+"</td><td>"+book.getBookQuantity()+"</td><td>"+book.getBookIssued()+"</td><td><a href='DeleteProduct?bookCode="+book.getBookCode()+"'>Delete</a></td></tr>");
            }
            out.println("</table>");

            out.println("</div>");


            request.getRequestDispatcher("footer.html").include(request, response);
            out.close();

        }
    }


