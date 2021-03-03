
import jakarta.servlet.*;
import java.io.*;

public class ExcelResponseServlet implements Servlet{

    ServletConfig servletConfig;
    
    public void init(ServletConfig config) throws ServletException{

        servletConfig = config;
}
public void service(ServletRequest request, ServletResponse response)  throws ServletException, IOException{


            response.setContentType("application/vnd.ms-excel");
            PrintWriter out = response.getWriter();
            out.println("\t jan \t feb \t march \t total");
            out.println("salary \t100 \t200 \t300 \t=sum(B2:D2)");

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
