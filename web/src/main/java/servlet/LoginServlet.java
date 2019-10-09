package servlet;


import Model.AuthUser;
import com.github.SecurityService;
import com.github.UserService;
import com.github.impl.DefaultSecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Map<String, String> messages = new HashMap<>();

        if (login == null || login.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please input password");
        }

        if (messages.isEmpty()) {
            SecurityService instance = DefaultSecurityService.getInstance();
            AuthUser authUser = instance.userName(login, password);

            if (authUser != null) {
                request.getSession().setAttribute("authUser", authUser);
                response.sendRedirect(request.getContextPath() + "/authUser");
                return;
            } else {
                messages.put("login", "Unknown login, please try again");
            }
        }

        request.setAttribute("message", messages);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
