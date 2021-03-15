package filters;

import jakarta.servlet.*;

import java.io.IOException;


public class ValidationFilter implements Filter {

    public ValidationFilter() { }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        String erpg = "valError.jsp";

        String userName = request.getParameter("username");
        String email = request.getParameter("email");

        if (userName == null || "".equals(userName)
                || email == null || "".equals(email)) {

            request.setAttribute("errMsg", "One or both fields are empty");

            RequestDispatcher rd = request.getRequestDispatcher(erpg);
            rd.include(request, response);

        } else {

            chain.doFilter(request, response);
        }

    }


}
