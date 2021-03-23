
import jakarta.servlet.*;
import jakarta.servlet.http.*;


import java.io.*;

public class FileDownloadServlet
        extends HttpServlet {

    ServletConfig servletConfig;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/plain");
            response.setHeader("Content-disposition", "attachment; filename=download.txt");

            try(InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/download.txt");
                OutputStream out = response.getOutputStream()) {

                byte[] buffer = new byte[1048];

                int numBytesRead;
                while ((numBytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, numBytesRead);
                }

            } catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }




