import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchFormServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        displaySearchInstructions(out);


    }

    private void displaySearchInstructions(PrintWriter out) {
        out.println("<div style='width:40%; margin:30px auto;'>");
        out.println("<FORM  method= POST>");
        out.println("<h1 style='font-size:300%; font-weight: bold;'>Search form</h1>");
        out.println("<p>Please enter first name, last name or part of any</p>");


        out.println("<BR><span style='font-size:200%; font-weight: bold;'> Name: </span><INPUT TYPE=TEXT NAME=userInput>");

        out.println("<INPUT TYPE=SUBMIT VALUE=Submit>");
        out.println("</FORM>");
        out.println("</div>");
        out.println("<BR><BR><BR><BR>");
    }


    public void doPost(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        displaySearchInstructions(out);

        String userInput = req.getParameter("userInput");

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
            Connection conn = ds.getConnection();

            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "select first_name,last_name,user_name,password from my_users where first_name LIKE ? OR last_name LIKE ?"
                    );

            preparedStatement.setString(1, "%" + userInput + "%");
            preparedStatement.setString(2, "%" + userInput + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            out.println("<table style='width:60%; margin:30px auto;'>");
            // HEADERS
            out.println("<tr style='font-size:200%; font-weight: bold;'>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("<th>User Name</th>");
            out.println("<th>Password</th>");
            out.println("</tr>");

            //DATA
            while(resultSet.next()){
               String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                String userName = resultSet.getString(3);
                String password = resultSet.getString(4);

                out.println("<tr>");
                out.println("<td style='text-align:center'>"+firstName+"</td>");
                out.println("<td style='text-align:center'>"+lastName+"</td>");
                out.println("<td style='text-align:center'>"+userName+"</td>");
                out.println("<td style='text-align:center'>"+password+"</td>");
                out.println("</tr>");

            }

            out.println("</table>");

            preparedStatement.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }





    }
}
