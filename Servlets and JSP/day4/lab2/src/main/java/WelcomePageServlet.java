
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;

public class WelcomePageServlet extends HttpServlet {

    ServletConfig servletConfig;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null)
            response.sendRedirect("LoginServlet");
        else
        {
            String loggedIn = (String) session.getAttribute("loggedIn");
            if (!loggedIn.equals("true"))
                response.sendRedirect ("LoginServlet");
            else{
                String userName = (String) session.getAttribute("userName");
                String password = (String) session.getAttribute("password");
                out.println("<h1 style='font-size:300%; font-weight: bold;'>Welcome page</h1>");
                out.println("<p>UserName : " + userName + "</p>");
                out.println("<p>Password : " + password + "</p>");
            }
        }

    }


}
