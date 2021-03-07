import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import javax.naming.*;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;

public class SQLToolServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        displaySearchInstructions(out);


    }

    private void displaySearchInstructions(PrintWriter out) {
        out.println("<div style='width:40%; margin:30px auto;'>");
        out.println("<FORM  method= POST>");
        out.println("<h1 style='font-size:300%; font-weight: bold;'>SQL Tool</h1>");
        out.println("<p>Please Type your SQL statement in the following box</p>");


        out.println("<BR><INPUT style='height: 100px; width:90%' TYPE=TEXT NAME=userInput>");

        out.println("<INPUT TYPE=SUBMIT VALUE=Execute>");
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

        out.println("<div style='width:80%; margin:20px auto;'>");

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
            Connection conn = ds.getConnection();
            ResultSet rs;
            int updateCount;

            PreparedStatement preparedStatement = conn.prepareStatement(userInput);

            String verb = userInput.split(" ")[0].toLowerCase();

            if (verb.equals("select")){
                rs = preparedStatement.executeQuery();
                ResultSetMetaData rsMeta = rs.getMetaData();
                out.println("<table style='width:80%; margin:20px auto;'>");
                out.println("<tr style='font-size:200%; font-weight: bold;'>");

                for (int i =1; i<=rsMeta.getColumnCount();i++)
                    out.println("<th>"+rsMeta.getColumnName(i)+"</th>");

                out.println("</tr>");

                while(rs.next()){

                    out.println("<tr>");
                    for (int i =1; i<=rsMeta.getColumnCount();i++){
                        out.println("<td style='text-align:center'>"+rs.getString(i)+"</td>");
                    }
                    out.println("</tr>");

                }

                out.println("</table>");

            }else{
                updateCount = preparedStatement.executeUpdate();
                switch(verb){
                    case "delete":
                        out.println("<p style='color:green'>"+updateCount+" rows deleted!!<p>");
                        break;
                    case "update":
                        out.println("<p style='color:green'>"+updateCount+" rows updated!!<p>");
                        break;
                    case "insert":
                        out.println("<p style='color:green'>"+updateCount+" rows created!!<p>");
                        break;

                    default:
                        out.println("<p style='color:red'>Unsupported operation<p>");

                }

                out.println("</div>");

            }

            preparedStatement.close();
            conn.close();


        } catch (SQLException e) {
            out.println("<div style='width:60%; margin:30px auto;'> <h4 style='color:red'>Invalid query</h4></div>");
            out.println("</div>");

            e.printStackTrace();

        } catch (NamingException e) {
            e.printStackTrace();
        }





    }
}
