
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;  

public class MenuPage extends HttpServlet{

    ServletConfig servletConfig;

public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("HeaderServlet");

        //request.include

        requestDispatcher.include(request,response);
  

        out.println("<P>This was added by the menuePageServlet</p>");

        // request include the footer servlet

        requestDispatcher= request.getRequestDispatcher("FooterServlet");

        requestDispatcher.include(request,response);

}

}
