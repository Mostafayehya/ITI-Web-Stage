
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import java.sql.ResultSet;

import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet {

    ServletConfig servletConfig;

    public void init(ServletConfig config) throws ServletException {

        servletConfig = config;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WelcomePageServlet");


        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("loggedIn").equals("true")) {
            response.sendRedirect("WelcomePageServlet");
        }

        String loginStatus = request.getParameter("loginStatus");

        out.println("<FORM method= POST>");
        out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
        out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
        out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");

        if (loginStatus != null && loginStatus.equals("fail")) {
            out.println("<p style='color:red'>Login Failed, please try again<p>");
        }


    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WelcomePageServlet");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        // I should connect here to DB and check against the data

        String resultUserName = "";
        String resultPassword = "";
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
            Connection conn = ds.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("select * from my_users where user_name = ? and password = ?");

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultUserName = resultSet.getString(4);
                resultPassword = resultSet.getString(5);

                preparedStatement.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }


        if (userName.equals(resultUserName) && password.equals(resultPassword) &&
                !resultUserName.isEmpty() && !resultPassword.isEmpty()) {

            // requestDispatcher.forward(request, response);


            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", new String("true"));
            session.setAttribute("userName", resultUserName);
            session.setAttribute("password", resultPassword);
            response.sendRedirect("WelcomePageServlet");
        } else {
            response.sendRedirect("LoginServlet?loginStatus=fail");
        }

    }


}
