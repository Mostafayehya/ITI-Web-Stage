package day1.lab1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BasicServlet extends HttpServlet {

    ServletConfig servletConfig;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("username");

        if (userName.equalsIgnoreCase("mostafa"))
            out.print("<font color =GREEN>Valid user</font>");
        else
            out.print("<font color=RED>Invalid user </font>");

    }

}



