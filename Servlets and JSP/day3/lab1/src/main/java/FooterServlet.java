
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;  

public class FooterServlet extends HttpServlet{

    ServletConfig servletConfig;

public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<footer><h3>This Footer was added by FooterServlet</h3></footer>"); 

}

}
