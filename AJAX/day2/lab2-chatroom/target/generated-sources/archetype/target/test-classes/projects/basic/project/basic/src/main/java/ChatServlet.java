import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ChatServlet extends HttpServlet {
    public static final List<MessageDto> messsageList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String message = request.getParameter("message");
        messsageList.add(new MessageDto(name, message));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print(buildGsonFromArray(messsageList));

    }

    public String buildGsonFromArray(List<MessageDto> messageList) {
        Gson gson = new Gson();
        return gson.toJson(messageList);
    }


}
