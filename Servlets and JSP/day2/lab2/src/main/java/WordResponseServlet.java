
import jakarta.servlet.*;
import java.io.*;

public class WordResponseServlet implements Servlet{

    ServletConfig servletConfig;
    
    public void init(ServletConfig config) throws ServletException{

        servletConfig = config;
}
public void service(ServletRequest request, ServletResponse response)  throws ServletException, IOException{

    response.setContentType("application/msword");

    PrintWriter out = response.getWriter();
    out.println("This is the response of wordServlet");
    out.println("Hello, this should be displayed from word ");


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
