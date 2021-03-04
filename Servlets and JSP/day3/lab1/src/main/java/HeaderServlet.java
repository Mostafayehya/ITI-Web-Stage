
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;  

public class HeaderServlet extends HttpServlet{

    ServletConfig servletConfig;

public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<header><h1>This header was added by headerServlet</h1></header>"); 
  

}

}
