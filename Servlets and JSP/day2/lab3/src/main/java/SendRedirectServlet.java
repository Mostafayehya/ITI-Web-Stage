
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;  

public class SendRedirectServlet extends HttpServlet{

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

              out.println("<BR>Login Failed, please try again.");
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

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
    
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            if(userName.equals("mostafa") && password.equals("123456")) {
            response.sendRedirect("loginSuccess.html");
            }
            else { 
          
              response.sendRedirect("SendRedirectServlet?loginStatus=fail");
            }

}
public void destroy(){

	System.out.println("I am inside the destory method");
}

public String getServletInfo(){
	return null;
}

public ServletConfig getServletConfig(){

	return null; 
}


}
