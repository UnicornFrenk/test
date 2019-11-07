package com.github.servlet;
import com.github.PersonService;
import com.github.hib.entity.PersonEntity;
import com.github.impl.DefaultPersonService;
import com.github.model.Person;
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
    private PersonService userService = DefaultPersonService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<Person> users = userService.getAll();
        request.setAttribute("users", users);
        WebUtils.forword("users", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        userService.createPerson(new Person(login,password));
        log.info("user created:{} at {}", login, LocalDateTime.now());
        try {
            response.sendRedirect(request.getContextPath() + "/users");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }

}
