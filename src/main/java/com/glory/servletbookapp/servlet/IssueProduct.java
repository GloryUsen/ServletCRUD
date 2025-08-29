package com.glory.servletbookapp.servlet;

import com.glory.servletbookapp.beans.IssuedProductBean;
import com.glory.servletbookapp.dao.IssuedProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/servlets.IssueProduct")

public class IssueProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE.html>");
        out.println("html");
        out.println("<head>");
        out.println("<title> Add Book Form </title>");
        out.println("<link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("</body>");
        request.getRequestDispatcher("glolibrarian.html").include(request, response);

        out.println("<div class= 'container'>");
        String bookCode = request.getParameter("bookCode");
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String studentMobile = request.getParameter("studentMobile");
        long preStudentMobile = Long.parseLong(studentMobile);

        IssuedProductBean newProduct = new IssuedProductBean(bookCode, studentId, studentName, preStudentMobile);



        int i = IssuedProductDao.issuedProduct(newProduct);
        if (i > 0) {
            out.println("<h3>Book issued successfully</h3>");

        } else {
            out.println("<h3> Sorry, unable to issue book.</h3><p>We may have shortage of books. Kindly visit later.</p>");

        }
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();


    }
}
