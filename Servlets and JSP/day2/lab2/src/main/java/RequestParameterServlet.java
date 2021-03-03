
import jakarta.servlet.*;
import java.io.*;

public class RequestParameterServlet implements Servlet{

    ServletConfig servletConfig;
    
    public void init(ServletConfig config) throws ServletException{

        servletConfig = config;
}
public void service(ServletRequest request, ServletResponse response)  throws ServletException, IOException{

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    ServletContext servletContext =servletConfig.getServletContext();

    String str = request.getParameter("MyName");
    out.println("The user input is: " + str);


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
