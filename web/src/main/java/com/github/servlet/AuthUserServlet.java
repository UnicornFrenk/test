package com.github.servlet;

import com.github.impl.DefaultPersonService;
import com.github.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/authUser")
public class AuthUserServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(AuthUserServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        request.setAttribute("login", login);
        String password = request.getParameter("password");
        request.setAttribute("password", password);

        DefaultPersonService.getInstance().createPerson(new Person(login,password));
        request.getRequestDispatcher("/authUser.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        request.setAttribute("login", login);
        try {
            response.sendRedirect(request.getContextPath() + "/authUser");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }

    }
}
