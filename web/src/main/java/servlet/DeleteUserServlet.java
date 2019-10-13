package servlet;

import Model.AuthUser;
import Model.Item;
import com.github.ItemService;
import com.github.UserService;
import com.github.impl.DefaultItemServise;
import com.github.impl.DefaultUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DeleteUserServlet.class);
    private UserService userService = DefaultUserService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        List<AuthUser> users = userService.getAll();
        request.setAttribute("items", users);
        WebUtils.forword("users", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("deleteUser");
        userService.deleteUser(name);
        try {
            response.sendRedirect(request.getContextPath() + "/users");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }
}
