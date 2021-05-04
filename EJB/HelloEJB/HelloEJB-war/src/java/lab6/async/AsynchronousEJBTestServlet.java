/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moust
 */
@WebServlet(name = "AsynchronousEJBTestServlet", urlPatterns = {"/AsynchronousEJBTestServlet"}, asyncSupported = true)
public class AsynchronousEJBTestServlet extends HttpServlet {

    @EJB
    private AsynchronousSessionBean asynchronousSessionBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // Invoking Async tasks
            asynchronousSessionBean.slowMethod();

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsynchronousEJBTestServlet</title>");
            out.println("</head>");
            out.println("<body>");

            response.flushBuffer(); // send back to the browser NOW

            final AsyncContext ctx = request.startAsync(request, response);

            Future<Long> result = asynchronousSessionBean.slowMethodWithReturnValue();

            if (result.isDone()) {

                try {
                    out.println("<h1>Async task result = " + result.get() + "</h1>");
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(AsynchronousEJBTestServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.println("<h1>Servlet AsynchronousEJBTestServlet at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
                response.flushBuffer();
                ctx.complete();

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
