
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;  

public class DisplayParametersServlet extends HttpServlet{

    ServletConfig servletConfig;

public void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        out.println("<p>UserName : " + userName + "</p>");
        out.println("<p>Password : " + password + "</p>");  
  

}

}
