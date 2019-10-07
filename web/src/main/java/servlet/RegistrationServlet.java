package servlet;


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
        String age = rq.getParameter("age");
        String sex = rq.getParameter("sex");
        rq.setAttribute("login", login);
        rq.setAttribute("age", age);
        rq.setAttribute("sex", sex);
        //User user = new User(login,age,sex);
        //UserService.saveUser(user);
        rq.getRequestDispatcher("/user.jsp").forward(rq, rs);



        // forwar jsp user
    }
}
