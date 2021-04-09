
import jakarta.servlet.ServletConfig;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;



public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
// Create path components to save the file

        String path = request.getParameter("destination");
        Part filePart = request.getPart("file");

        
        String fileName = filePart.getSubmittedFileName();
        PrintWriter out = response.getWriter();
        try {
            filePart.write(path + fileName);
            out.println("New file " + fileName + " created at " + path);
        } catch (FileNotFoundException fne) {
            out.println("Error While Uploading Your File");
        }

    }

}