import jakarta.servlet.*;
import jakarta.servlet.http.*;


import java.io.IOException;

public class Greeting extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = "/hello.jsp";
        RequestDispatcher disp = getServletContext().getRequestDispatcher(page);
        disp.forward(request, response);
    }
}