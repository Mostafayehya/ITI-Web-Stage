
import jakarta.servlet.*;
import jakarta.servlet.http.*;


import java.io.*;

public class BasicServlet extends HttpServlet {

    ServletConfig servletConfig;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>IP filter should work now, please check logs</h1>");
    }

}



