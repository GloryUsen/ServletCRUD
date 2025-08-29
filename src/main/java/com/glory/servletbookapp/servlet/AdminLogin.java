package com.glory.servletbookapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlets.DeleteBook")
public class AdminLogin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter print = response.getWriter();

        print.println("<!DOCTYPE html>");
        print.println("<html>");
        print.println("<head>");
        print.println("<title> Admin Section</title>");
        print.println("link ref= 'stylesheet' href= 'boostrap.min.css'/>");
        print.println("</head>");
        print.println("<body>");


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String e1 = "admin@glo.com";
        String p1 = "admin123";

        if (email.equalsIgnoreCase(e1) && password.equalsIgnoreCase(p1)){
            HttpSession session = request.getSession();
            session.setAttribute("admin", "true");

            request.getRequestDispatcher("gloryadmin.html").include(request, response);
            request.getRequestDispatcher("admincarousel.html").include(request, response);

        } else {
            request.getRequestDispatcher("glohome.html").include(request, response);
            print.println("<div class= 'container'>");
            print.println("<h3> Username or password error</h3>");
            request.getRequestDispatcher("adminloginform.html").include(request, response);
            print.println("</div>");
        }

        request.getRequestDispatcher("footer.html").include(request, response);
        print.close();
    }
}
