
import jakarta.servlet.*;
import java.io.*;

public class ReaderServlet implements Servlet{

    ServletConfig servletConfig;
    
    public void init(ServletConfig config) throws ServletException{

        servletConfig = config;
}
public void service(ServletRequest request, ServletResponse response)  throws ServletException, IOException{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            ServletContext servletContext =servletConfig.getServletContext();

            String initParamter = servletContext.getInitParameter("Country"); 


           String contextAttribute = (String)servletContext.getAttribute("Name");

            out.println("<br>Init parameter Country has value of  " + initParamter);

            out.println("<br>Context parameter Name has value of  " + contextAttribute );



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
