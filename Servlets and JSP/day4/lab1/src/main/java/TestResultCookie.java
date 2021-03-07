import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TestResultCookie extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        boolean isEnabled =false;
        Cookie[] cookies = req.getCookies();
      


        if(cookies != null) {
            isEnabled = true; 
            for (int i=0; i<cookies.length; i++)
            {
                Cookie cookie = cookies[i];

                if(cookie.getValue().equals("test")){
                    out.println("<p style='color:green'>Cookies are enabled<p>");
                    out.println("<p>Cookie name: "+ cookie.getName() +" Cookie value " + cookie.getValue()+"<p>");
                }
            }
        }else{
            isEnabled = false; 
        }

        if (!isEnabled){
            out.println("<p style='color:red'>Cookies are disabled<p>");
        }

    }



    public void doPost(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


    }
}
