
import jakarta.servlet.*;
import java.io.*;

public class WriterServlet implements Servlet{

    ServletConfig servletConfig;
    
    public void init(ServletConfig config) throws ServletException{

        servletConfig = config;
}
public void service(ServletRequest request, ServletResponse response)  throws ServletException, IOException{
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            ServletContext servletContext =servletConfig.getServletContext();

            String initParamter = servletContext.getInitParameter("Country"); 

            out.println("<br>Init parameter Country has value of  " + initParamter);

            servletContext.setAttribute("Name" , "Mostafa Writer Servlet");





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
