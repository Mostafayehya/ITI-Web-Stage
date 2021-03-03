
import jakarta.servlet.*;
import java.io.*;

public class MyFirstServlet implements Servlet{

    ServletConfig servletConfig;
    
    public void init(ServletConfig config) throws ServletException{

        servletConfig = config;
}
public void service(ServletRequest request, ServletResponse response)  throws ServletException, IOException{
            response.setContentType("text/html");

            String dbAddress = servletConfig.getInitParameter("DatabaseAddress");

            String userName = servletConfig.getInitParameter("userName");

            String password = servletConfig.getInitParameter("password");

            PrintWriter out = response.getWriter();
            out.println("<br> DatabaseAddress : " + dbAddress);

            
            out.println("<br> UserName : " + userName);

            
            out.println("<br> password : " + password);

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
