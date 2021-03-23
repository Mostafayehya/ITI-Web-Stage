
import jakarta.servlet.*;
import jakarta.servlet.http.*;


import java.io.*;

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



