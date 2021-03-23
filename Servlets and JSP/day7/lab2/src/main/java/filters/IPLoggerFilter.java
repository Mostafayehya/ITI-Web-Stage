package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class IPLoggerFilter implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log("Filter initialized");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterConfig.getServletContext().log("++++++++++++++++++++++++++++++++++++++++++++++++++++\n +" +
                " IP of the host ++++++++++++++++++++++++++" +
                " \n "+ servletRequest.getRemoteAddr());

        
        filterChain.doFilter(servletRequest,servletResponse);


    }

    public void destroy() {

        filterConfig.getServletContext().log("Filter destroyed");
        this.filterConfig = null;

    }
}
