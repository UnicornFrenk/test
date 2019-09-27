package servlet;
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
        List<User> users = userService.getUsers();
        request.setAttribute("users", users);
        WebUtils.forword("users", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String id = userService.saveUser(new User( name, age, sex));
        log.info("user created:{} at {}", id, LocalDateTime.now());
        try {
            response.sendRedirect(request.getContextPath() + "/users");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }

}
