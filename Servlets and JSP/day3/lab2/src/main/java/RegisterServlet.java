
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

public class RegisterServlet extends HttpServlet {

    ServletConfig servletConfig;

    public void init(ServletConfig config) throws ServletException {

        servletConfig = config;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String registerStatus = request.getParameter("registerStatus");
        out.println("<div style='width:40%; margin:30px auto;'>");
        out.println("<FORM style='margin: 0 auto;' method= POST>");
        out.println("<h1 style='font-size:300%; font-weight: bold;'>Registration Form</h1>");
        out.println("<h2>Please Enter the user details</h2>");

        out.println("<BR> FirstName: <INPUT TYPE=TEXT NAME=firstName>");
        out.println("<BR><BR> LastName: <INPUT TYPE=TEXT NAME=lastName>");
        out.println("<BR><BR> UserName: <INPUT TYPE=TEXT NAME=userName>");
        out.println("<BR><BR> Password: <INPUT TYPE=PASSWORD NAME=password>");

        out.println("<BR><BR> <INPUT TYPE=RESET VALUE=Reset>");
        out.println("<INPUT TYPE=SUBMIT VALUE=Submit button>");
        out.println("</FORM>");
        out.println("</div>");



        if (registerStatus != null && registerStatus.equals("fail")) {
            out.println("<p style='color:red'>Register Failed, please try again<p>");
        }

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginServlet");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        int rowsEffected = 0;

        if (firstName== null || firstName.isEmpty() ||lastName== null || lastName.isEmpty() ||
                password== null || password.isEmpty() ||userName== null || userName.isEmpty()) {
            response.sendRedirect("RegisterServlet?registerStatus=fail");
            return;
        }

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
            Connection conn = ds.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("insert into my_users(first_name,last_name,user_name,password)  values(?,?,?,?)");

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);

            rowsEffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }


        if (rowsEffected == 0 || firstName== null || firstName.isEmpty() ||lastName== null || lastName.isEmpty() ||
        password== null || password.isEmpty() ||userName== null || userName.isEmpty()) {
            response.sendRedirect("RegisterServlet?registerStatus=fail");
        } else {
            response.sendRedirect("LoginServlet?registerStatus=success");
        }

    }

}
