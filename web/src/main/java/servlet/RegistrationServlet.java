package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/registration.jsp").forward(request, response);
      //  response.sendRedirect(request.getContextPath() +"/registration.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, String> messages = new HashMap<String, String>();

        if (userName == null || userName.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please input password");
        }

        request.setAttribute("message", messages);
       // request.getRequestDispatcher("/registration.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() +"/registration.jsp");
    }
}
