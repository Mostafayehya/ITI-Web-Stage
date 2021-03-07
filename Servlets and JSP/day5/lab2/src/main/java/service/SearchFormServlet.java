package service;

import domain.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import javax.naming.*;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SearchFormServlet extends HttpServlet {


    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");

        String userInput = request.getParameter("userInput");

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

            List<User> userlist = new ArrayList<>();

            while (resultSet.next()) {
                userlist.add(new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }

            request.setAttribute("userList", userlist);

            requestDispatcher.forward(request,response);


            preparedStatement.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
