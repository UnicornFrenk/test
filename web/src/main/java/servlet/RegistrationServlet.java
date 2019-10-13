package servlet;


import Dao.impl.DefaultAuthUserDao;
import Model.AuthUser;
import Model.User;
import com.github.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String login = rq.getParameter("login");
        rq.setAttribute("login", login);
        String password = rq.getParameter("password");
        rq.setAttribute("password",password);

        DefaultAuthUserDao.getInstance().create(new AuthUser(login,password));

        rq.getRequestDispatcher("/login.jsp").forward(rq, rs);
    }
}
