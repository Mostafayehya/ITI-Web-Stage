
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;  

public class LoginServlet extends HttpServlet{

    ServletConfig servletConfig;
    
    public void init(ServletConfig config) throws ServletException{

        servletConfig = config;
}

public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException
{
  response.setContentType("text/html");

  PrintWriter out = response.getWriter();
  String loginStatus = request.getParameter("loginStatus");

     if(loginStatus !=null &&loginStatus.equals("fail")){

              out.println("<FORM method= POST>");
              out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
              out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
              out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
              out.println("</FORM>");
              out.println("<p style='color:red'>Login Failed, please tryagain<p>");
     }else{

          out.println("<FORM method= POST>");
          out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
          out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
          out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
          out.println("</FORM>");
     }

}

public void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException{


       RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayParametersServlet");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
    
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            if(userName.equals("mostafa") && password.equals("123456")) {
          
              response.getWriter().println("<p>Hello from login Servlet</p>");
              requestDispatcher.forward(request,response);
            
            }
            else { 
              response.sendRedirect("LoginServlet?loginStatus=fail");
            }

}


}
