package servlet;
import Model.AuthUser;
import Model.User;
import com.github.impl.DefaultUserService;
import com.github.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UsersServlet.class);
    private UserService userService = DefaultUserService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<AuthUser> users = userService.getAll();
        request.setAttribute("users", users);
        WebUtils.forword("users", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        userService.saveUser(new AuthUser(login,password));
        log.info("user created:{} at {}", login, LocalDateTime.now());
        try {
            response.sendRedirect(request.getContextPath() + "/users");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }

}
