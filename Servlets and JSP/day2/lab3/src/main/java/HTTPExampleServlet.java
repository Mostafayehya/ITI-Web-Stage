
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;  

public class HTTPExampleServlet extends HttpServlet{

    ServletConfig servletConfig;
    
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML>"); 
            out.println("<BODY>");
            out.println("The servlet has received a GET request." +
            "Now, click on the button below.");
            out.println("<BR>");
            out.println("<FORM METHOD=POST>");
            out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
            out.println("</FORM>");
            out.println("</BODY>"); out.println("</HTML>");



}

public void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
             out.println("<HEAD>");
            out.println("<TITLE>The POST method</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");

   
            out.println("The servlet has received a POST request.Thank you.");

            Enumeration enum1 = request.getHeaderNames();  

            while (enum1.hasMoreElements()) {  
                String headerName = (String) enum1.nextElement();  
                String headerValue = request.getHeader(headerName);  
                out.print("<b>"+headerName + "</b>: ");  
                out.println(headerValue + "<br>");  
              }
            out.println("</BODY>");
            out.println("</HTML>");


}

}
